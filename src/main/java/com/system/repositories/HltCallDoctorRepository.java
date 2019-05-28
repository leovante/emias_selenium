package com.system.repositories;

import com.system.model.HltCallDoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HltCallDoctorRepository extends JpaRepository<HltCallDoctorEntity, Integer>, CustomHltCallDoctorRepository {
    List<HltCallDoctorEntity> findAllByNumberPol(String number);

}
