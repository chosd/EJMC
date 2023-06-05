package com.ejmc.common.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ejmc.SpringBootTestApplication;

class CodeServiceImplTest extends SpringBootTestApplication{
	
	@Autowired
	CodeService codeService;
	
	@Test
	void testFindAll() throws Exception {
		System.out.println(codeService.findAll());
	}

	@Test
	void testFindAllByGroupId() throws Exception {
		System.out.println(codeService.findAllByGroupId("101"));
	}

}
