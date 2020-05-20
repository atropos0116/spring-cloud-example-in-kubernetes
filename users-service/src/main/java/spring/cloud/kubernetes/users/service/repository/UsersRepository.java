package spring.cloud.kubernetes.users.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.cloud.kubernetes.users.service.model.User;

@Repository
public interface UsersRepository extends CrudRepository<User, Long> {
	public User findByUserId(String userId);
}
