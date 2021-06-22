package com.UST.Curd.services.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.UST.Curd.services.entity.UserDetails;
import com.UST.Curd.services.exception.WebappException;
import com.UST.Curd.services.repository.UserDetailsRepo;
import com.UST.Curd.services.service.DataService;

@RestController
public class DataController {
	@Autowired
	private DataService dataService;

	@SuppressWarnings("unused")
	@Autowired
	private UserDetailsRepo userDetailsRepo;

	static final Logger logger = Logger.getLogger(DataController.class);

	@GetMapping(value = "/readUserDetails")
	public @ResponseBody ResponseEntity<UserDetails> getUserDetails(
			@RequestParam(value = "username", required = true) String username) {

		try {
			UserDetails status = dataService.getUserService(username);
			return new ResponseEntity<UserDetails>(status, HttpStatus.OK);
		} catch (WebappException e) {
			e.printStackTrace();
			logger.error("Exception :: " + e.getMessage());
			return new ResponseEntity<UserDetails>(new UserDetails(), e.getErrorCode());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception :: " + e.getMessage());
			return new ResponseEntity<UserDetails>(new UserDetails(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/fetchAllUserDetails")
	public @ResponseBody ResponseEntity<List<com.UST.Curd.services.dao.UserDetails>> fetchAllUserDetails() {

		try {
			List<com.UST.Curd.services.dao.UserDetails> status = dataService.fetchAllUserDetails();
			return new ResponseEntity<List<com.UST.Curd.services.dao.UserDetails>>(status, HttpStatus.OK);
		} catch (WebappException e) {
			e.printStackTrace();
			logger.error("Exception :: " + e.getMessage());
			return new ResponseEntity<List<com.UST.Curd.services.dao.UserDetails>>(Arrays.asList(new com.UST.Curd.services.dao.UserDetails()), e.getErrorCode());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception :: " + e.getMessage());
			return new ResponseEntity<List<com.UST.Curd.services.dao.UserDetails>>(Arrays.asList(new com.UST.Curd.services.dao.UserDetails()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "/createUserDetails")
	public @ResponseBody ResponseEntity<Boolean> addUserDetails(
			@RequestBody com.UST.Curd.services.dao.UserDetails userDetails) {

		try {
			boolean status = dataService.addUserService(userDetails);
			return new ResponseEntity<Boolean>(status, HttpStatus.OK);
		} catch (WebappException e) {
			e.printStackTrace();
			logger.error("Exception :: " + e.getMessage());
			return new ResponseEntity<Boolean>(false, e.getErrorCode());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception :: " + e.getMessage());
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = "/deleteUserDetails")
	public @ResponseBody ResponseEntity<Boolean> deleteUserDetails(
			@RequestBody com.UST.Curd.services.dao.UserDetails userDetails) {

		try {
			boolean status = dataService.deleteUserService(userDetails);
			return new ResponseEntity<Boolean>(status, HttpStatus.OK);
		} catch (WebappException e) {
			e.printStackTrace();
			logger.error("Exception :: " + e.getMessage());
			return new ResponseEntity<Boolean>(false, e.getErrorCode());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception :: " + e.getMessage());
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = "/updateUserDetails")
	public @ResponseBody ResponseEntity<Boolean> updateUserDetails(
			@RequestBody com.UST.Curd.services.dao.UserDetails userDetails) {

		try {
			boolean status = dataService.updateUserService(userDetails);
			return new ResponseEntity<Boolean>(status, HttpStatus.OK);
		} catch (WebappException e) {
			e.printStackTrace();
			logger.error("Exception :: " + e.getMessage());
			return new ResponseEntity<Boolean>(false, e.getErrorCode());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception :: " + e.getMessage());
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}