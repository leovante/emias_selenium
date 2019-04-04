package system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import system.model.HltMkabEntity;

@Repository
public interface MkabRepository extends JpaRepository<HltMkabEntity, Integer> {

}