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
	public User getUser(@PathVariable("userId") String userId) {
		
		String url = "http://users-detail-service:8080/users/detail/" + userId;
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
		System.out.println("Calling via Discovery Client ... " + responseEntity.getBody());
		
		return usersService.getUser(userId);
	}
}
