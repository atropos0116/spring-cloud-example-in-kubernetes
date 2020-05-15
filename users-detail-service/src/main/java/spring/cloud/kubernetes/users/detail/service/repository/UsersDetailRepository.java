package spring.cloud.kubernetes.users.detail.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.cloud.kubernetes.users.detail.service.model.UserDetail;

@Repository
public interface UsersDetailRepository extends CrudRepository<UserDetail, Long> {
}
