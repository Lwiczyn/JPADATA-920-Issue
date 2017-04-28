package com.example.exists.bug.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.exists.bug.entities.TestEntity;

@Repository
public interface TestEntityRepository
		extends PagingAndSortingRepository<TestEntity, Serializable>, JpaSpecificationExecutor<TestEntity> {

	boolean existsByParent(String parent);

}
