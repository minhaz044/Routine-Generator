package Application.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import Application.Entity.Assign;
import Application.Entity.Teacher;

public interface AssignRepository  extends CrudRepository<Assign, Integer>{
	

    @Query("SELECT a FROM Assign a")
    public List<Assign> findAll();
	

    @Query("SELECT a FROM Assign a WHERE a.batch_id=:batch_id")
    public List<Assign> findBybatchId(@Param("batch_id") int batch_id);
    
    @Query("SELECT a FROM Assign a WHERE a.teacher_id=:teacher_id")
    public List<Assign> findbyTeacherId(@Param("teacher_id") int teacher_id);
}
