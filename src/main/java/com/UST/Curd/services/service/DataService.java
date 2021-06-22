package com.UST.Curd.services.service;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.UST.Curd.services.entity.UserDetails;

/**
 * @author kovoor.prajwal
 * @Date : June, 2021
 *
 */

public interface DataService {
	public UserDetails getUserService(String authUsername) throws Exception;

	public boolean addUserService(com.UST.Curd.services.dao.UserDetails userDetails) throws Exception;

	boolean deleteUserService(com.UST.Curd.services.dao.UserDetails userDetails) throws Exception;

	boolean updateUserService(com.UST.Curd.services.dao.UserDetails userDetails) throws Exception;

	public List<com.UST.Curd.services.dao.UserDetails> fetchAllUserDetails() throws Exception;
}