package Application.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Application.Dao.AssignRepository;
import Application.Dao.TeacherRepository;
import Application.Entity.Teacher;

@Service
public class TeacherServices {
	@Autowired
	private TeacherRepository teacherRepo;
	@Autowired
	private AssignRepository assignRepo;

	public List<Teacher> findTeacher() {

		List<Teacher> teacher_list = teacherRepo.findAll();
		List<Teacher> new_teacher_list = new ArrayList<>();

		for (Teacher t : teacher_list) {
			if (assignRepo.findbyTeacherId(t.getTeacher_id()).size() < 7) {
				new_teacher_list.add(t);
			}
		}
		return new_teacher_list;

	}
}