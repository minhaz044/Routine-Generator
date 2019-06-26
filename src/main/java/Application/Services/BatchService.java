package Application.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Application.Dao.AssignRepository;
import Application.Dao.BatchRepository;
import Application.Entity.Assign;
import Application.Entity.Batch;

@Service
public class BatchService {
	@Autowired
	private BatchRepository BatchRepo;
	@Autowired
	private AssignRepository AssignRepo;
	

	public List<Batch> batchCheck() {
		List<Assign> assign_list =AssignRepo.findAll();
		List<Batch> batch_list =BatchRepo.findAll();
		List<Batch> New_batch_list = new ArrayList<Batch>();
		if(batch_list==null) {
			return null;
		}
		if (assign_list==null) {
			return batch_list;
		}else {
			for(Batch batch : batch_list) {
				 if(AssignRepo.findBybatchId(batch.getBatch_id()).size()<2) {
				 New_batch_list.add(batch); } 
			}
			return New_batch_list;
		}
}
}






















