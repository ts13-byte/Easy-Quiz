package com.exam.examServer.models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="roles")
public class Role {

	@Id
	private Long roleId;
	
	private String roleName;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER,mappedBy="role")
	@JsonIgnore
	private Set<UserRole> userRoles=new HashSet<>();
}
