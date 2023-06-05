package com.ejmc.common.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CodeDto {
	private String codeId;
    private String codeName;
	private String codeDesc;
    private CodeGroupDto groupId;
}
