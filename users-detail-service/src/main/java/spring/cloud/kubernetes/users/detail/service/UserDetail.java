package spring.cloud.kubernetes.users.detail.service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "detail")
public class UserDetail {
	
	@Id
	@Column(name = "userId", nullable = false)
	private String userId;

	@Column(name = "phone", nullable = false)
	private String phone;
	
	@Column(name = "email", nullable = false)
	private String email;
	
}
