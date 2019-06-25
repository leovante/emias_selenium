package com.system.repositories;

import com.system.model.HltMkabEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HltMkabRepository extends JpaRepository<HltMkabEntity, Long>, CustomHltMkabRepository {

    List<HltMkabEntity> findAll();

    @Query("select mk from HltMkabEntity mk order by mk.mkabid")
    List<HltMkabEntity> findRandom();
}