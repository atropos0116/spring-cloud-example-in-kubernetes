package spring.cloud.kubernetes.users.detail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/detail")
public class UsersDetailController {

	@Autowired
	UsersDetailService usersDetailService;
	
	@RequestMapping(value="/{userId}",method = RequestMethod.GET)
	public UserDetail getUserDetail(@PathVariable("userId") String userId) {
		
		System.out.println("Call user detail API - userId : " + userId);
		
		return usersDetailService.getUserDetail(userId);
	}
}
