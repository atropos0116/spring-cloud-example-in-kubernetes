package spring.cloud.kubernetes.users.service.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
	
	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			userRepository.save(new User(Long.getLong("1"), "atropos0116", "Terry"));
			userRepository.save(new User(Long.getLong("2"), "atropos0117", "Gibb"));
			userRepository.save(new User(Long.getLong("3"), "atropos0118", "Bob"));
		};
	}
}
