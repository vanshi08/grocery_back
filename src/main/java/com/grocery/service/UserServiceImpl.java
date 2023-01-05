package com.grocery.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.dto.UserDTO;
import com.grocery.entity.User;
import com.grocery.exception.InvalidCredentialsException;
import com.grocery.exception.UserExistsException;
import com.grocery.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository userRepository;

	@Override
	public User registerUser(UserDTO userdto) throws UserExistsException {
		Optional<User> opt1 = userRepository.findByUserName(userdto.getUserName());
		if(opt1.isPresent()) {
			log.error("user already exists");
			throw new UserExistsException();
		}
		User user = new User();
		user.setUserName(userdto.getUserName());
		user.setPassword(userdto.getPassword());
		user.setMobileNumber(userdto.getMobileNumber());
		user.setEmail(userdto.getEmail());
		return userRepository.save(user);
	}

	@Override
	public User loginUser(UserDTO userdto) throws InvalidCredentialsException {
		String username = userdto.getUserName();
		String password = userdto.getPassword();
		Optional<User> opt = userRepository.findByUserName(username);
		
		if(opt.isPresent() && opt.get().getPassword().equals(password)) {
			return opt.get();
		} 
		throw new InvalidCredentialsException(); 
		}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		
		return userRepository.findById(id).get();
	}

	@Override
	public String deleteById(int id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		
		return "User deleted successfully";
	}

	@Override
	public User UpdateUser(int id, User user) {
		// TODO Auto-generated method stub
		User user1 = userRepository.findById(id).get();
		user1.setUserName(user.getUserName());
		user1.setPassword(user.getPassword());
		user1.setEmail(user.getEmail());
		user1.setMobileNumber(user.getMobileNumber());
		userRepository.save(user1);
		return user1;
	}
	
	
	
	}
