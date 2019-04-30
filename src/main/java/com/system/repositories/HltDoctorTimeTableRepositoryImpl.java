package com.system.repositories;

import com.system.model.HltDoctorTimeTableEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class HltDoctorTimeTableRepositoryImpl implements CustomizedDoctorTimeTableRepositoryImpl {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List deleteShedule(int LPUDoctorID, int DocPRVDID) {
        TypedQuery<HltDoctorTimeTableEntity> q = em.createQuery("select dtt from HltDoctorTimeTableEntity dtt left outer join HltLpuDoctorEntity ldoc " +
                "on dtt.rfLpuDoctorId = ldoc.lpuDoctorId " +
                "where dtt.Date >= DATEADD(dd, ((DATEDIFF(dd, '17530101', GETDATE()) / 7) * 7) - 7, '17530101') " +
                "AND dtt.rf_DocPRVDID = :DocPRVDID " +
                "AND dtt.rf_LPUDoctorID = :LPUDoctorID", HltDoctorTimeTableEntity.class);
        q.setParameter("LPUDoctorID", LPUDoctorID);
        q.setParameter("DocPRVDID", DocPRVDID);
        return q.getResultList();
    }
}