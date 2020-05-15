package spring.cloud.kubernetes.users.detail.service.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import spring.cloud.kubernetes.users.detail.service.model.UserDetail;
import spring.cloud.kubernetes.users.detail.service.repository.UsersDetailRepository;

@Service
public class UsersDetailService {
	
	@Autowired
	UsersDetailRepository usersDetailRepository;
	
	public UserDetail getUserDetail(Long id) {
		return usersDetailRepository.findById(id).get();
	}
	
	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			usersDetailRepository.save(new UserDetail(Long.getLong("1"), "atropos0116", "010-0000-0000", "atropos0116@gmail.com"));
			usersDetailRepository.save(new UserDetail(Long.getLong("2"), "atropos0117", "010-0001-0000", "atropos0117@gmail.com"));
			usersDetailRepository.save(new UserDetail(Long.getLong("3"), "atropos0118", "010-0002-0000", "atropos0118@gmail.com"));
		};
	}
}
