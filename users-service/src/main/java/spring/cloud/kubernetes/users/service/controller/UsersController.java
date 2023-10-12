package spring.cloud.kubernetes.users.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import spring.cloud.kubernetes.users.service.model.User;
import spring.cloud.kubernetes.users.service.service.UsersService;

@RestController
@RequestMapping(value="/users")
public class UsersController {
	
	@Autowired
	UsersService usersService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(value="/{userId}",method = RequestMethod.GET)
	public String getUser(@PathVariable("userId") String userId) {
		System.out.println("Call user detail API - userId : " + userId);
		
		User user = usersService.getUser(userId);
		
		System.out.println(user.toString());
		
		String url = "http://users-detail-service:8080/users/detail/" + user.getId();
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
		System.out.println("Calling via Discovery Client ... " + responseEntity.getBody());
		
		StringBuilder sb = new StringBuilder();
		sb.append(user.toString());
		sb.append(responseEntity.getBody());
		
		return sb.toString();
	}
}
