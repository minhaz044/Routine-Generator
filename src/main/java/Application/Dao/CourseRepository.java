package Application.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import Application.Entity.Assign;
import Application.Entity.Course;

public interface CourseRepository extends CrudRepository<Course, Integer>{
    @Query("SELECT c FROM Course c")
    public List<Course> findAll();

}
