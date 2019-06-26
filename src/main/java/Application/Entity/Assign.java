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
@Table(name="TM2_Assign")
public class Assign {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int assign_id;
	private int batch_id;
	private int course_id;
	private int teacher_id;
	private int flag=0;
}
