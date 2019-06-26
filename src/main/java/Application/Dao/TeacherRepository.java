package Application.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import Application.Entity.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
    @Query("SELECT c FROM Teacher c")
    public List<Teacher> findAll();
	 

}



