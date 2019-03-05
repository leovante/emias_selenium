package system.service;

import system.model.HltMkabEntity;

import java.util.List;

public interface MkabService<T> {

    HltMkabEntity findById(int id);

    List findByIdList(int id);

    HltMkabEntity findByModel();

    List<T> findAll();

    void save(T t);

    void update(T t);

    void delete(long id);
}
