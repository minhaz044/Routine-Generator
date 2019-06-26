package Application.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Application.Dao.AssignRepository;
import Application.Dao.CourseRepository;
import Application.Entity.Assign;
import Application.Entity.Batch;
import Application.Entity.Course;
import Application.Entity.Teacher;

@Service
public class CourseServices {
	@Autowired
	private AssignRepository AssignRepo;
	@Autowired
	private CourseRepository CourseRepo;

	
	public List<Course> selectCourse(int batchId){
		
		List<Assign> assign_list =AssignRepo.findBybatchId(batchId);
		List<Course> course_list =CourseRepo.findAll();
		List<Course> new_course_list =new ArrayList<>();
		if(assign_list.size() ==0) {
			return course_list;
		}else {
			for (Course c : course_list) {
				if (c.getCourse_id()!=assign_list.get(0).getCourse_id()) {
					new_course_list.add(c);
				}
			}
		}
		return new_course_list;
		
	}
	
	
	

}
