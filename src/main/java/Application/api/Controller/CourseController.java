package Application.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Application.Entity.Course;
import Application.Services.CourseServices;

@RestController
public class CourseController {
	@Autowired
	CourseServices courseService;
	@RequestMapping("/api/course/{batchId}")
	private List<Course> getCourse(@PathVariable(name="batchId") int batchId){
		return courseService.selectCourse(batchId);
	}

}
