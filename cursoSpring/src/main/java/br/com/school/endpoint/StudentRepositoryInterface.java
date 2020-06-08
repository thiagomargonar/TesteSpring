package br.com.school.endpoint;

import br.com.school.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepositoryInterface extends CrudRepository<Student, Long> {

    List<Student> findByName(String name);

    @Query("SELECT name FROM Student where id = :id")
    String SelecionarPorId(@Param("id") Long id);

}
