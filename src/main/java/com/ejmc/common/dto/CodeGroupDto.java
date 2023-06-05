package com.ejmc.common.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CodeGroupDto {
	
	private String groupId;
    private String groupName;
    private String groupDesc;

}







