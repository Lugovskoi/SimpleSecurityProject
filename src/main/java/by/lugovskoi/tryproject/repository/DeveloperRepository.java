package by.lugovskoi.tryproject.repository;

import by.lugovskoi.tryproject.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface DeveloperRepository extends JpaRepository<Developer, Long> {
    @Modifying
    @Query("delete from Developer d where d.id = ?1")
    void delete(Long entityId);
}
