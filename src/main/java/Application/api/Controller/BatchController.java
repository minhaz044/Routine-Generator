package Application.api.Controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import Application.Dao.AssignRepository;
import Application.Dao.BatchRepository;
import Application.Entity.Assign;
import Application.Entity.Batch;
import Application.Services.BatchService;

@RestController
public class BatchController {
	
	
	 @Autowired private BatchService batchService;

	 
	 @RequestMapping ("/api/batch")
	 public List<Batch> getBatchAll() { 
		 return batchService.batchCheck();
		// return batchService.batchCheck()!=null?batchService.batchCheck():null;

	 }
}
