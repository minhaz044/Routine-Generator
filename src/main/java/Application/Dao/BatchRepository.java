package Application.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import Application.Entity.Assign;
import Application.Entity.Batch;

public interface BatchRepository  extends CrudRepository<Batch, Integer>{

    @Query("SELECT b FROM Batch b")
    public List<Batch> findAll();

}
