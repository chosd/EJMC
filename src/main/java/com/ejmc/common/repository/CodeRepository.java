package com.ejmc.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejmc.common.entity.Code;
import com.ejmc.common.entity.CodePk;

@Repository
public interface CodeRepository extends JpaRepository<Code, CodePk>{
	List<Code> findByGroupId(String groupId);
}
