package com.zone.ces.ws.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.zone.ces.ws.util.CustomerErrorType;
import com.zone.ces.ws.model.User;
import com.zone.ces.ws.repository.UserRepository;


@RestController
@RequestMapping("/testapi")
public class RestApiController {
	
	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);
	
	@Autowired
	UserRepository userService;
	
	//
	@RequestMapping(value="/user/",method=RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers(){
		logger.info("LSITA DE USUARIOS");
		List<User> users = userService.findAll();
		if(users.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
	//RECUPERAR USUARIO POR ID
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable("id") long id){
		logger.info("User id {}",id);
		//User user = userService.findById(id);
		User user = userService.findById(id).get();
		if(user==null){
			logger.error("Usuario no encontrado",id);
			return new ResponseEntity<>(new CustomerErrorType("EL CODIGO "+id+ " NO FUE ENCONTRADO"),HttpStatus.NOT_FOUND);
		}
	return  new ResponseEntity<User> (user,HttpStatus.OK);
	}
	
	//AGREGAR USUARIO
	@RequestMapping(value="/user/",method=RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder){
		logger.info("CREAR USUARIO",user);
		//if(userService.isUserExist(user)){
		/*
		if(userService.isUserExist(user)){
			logger.error("El usuario existe ",user.getNombre());
			return new ResponseEntity<>(new CustomerErrorType("No se puede registrar el usuario "+user.getNombre()+"ya existe"),HttpStatus.CONFLICT);
		}
		*/
		userService.save(user);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<String>(headers,HttpStatus.CREATED);
	}
	
	
	//MODIFICAR USUARIO
	@RequestMapping(value="/user/{id}",method=RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable("id") long id,@RequestBody User user){
		logger.info("ACTUALZIAR USUARIO", id);
		//User currentUSer =userService.findById(id);
		User currentUSer =userService.findById(id).get();
		
		if(currentUSer ==null){
			logger.error("EL CODIGO NO EXISTE",id);
			return new ResponseEntity<>(new CustomerErrorType("NO SE PUEDE ACTUALIAR EL CODIGO "+id+ "NO EXISTE"),HttpStatus.NOT_FOUND);
		}
		
		currentUSer.setNombre(user.getNombre());
		currentUSer.setNombre(user.getNombre());
		currentUSer.setEdad(user.getEdad());
		
		userService.save(currentUSer);
		return new ResponseEntity<User>(currentUSer,HttpStatus.OK);

	}
	
	//DELETE USUARIO
	@RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") long id){	
		logger.info("ELIMINAR EL USUARIO ",id);
		
		User user = userService.findById(id).get();
		if(user ==null){
			logger.error("EL CODIGO NO EXISTE",id);
			return new ResponseEntity<>(new CustomerErrorType("NO SE PUEDE ELIMIANAR EL CODIGO "+id+ "NO EXISTE"),HttpStatus.NOT_FOUND);
		}
		userService.deleteById(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	
	//ELIMINAR TODOS LOS USUARIOS
	
	public ResponseEntity<User> deteleAllUser(){
		logger.info("ELIMINAR TODOS LOS USUARIOS");
		userService.deleteAll();
		return new  ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	
	
	

}
