package com.system.repositories;

import com.system.model.HltDispCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HltDispCardRepository extends JpaRepository<HltDispCardEntity, Long> {
    HltDispCardEntity getByDispCardId(int number);
}