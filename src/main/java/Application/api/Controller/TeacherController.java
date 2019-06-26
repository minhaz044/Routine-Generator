package Application.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Application.Entity.Course;
import Application.Entity.Teacher;
import Application.Services.CourseServices;
import Application.Services.TeacherServices;

@RestController
public class TeacherController {
	@Autowired
	TeacherServices teacherService;
	@RequestMapping("/api/teacher")
	private List<Teacher> getCourse(){
		return teacherService.findTeacher();
	}
}
