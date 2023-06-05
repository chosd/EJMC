package com.ejmc.common.service;

import java.util.List;

import com.ejmc.common.dto.CodeGroupDto;


public interface CodeGroupService {
	List<CodeGroupDto> findAll() throws Exception;
	
	/*
	 * 
	 */
	CodeGroupDto findCommon(String groupId) throws Exception;
	
	/*
	 * 
	 */
	List<CodeGroupDto> findCommonList(String parent) throws Exception;


}