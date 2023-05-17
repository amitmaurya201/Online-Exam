package com.adjecti.oexam.service.Impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.adjecti.oexam.entity.Authority;
import com.adjecti.oexam.entity.Role;
import com.adjecti.oexam.entity.User;


public class CustomUserDetails implements UserDetails {

	private User user;
	private Set<Role> userRoles = new HashSet<>();;

	CustomUserDetails(User user) {
		this.user = user;
		this.userRoles = user.getRoles();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Authority> set = new HashSet<>();

		this.userRoles.forEach(userRoles -> {
			set.add(new Authority(userRoles.getRole()));
		});

		return set;

	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {

		return user.getUserId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
