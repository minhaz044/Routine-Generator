package Application.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Application.Dao.AssignRepository;
import Application.Entity.Assign;

@RestController
public class AssignController {
	@Autowired
	private AssignRepository assignRepo;
	
	@RequestMapping(value="/api/assigncourse",method=RequestMethod.POST)
	protected Assign AssignCourse(@RequestBody Assign assign) {
		return assignRepo.save(assign);
	}
	
	
	@RequestMapping("/api/assigncourse")
	protected List<Assign> getAssignCourse() {
		return assignRepo.findAll();
	}
}

