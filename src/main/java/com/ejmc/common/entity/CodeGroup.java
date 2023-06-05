package com.ejmc.common.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "codegroup")
public class CodeGroup{
	
	@Id
    @Column(name = "group_id", length = 30, updatable = false)
    private String groupId;

    @Column(nullable = false, length = 30)
    private String groupName;
    
    @Column(nullable = true, length = 60)
	private String groupDesc;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "group_id")
    private CodeGroup parent;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CodeGroup> children;
}

