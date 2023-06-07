package com.example.racetest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public interface testRepo extends JpaRepository<testEntity, UUID> {
    @Modifying
    @Transactional
    @Query(value = "update test_entity t set balance=:balance where t.used_id=:id",nativeQuery = true)
    void update(@Param("id") UUID id,@Param("balance") int balance);

}