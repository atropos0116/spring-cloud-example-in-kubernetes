package spring.cloud.kubernetes.users.detail.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDetailRepository extends CrudRepository<UserDetail, String> {
	public UserDetail findByUserId(String userId);
}
