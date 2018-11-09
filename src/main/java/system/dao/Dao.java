package system.dao;

public interface Dao<T> {
//    Optional<T> get(long id);

//    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete(T t);
}
