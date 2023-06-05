package com.ejmc.common.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ejmc.common.dto.CodeDto;
import com.ejmc.common.dto.CodeGroupDto;
import com.ejmc.common.entity.CodePk;
import com.ejmc.common.service.CodeService;
import com.ejmc.common.service.CodeGroupService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


/*
	1. GET    - /guest : 모든 데이터를 요청한다.
	2. POST   - /guest : 데이터를 추가한다.
	3. GET    - /guest/n : n번째 데이터를 요청한다.
	4. PUT    - /guest/n : n번째 데이터를 수정한다.
	5. DELETE - /guest/n : n번째 데이터를 제거한다.
*/

@Tag(name = "2차 과제", description = "템플릿 API Document")
@RestController
public class CommonRestController {
	
	private CodeGroupService commonService;
	private CodeService codeService;
	
	@Autowired
	public CommonRestController(CodeGroupService commonService, CodeService codeService) {
		this.commonService=commonService;
		this.codeService=codeService;
	}
	
//	@Operation(summary = "공통코드그룹 전체조회")
//    @GetMapping(value = "/common", produces = "application/json;charset=UTF-8")
//    public ResponseEntity<Object> findAllCommon() {
//        try {
//        	List<CommonCodeDto> codeDtoList = commonService.findAll();
//        	HttpHeaders headers = new HttpHeaders();
//            headers.set("success", "true");
//            headers.set("code", "0");
//			return ResponseEntity.ok()
//			        .headers(headers)
//			        .body(codeDtoList);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.status(500).body(e.getMessage());
//		}
//    }
	
	@Operation(summary = "공통코드그룹 세부조회")
    @GetMapping(value = "/common/groupId={groupId}", produces = "application/json;charset=UTF-8")
    public Response findCommon(@PathVariable(value = "groupId") String groupId) {
		Response response = new Response();
        try {
        	CodeGroupDto codeDto = commonService.findCommon(groupId);
        	if (codeDto==null) {
    			throw new Exception("조회실패");
    		}
    		response.setStatus(ResponseStatusCode.READ_CODEGROUP);
    		response.setMessage("공통코드그룹 세부조회");
    		response.setData(codeDto);
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(ResponseStatusCode.NOT_FOUND_CODEGROUP);
			response.setMessage(e.getMessage());
			response.setData(new HashMap<>());
			return response;
		}
        
    }
	
	@Operation(summary = "공통코드그룹 상위코드조회 [리스트]")
    @GetMapping(value = "/common/parent={parent}", produces = "application/json;charset=UTF-8")
    public Response findCommonList(@PathVariable(value = "parent") String parent) {
		Response response = new Response();
        try {
        	List<CodeGroupDto> codeDtoList = commonService.findCommonList(parent);
        	if (codeDtoList==null || codeDtoList.isEmpty()) {
    			throw new Exception("조회실패");
    		}
        	response.setStatus(ResponseStatusCode.READ_CODEGROUP);
    		response.setMessage("공통코드그룹 상위코드조회");
    		response.setData(codeDtoList);
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(ResponseStatusCode.NOT_FOUND_CODEGROUP);
			response.setMessage(e.getMessage());
			response.setData(new HashMap<>());
			return response;
		}
    }
	
	@Operation(summary = "코드 전체조회 [리스트]")
    @GetMapping(value = "/common/code", produces = "application/json;charset=UTF-8")
    public Response findCodeList() {
		Response response = new Response();
        try {
        	List<CodeDto> codeDtoList = codeService.findAll();
        	if (codeDtoList==null || codeDtoList.isEmpty()) {
    			throw new Exception("조회실패");
    		}
        	response.setStatus(ResponseStatusCode.READ_CODE);
    		response.setMessage("코드조회");
    		response.setData(codeDtoList);
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(ResponseStatusCode.NOT_FOUND_CODE);
			response.setMessage(e.getMessage());
			response.setData(new HashMap<>());
			return response;
		}
    }
	
	@Operation(summary = "코드 선택조회", description = "조회한다.")
    @GetMapping(value = "/common/code/codeId={codeId}&groupId={groupId}", produces = "application/json;charset=UTF-8")
    public Response findCode(@PathVariable(value = "codeId") String codeId,
    							 @PathVariable(value = "groupId") String groupId) {
		Response response = new Response();
        try {
        	CodeDto findcode = codeService.findByKey(CodePk.builder().codeId(codeId).groupId(groupId).build());
        	if (findcode==null) {
    			throw new Exception("조회실패");
    		}
        	response.setStatus(ResponseStatusCode.READ_CODE);
    		response.setMessage("코드조회");
    		response.setData(findcode);
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(ResponseStatusCode.NOT_FOUND_CODE);
			response.setMessage(e.getMessage());
			response.setData(new HashMap<>());
			return response;
		}
    }
	
	
	
}

