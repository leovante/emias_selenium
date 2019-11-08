package com.system.repositories;

import com.system.model.HltCallDoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface HltCallDoctorRepository extends JpaRepository<HltCallDoctorEntity, Integer>, CustomHltCallDoctorRepository {

    @Query(value = "select cd from HltCallDoctorEntity cd where cd.numberPol = :numberPol and cd.rfCallDoctorStatusId in (2,5,7)")
    List<HltCallDoctorEntity> findAllByNumberPolAndRfCallDoctorStatusId(@Param("numberPol") String numberPol);

    @Query("select cd from HltCallDoctorEntity cd where cd.rfCallDoctorStatusId in (2,5,7)")
    Stream<HltCallDoctorEntity> findAllNotClosed();
}