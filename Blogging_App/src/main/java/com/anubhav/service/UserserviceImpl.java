package com.anubhav.service;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anubhav.entity.User;
import com.anubhav.exceptions.ResourceNotFoundException;
import com.anubhav.payloads.UserDto;
import com.anubhav.repository.UserRepo;

@Service
public class UserserviceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	public User dtoToUser(UserDto dto) {
		User user = new User();
		user.setId(dto.getId());
		user.setEmail(dto.getEmail());
		user.setAbout(dto.getAbout());
		user.setName(dto.getName());
	    user.setPassword(dto.getPassword());
	    return user;
	}
	
	public UserDto userToDto(User user) {
		UserDto dto = new UserDto();
		dto.setAbout(user.getAbout());
		dto.setEmail(user.getEmail());
		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setPassword(user.getPassword());
		return dto;
	}
	
	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user = this.dtoToUser(userDto);
		User savedUser=this.userRepo.save(user);
  
		return this.userToDto(savedUser); 
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {


		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User user1 = this.userRepo.save(user);
		return this.userToDto(user1);
	}

	@Override
	public UserDto getUserById(Integer userId) {
		
		
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User" ,"Id",userId));
		
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		
		List<User> list=this.userRepo.findAll();
		List<UserDto> userDtos= list.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
	 User user=	this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException ("User","ID",userId));
	this.userRepo.delete(user);
	}

}
