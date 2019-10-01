package com.system.repositories;

import com.system.model.HltDoctorTimeTableEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

@Component
public class HltDoctorTimeTableRepositoryImpl implements CustomizedDoctorTimeTableRepositoryImpl {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List deleteShedule(int LPUDoctorID, int DocPRVDID) {
        return null;
    }

    @Override
    public List<HltDoctorTimeTableEntity> selectShedule(int LPUDoctorID, int DocPRVDID) {
        TypedQuery<HltDoctorTimeTableEntity> q = em.createQuery("select dtt from HltDoctorTimeTableEntity dtt left outer join HltLpuDoctorEntity ldoc " +
                "on dtt.rfLpuDoctorId = ldoc.lpuDoctorId " +
                "where dtt.date >=  current_timestamp - 7" +
                "AND dtt.rfDocPrvdid = :DocPRVDID " +
                "AND dtt.rfLpuDoctorId = :LPUDoctorID", HltDoctorTimeTableEntity.class);
        q.setParameter("DocPRVDID", DocPRVDID);
        q.setParameter("LPUDoctorID", LPUDoctorID);
        return q.getResultList();
    }

    @Override
    public void createShedule(int LPUDoctorID, int DocPRVDID) throws FileNotFoundException, ParseException {
//        String request = new DateGenerator().shedule_CD(LPUDoctorID, DocPRVDID);
//        em.createQuery("INSERT INTO HltDoctorTimeTableEntity (Begin_Time, End_Time, Date, rf_LPUDoctorID, rf_DocBusyType, FlagAccess, rf_DocPRVDID) VALUES ('2019-05-07 07:00:00.000', '2019-05-07 07:15:00.000', '2019-05-07 00:00:00.000', '1831', '17', '15', '417')");
    }
}