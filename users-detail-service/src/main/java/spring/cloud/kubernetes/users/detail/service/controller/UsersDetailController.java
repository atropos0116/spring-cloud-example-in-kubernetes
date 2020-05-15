package spring.cloud.kubernetes.users.detail.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.cloud.kubernetes.users.detail.service.model.UserDetail;
import spring.cloud.kubernetes.users.detail.service.service.UsersDetailService;

@RestController
@RequestMapping("/users/detail")
public class UsersDetailController {

	@Autowired
	UsersDetailService usersDetailService;
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public String getUserDetail(@PathVariable("id") Long id) {
		
		System.out.println("Call user detail API - id : " + id);
		
		UserDetail detail = usersDetailService.getUserDetail(id);
		
		System.out.println(detail.toString());
		
		return detail.toString();
	}
}
