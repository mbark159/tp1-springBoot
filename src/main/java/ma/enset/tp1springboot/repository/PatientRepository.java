package ma.enset.tp1springboot.repository;

import ma.enset.tp1springboot.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.nom = :nom, p.score = :score, p.dateNaissance= :dnaissance, p.malade= :maladee WHERE p.id = :id")
    void updatePatient(@Param("id") Long id, @Param("nom") String nom, @Param("score") int scr, @Param("dnaissance")Date dnc, @Param("maladee") boolean mld);


//    @Modifying
//    @Query("UPDATE Patient p SET p.nom= :n,p.score = :s where p.id = :p")
//    Void update(@Param("ii") Long id,@Param("n") String nom, @Param("s")int score);
}
