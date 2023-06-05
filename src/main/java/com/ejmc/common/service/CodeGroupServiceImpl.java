package com.ejmc.common.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejmc.common.dto.CodeGroupDto;
import com.ejmc.common.entity.CodeGroup;
import com.ejmc.common.repository.CodeGroupRepository;

@Service
public class CodeGroupServiceImpl implements CodeGroupService{
	
	private final CodeGroupRepository codeGroupRepositoryc;
	private final ModelMapper modelMapper;
	
	@Autowired
	public CodeGroupServiceImpl(CodeGroupRepository codeGroupRepositoryc, ModelMapper modelMapper) {
		this.codeGroupRepositoryc=codeGroupRepositoryc;
		this.modelMapper=modelMapper;
	}
	
	@Override
	public List<CodeGroupDto> findAll() throws Exception {
		List<CodeGroup> commonCodeList = codeGroupRepositoryc.findAll();
		return commonCodeList.stream().map(CommonCode -> modelMapper.map(CommonCode, CodeGroupDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	public CodeGroupDto findCommon(String groupId) throws Exception {
		Optional<CodeGroup> optionalCommonCode= codeGroupRepositoryc.findById(groupId);
		CodeGroup findCommonCode = optionalCommonCode.get();
		return modelMapper.map(findCommonCode, CodeGroupDto.class);
	}

	@Override
	public List<CodeGroupDto> findCommonList(String parent) throws Exception {
		List<CodeGroup> commonCodeList = codeGroupRepositoryc.findByParentGroupId(parent);
		return commonCodeList.stream().map(CommonCode -> modelMapper.map(CommonCode, CodeGroupDto.class))
				.collect(Collectors.toList());
	}

	
}
