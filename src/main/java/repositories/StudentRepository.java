package repositories;

import model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;


public interface StudentRepository extends JpaRepository<Student,Long> {

    public Collection<Student> findByAgeBetween(Long age, Long age2);

}
