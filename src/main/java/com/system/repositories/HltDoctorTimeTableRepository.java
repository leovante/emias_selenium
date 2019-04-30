package com.system.repositories;

import com.system.model.HltDoctorTimeTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HltDoctorTimeTableRepository extends JpaRepository<HltDoctorTimeTableEntity, Long>,
        CustomizedDoctorTimeTableRepositoryImpl<HltDoctorTimeTableEntity> {


}
