package system.dao;

import system.model.HltMkabEntity;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> findById(Long id);

    List<T> findAll();

    void save(HltMkabEntity hltMkabEntity);

    void update(HltMkabEntity hltMkabEntity);

    void delete(HltMkabEntity hltMkabEntity);
}
