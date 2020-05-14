package spring.cloud.kubernetes.users.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.cloud.kubernetes.users.service.model.User;
import spring.cloud.kubernetes.users.service.repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	UsersRepository userRepository;
	
	public User getUser(String userId) {
		return userRepository.findByUserId(userId);
	}
}
