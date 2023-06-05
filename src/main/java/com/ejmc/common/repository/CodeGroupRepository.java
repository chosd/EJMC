package com.ejmc.common.repository;

import java.util.List;
import java.util.Optional;

import com.ejmc.common.entity.CodeGroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CodeGroupRepository extends JpaRepository<CodeGroup, String> {
	List<CodeGroup> findByParentGroupId(String parent);
}
