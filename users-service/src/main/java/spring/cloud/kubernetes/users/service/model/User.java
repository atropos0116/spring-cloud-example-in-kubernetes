package spring.cloud.kubernetes.users.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@Entity
@ToString
@Table(name = "users")
public class User {
	
	public User() { }
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "userid", nullable = false)
	private String userId;

	@Column(name = "name", nullable = false)
	private String name;

}
