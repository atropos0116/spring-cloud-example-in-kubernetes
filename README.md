# spring-cloud-example-in-kubernetes

## 1. Google Cloud Platform
- `https://cloud.google.com/` -> `Go to console` -> Create `New Project`
- `https://console.cloud.google.com/kubernetes/` -> Create `Cluster'
- Active `Cloud Shell`

## 2. Git clone
```
git clone https://github.com/atropos0116/spring-cloud-example-in-kubernetes.git --branch develop-gcr
```

## 3. Container Registry
Change [YOUR_PROJECT_ID] to your project ID.

```
./mvnw com.google.cloud.tools:jib-maven-plugin:build -Dimage=gcr.io/[YOUR_PROJECT_ID]/config-server:v1
./mvnw com.google.cloud.tools:jib-maven-plugin:build -Dimage=gcr.io/[YOUR_PROJECT_ID]/users-service:v1
./mvnw com.google.cloud.tools:jib-maven-plugin:build -Dimage=gcr.io/[YOUR_PROJECT_ID]/users-detail-service:v1
```

## 4. gcloud Login
Changes [YOUR_CLUSTER_NAME] and [YOUR_ZONE] to `your cluster name` and `your project ID.`

```
gcloud container clusters get-credentials [YOUR_CLUSTER_NAME] --zone [YOUR_ZONE]
```

## 5. Change skaffold.yml and deploy.yml
skaffold.yml
```
artifacts:
    - image: gcr.io/[YOUR_PROJECT_ID]/config-server
      kaniko:
        dockerfile: config-server/Dockerfile
        image: gcr.io/[YOUR_PROJECT_ID]/config-server
    - image: gcr.io/[YOUR_PROJECT_ID]/users-service
      kaniko:
        dockerfile: users-service/Dockerfile
        image: gcr.io/[YOUR_PROJECT_ID]/users-service
    - image: gcr.io/[YOUR_PROJECT_ID]/users-detail-service
      kaniko:
        dockerfile: users-detail-service/Dockerfile
        image: gcr.io/[YOUR_PROJECT_ID]/users-detail-service
  googleCloudBuild:
    projectId: [YOUR_PROJECT_ID]
    dockerImage: gcr.io/cloud-builders/docker
```

config-server/deploy-dev.yml, 
config-server/deploy-stg.yml
```
spec:
  selector:
    matchLabels:
      app: config-server
  replicas: 1
  template:
    metadata:
      name: config-server
      labels:
        app: config-server
    spec:
      containers:
      - name: config-server
        image: gcr.io/[YOUR_PROJECT_ID]/config-server:v1
```

users-service/deploy-dev.yml,
users-service/deploy-stg.yml
```
spec:
  selector:
    matchLabels:
      app: users-service
  replicas: 1
  template:
    metadata:
      name: users-service
      labels:
        app: users-service
    spec:
      containers:
      - name: users-service
        env:
          - name: POSTGRES_USER
            valueFrom:
              configMapKeyRef:
                name: users-postgres-config
                key: postgres_user
          - name: POSTGRES_PASSWORD
            valueFrom:
              configMapKeyRef:
                name: users-postgres-config
                key: postgres_password
          - name: POSTGRES_HOST
            valueFrom:
              configMapKeyRef:
                name: users-postgres-config
                key: postgres_host
        image: gcr.io/nifty[YOUR_PROJECT_ID]/users-service:v1
        ports:
          - containerPort: 8082
```

users-detail-service/deploy-dev.yml,
users-detail-service/deploy-stg.yml
```
spec:
  selector:
    matchLabels:
      app: users-detail-service
  replicas: 1
  template:
    metadata:
      name: users-detail-service
      labels:
        app: users-detail-service
    spec:
      containers:
      - name: users-detail-service
        env:
          - name: POSTGRES_USER
            valueFrom:
              configMapKeyRef:
                name: detail-postgres-config
                key: postgres_user
          - name: POSTGRES_PASSWORD
            valueFrom:
              configMapKeyRef:
                name: detail-postgres-config
                key: postgres_password
          - name: POSTGRES_HOST
            valueFrom:
              configMapKeyRef:
                name: detail-postgres-config
                key: postgres_host
        image: gcr.io/[YOUR_PROJECT_ID]/users-detail-service:v1
        ports:
          - containerPort: 8081
```


## 6. Skaffold dev
profile : dev
```
cd config-server
skaffold run -p dev

cd users-service
skaffold run -p dev

cd users-detail-service
skaffold dev -p dev
```

profile : stg
```
cd config-server
skaffold run -p stg

cd users-service
skaffold run -p stg

cd users-detail-service
skaffold dev -p stg
```

## 7. Test
```
http://[your Service IP]:8080/users/atropos0116
```

## 8. Skaffold Clean up
```
Ctrl + C or skaffold delete -p dev or skaffold delete -p stg
```

