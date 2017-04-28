package com.example.exists.bug.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.exists.bug.entities.TestEntity;
import com.example.exists.bug.entities.TestEntity.TestEntityPK;

/**
 * A repository for entities that have a compound primary key implemented
 * with @IdClass. Adding the existsBy() projection causes the test case to throw
 * an NPE due to AbstractPersistable_id being null. Why it is null is the
 * mystery.
 *
 */

@Repository
public interface TestEntityRepository
		extends PagingAndSortingRepository<TestEntity, TestEntityPK>, JpaSpecificationExecutor<TestEntity> {

	boolean existsByParent(String parent);

}
