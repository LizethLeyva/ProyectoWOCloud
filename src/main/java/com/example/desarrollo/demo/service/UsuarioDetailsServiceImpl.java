package com.example.desarrollo.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.desarrollo.demo.hospital.MedicoUser;
import com.example.desarrollo.demo.repository.MedicoUserRepository;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {
	private MedicoUserRepository medicoUserRepository;

	public UsuarioDetailsServiceImpl(MedicoUserRepository medicoUserRepository) {
		this.medicoUserRepository = medicoUserRepository;
	}
	
	@Transactional
	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		MedicoUser user = medicoUserRepository.findByUsuario(usuario);

		if (user == null) {
			throw new UsernameNotFoundException(usuario);
		}
		
		List<SimpleGrantedAuthority> roles = getRoles(user);

		return new org.springframework.security.core.userdetails.User
				(user.getUsuario(), user.getPassword(), roles);
	}

	private List<SimpleGrantedAuthority> getRoles(MedicoUser user) {
		List<SimpleGrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("ROLE_" + user.getRol().getName()));
		
		return roles;
	}
}
