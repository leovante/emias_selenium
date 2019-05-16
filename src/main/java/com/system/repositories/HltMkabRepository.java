package com.system.repositories;

import com.system.model.HltMkabEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HltMkabRepository extends JpaRepository<HltMkabEntity, Integer>, CustomHltMkabRepository {

}