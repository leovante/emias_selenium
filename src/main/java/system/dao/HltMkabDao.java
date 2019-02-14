package system.dao;

import system.model.HltMkabEntity;

import java.util.List;
import java.util.Optional;

public class HltMkabDao implements Dao<HltMkabEntity> {
//    public static final String SQL_FIND_ALL = "select * from " + HltMkabEntity
//    public static final String SQL_FIND_BY_ID =

    @Override
    public Optional<HltMkabEntity> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<HltMkabEntity> findAll() {
        return null;
    }

    @Override
    public void save(HltMkabEntity hltMkabEntity) {

    }

    @Override
    public void update(HltMkabEntity hltMkabEntity) {

    }

    @Override
    public void delete(HltMkabEntity hltMkabEntity) {

    }
}
