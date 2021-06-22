package com.UST.Curd.services.service.impl;

import com.UST.Curd.services.entity.UserDetails;
import com.UST.Curd.services.exception.WebappException;
import com.UST.Curd.services.repository.UserDetailsRepo;
import com.UST.Curd.services.service.DataService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * @author kovoor.prajwal
 * @Date : June, 2021
 *
 */
@Service
public class DataServiceImpl implements DataService {

	@Autowired
	UserDetailsRepo userDetailsRepo;

	@Override
	public UserDetails getUserService(String username) throws Exception {
		UserDetails ud = null;

		com.UST.Curd.services.dao.UserDetails userDetails = userDetailsRepo.findById(username)
				.orElseThrow(() -> new WebappException(HttpStatus.NO_CONTENT, "User does not exists"));

		ud = new UserDetails();
		ud.setUsername(userDetails.getUsername());
		ud.setUserEmail(userDetails.getEmail());
		ud.setUserRole(userDetails.getRole());

		return ud;

	}

	@Override
	public boolean addUserService(com.UST.Curd.services.dao.UserDetails userDetails) throws Exception {

		if (!userDetailsRepo.findById(userDetails.getUsername()).isPresent()) {
			userDetailsRepo.save(userDetails);
			return true;
		} else {
			throw new WebappException(HttpStatus.CONFLICT, "User already exists");
		}
	}

	@Override
	public boolean deleteUserService(com.UST.Curd.services.dao.UserDetails userDetails) throws Exception {
		if (userDetailsRepo.findById(userDetails.getUsername()).isPresent()) {
			userDetailsRepo.delete(userDetails);
			return true;
		} else {
			throw new WebappException(HttpStatus.CONFLICT, "User doesnt exists");
		}
	}

	@Override
	public boolean updateUserService(com.UST.Curd.services.dao.UserDetails userDetails) throws Exception {

		Optional<com.UST.Curd.services.dao.UserDetails> user = userDetailsRepo.findById(userDetails.getUsername());
		if (user.isPresent()) {
			user.get().setEmail(userDetails.getEmail());
			user.get().setRole(userDetails.getRole());
			userDetailsRepo.save(user.get());
			return true;
		} else {
			throw new WebappException(HttpStatus.CONFLICT, "User doesnt exists");
		}

	}

	@Override
	public List<com.UST.Curd.services.dao.UserDetails> fetchAllUserDetails() throws Exception {
		List<com.UST.Curd.services.dao.UserDetails> result= new ArrayList<com.UST.Curd.services.dao.UserDetails>();
		result = userDetailsRepo.findAll();
		if(result.size()==0) {
			throw new WebappException(HttpStatus.NO_CONTENT, "User does not exists");
		}
		return result;
	}

}