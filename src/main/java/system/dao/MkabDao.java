package system.dao;

import system.model.HltMkabEntity;

import java.util.List;

public interface MkabDao<T> {

    HltMkabEntity findById(int id);

    void findByModel();

    List findByIdList(int id);

    List<T> findAll();

    void save(HltMkabEntity hltMkabEntity);

    void update(HltMkabEntity hltMkabEntity);

    void delete(long id);
}
