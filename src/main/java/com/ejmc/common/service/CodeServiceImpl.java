package com.ejmc.common.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejmc.common.dto.CodeDto;
import com.ejmc.common.dto.CodeGroupDto;
import com.ejmc.common.entity.Code;
import com.ejmc.common.entity.CodeGroup;
import com.ejmc.common.entity.CodePk;
import com.ejmc.common.repository.CodeRepository;

@Service
public class CodeServiceImpl implements CodeService{
	
	private final CodeRepository codeRepository;
	private final ModelMapper modelMapper;
	
	@Autowired
	public CodeServiceImpl(CodeRepository codeRepository, ModelMapper modelMapper) {
		this.codeRepository=codeRepository;
		this.modelMapper=modelMapper;
	}
	
	@Override
	public List<CodeDto> findAll() throws Exception {
		List<Code> codeList = codeRepository.findAll();
		return codeList.stream().map(Code -> modelMapper.map(Code, CodeDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<CodeDto> findAllByGroupId(String groupId) throws Exception {
		List<Code> codeList = codeRepository.findByGroupId(groupId);
		return codeList.stream().map(Code -> modelMapper.map(Code, CodeDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public CodeDto findByKey(CodePk codePk) throws Exception {
		Code findCode= codeRepository.findById(codePk).get();
		return modelMapper.map(findCode, CodeDto.class);
	}

	
}
