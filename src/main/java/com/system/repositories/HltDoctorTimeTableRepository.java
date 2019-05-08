package com.system.repositories;

import com.system.model.HltDoctorTimeTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HltDoctorTimeTableRepository extends JpaRepository<HltDoctorTimeTableEntity, Long>,
        CustomizedDoctorTimeTableRepositoryImpl<HltDoctorTimeTableEntity> {

//    @Query("SELECT mtrId FROM MtrGasEntity mg WHERE mg.mtrId=(:pType)")
//    Optional<MtrGasEntity> getById(@Param("pType") Long id);

}
