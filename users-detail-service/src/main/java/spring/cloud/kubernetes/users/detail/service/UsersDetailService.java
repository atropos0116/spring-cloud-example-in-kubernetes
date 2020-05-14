package spring.cloud.kubernetes.users.detail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersDetailService {
	
	@Autowired
	UsersDetailRepository usersDetailRepository;
	
	public UserDetail getUserDetail(String userId) {
		return usersDetailRepository.findByUserId(userId);
	}
}
