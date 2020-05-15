package spring.cloud.kubernetes.users.detail.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@Builder
@AllArgsConstructor
@ToString
@Entity
@Table(name = "user_detail")
public class UserDetail {
	
	public UserDetail() { }
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "userid", nullable = false)
	private String userId;

	@Column(name = "phone", nullable = false)
	private String phone;
	
	@Column(name = "email", nullable = false)
	private String email;
	
}
