package com.app.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.app.entities.Admin;
import com.app.entities.Doctor;
import com.app.entities.Patient;
import com.app.entities.UserEntity;

import lombok.Data;
import lombok.ToString;
@ToString
@Data
public class CustomUserDetails implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserEntity user;

	public CustomUserDetails() {
		
	}
	public CustomUserDetails(UserEntity user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// Meaning : This method should ret Collection(List) of granted authorities ,
		// for a specific user --which will be later stored in Auth obj
		//SimpleGrantedAuthority(String roleName)  imple  GrantedAuthority
		//UserEntity ---> Role	
		List<GrantedAuthority> arr = new ArrayList<GrantedAuthority>();
		if(user instanceof Admin) {
			arr.add(new SimpleGrantedAuthority("ROLE_ADMIN"));			
		}else if(user instanceof Doctor) {
			arr.add(new SimpleGrantedAuthority("ROLE_DOCTOR"));	
		}else if(user instanceof Patient) {
			arr.add(new SimpleGrantedAuthority("ROLE_PATIENT"));	
		}
		return arr;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
