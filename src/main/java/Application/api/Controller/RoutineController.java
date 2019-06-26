package Application.api.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Application.Entity.Assign;
import Application.Services.RoutineGeneratorServices;

@RestController
public class RoutineController {
	@Autowired
	RoutineGeneratorServices RGServices;
	
	@RequestMapping("/api/routine")
	public  Map<Integer,List<Assign>> getRoutine() {
		return RGServices.generate();
		
	}
	
	
	

}
