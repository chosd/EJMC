package com.ejmc.common.service;

import java.util.List;

import com.ejmc.common.dto.CodeDto;
import com.ejmc.common.entity.CodePk;

public interface CodeService {
	
	List<CodeDto> findAll() throws Exception;
	List<CodeDto> findAllByGroupId(String groupId) throws Exception;
	CodeDto findByKey(CodePk codePk) throws Exception;
}
