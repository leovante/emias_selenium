package com.system.repositories;

import com.system.model.HltCallDoctorEntity;
import com.system.model.HltDispServiceDocPrvd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface HltDispServiceDocPrvdRepository extends JpaRepository<HltDispServiceDocPrvd, Integer> {
    @Query("select sdp from HltDispServiceDocPrvd sdp where sdp.dispServiceDocPrvdId > 0")
    List<HltDispServiceDocPrvd> getHltDispServiceDocPrvd();

    @Query("delete from HltDispServiceDocPrvd sdp where sdp.dispServiceDocPrvdId > 0")
    void deleteAll();
}