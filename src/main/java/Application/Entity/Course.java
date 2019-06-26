package Application.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="TM2_Course")
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int course_id;
	private String course_name;
}
