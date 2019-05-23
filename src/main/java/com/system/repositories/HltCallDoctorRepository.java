package com.system.repositories;

import com.system.model.HltCallDoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HltCallDoctorRepository extends JpaRepository<HltCallDoctorEntity, Integer> {
    List<HltCallDoctorEntity> findAllByNumberPol(String number);
}
