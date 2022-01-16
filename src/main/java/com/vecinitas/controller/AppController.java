package com.vecinitas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.vecinitas.model.Vecinita;
import com.vecinitas.security.MyUserService;
import com.vecinitas.utils.Convertidores;
import com.vecinitas.utils.JWTUtility;
import com.vecinitas.dao.VecinitaDAO;
import com.vecinitas.entities.security.AuthenticationRequest;
import com.vecinitas.entities.security.AuthenticationResponse;

@RestController
public class AppController {
	
	@Autowired
	Convertidores convert;
	
	@Autowired
	VecinitaDAO veciDAO;
	
	@Autowired
	JWTUtility jWTUtility;
	
	@Autowired
	MyUserService userService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@GetMapping("/vecina")
	@ResponseBody
		public Vecinita mostrarVecina(@RequestParam  String id ) {
		Integer idOK= Integer.parseInt(id);
		Optional<Vecinita> vecOPT=  veciDAO.findById(idOK);
		  Vecinita vecinita = vecOPT.get();		
			return vecinita;
			}
	
	@GetMapping("/todas")
	@ResponseBody
		public List<Vecinita> mostrarTodas() {		
		List<Vecinita> todasVecinas=  veciDAO.findAll();		 	
			return todasVecinas;
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authRequest)
	throws Exception {
		try {
			authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch(BadCredentialsException e) {
			throw new Exception("Incorrect credentials");
		}
		
		final UserDetails userDetails = userService
				.loadUserByUsername(authRequest.getUsername());
		final String jwt = jWTUtility.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}
