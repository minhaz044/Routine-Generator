package Application.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Application.Dao.AssignRepository;
import Application.Entity.Assign;

@Service
public class RoutineGeneratorServices {
	@Autowired
	private AssignRepository AssignRepo;

	
	//Map<String,List<Assign>>
	
	public Map<Integer,List<Assign>> generate() {

		List<Assign> mainAssignList=AssignRepo.findAll();
		List<Assign> tempmainAssignList=new ArrayList<Assign>();
		Map<Integer,List<Assign>> routine=new HashMap<Integer, List<Assign>>();
		int day_index;
		int delete_counter=0;
		int current_index=0;
		ArrayList<Assign>newList;
	
		for(int i=0;i<7 && mainAssignList.size()>0;i++) {// also check if mainlist is empty or not
			day_index=(i*3)+1;
			newList=new ArrayList<Assign>();
			delete_counter=0;
			
		
			//System.out.println("***************************Mian List Size:"+ mainAssignList.size());
			for (int j = 0;  mainAssignList.size()>j &&  newList.size() <3 ;j++) {
				current_index=j-delete_counter;
				//System.out.println("When Loop Start j="+j+" SIZE ="+ mainAssignList.size() +"NEW SIZE"+newList.size());
					if(newList.size()==0)
					{
						newList.add(mainAssignList.get(current_index));
						System.out.println("***********From 0 **************\t"+mainAssignList.get(current_index).getAssign_id()+"\t**************************************");
						//System.out.println("*****************J "+current_index+ "AND SIZE :"+mainAssignList.size());
						tempmainAssignList.add(mainAssignList.get(current_index));
						mainAssignList.remove(current_index);
						delete_counter++;
						
					}
					else if(newList.size()==1)
					{
						if(mainAssignList.get(current_index).getBatch_id()!=newList.get(0).getBatch_id() && mainAssignList.get(current_index).getTeacher_id()!=newList.get(0).getTeacher_id())
						{
							newList.add(mainAssignList.get(current_index));
							System.out.println("***************From 1************\t"+mainAssignList.get(current_index).getAssign_id()+"\t**************************************");
							tempmainAssignList.add(mainAssignList.get(current_index));
							//routine[(i*3)+1]=mainAssignList.get(j);
							//System.out.println("*****************J "+j+ "AND SIZE :"+mainAssignList.size());
							mainAssignList.remove(current_index);
							delete_counter++;
						}
					}
					else
					{
						int batch_0=newList.get(0).getBatch_id();
						int batch_1=newList.get(1).getBatch_id();
						int teach_0=newList.get(0).getTeacher_id();
						int teach_1=newList.get(1).getTeacher_id();
						int currentBatch=mainAssignList.get(current_index).getBatch_id();
						int currentTeacher=mainAssignList.get(current_index).getTeacher_id();
						if( batch_0!= currentBatch && batch_1!= currentBatch && teach_0!=currentTeacher && teach_1!=currentTeacher )
						{
										newList.add(mainAssignList.get(current_index));
										System.out.println("**************from 3*************\t"+mainAssignList.get(current_index).getAssign_id()+"\t**************************************");
										tempmainAssignList.add(mainAssignList.get(current_index));
										//routine[(i*3)+2]=mainAssignList.get(j);
										//System.out.println("*****************J "+j+ "AND SIZE :"+mainAssignList.size());
										mainAssignList.remove(current_index);
										delete_counter++;
								
						}
					}
				}
			routine.put(i, newList);
		System.out.println(" Day\n:"+i);
		}
		
		return routine;
		}
		

}





































//ArrayList<Assign> routine = new ArrayList<>();
//Queue<Assign> queue = new LinkedList<>();
//ArrayList<Integer> todayUsedTeacher = new ArrayList<Integer>();
//ArrayList<Integer> todayUsedBatch = new ArrayList<Integer>();
//List<Assign> assignList = AssignRepo.findAll();
//int dayCounter = 0;
//int periodCounter = 0;
//boolean isfreeBatch = false;
//boolean isfreeTeacher = false;
//for (int i = 1; i <= assignList.size(); i++) {
//	if (periodCounter > 3) {
//		periodCounter = 0;
//		dayCounter++;
//		todayUsedTeacher = new ArrayList<Integer>();
//		todayUsedBatch = new ArrayList<Integer>();
//
//	}
//	if (routine.size() == 0) {
//		routine.add(assignList.get(i));
//		assignList.get(i).setFlag(1);
//		// assignList.get(i).setCounter(assignList.get(i). .get(i).getCounter()++);
//		todayUsedTeacher.add(assignList.get(i).getTeacher_id());
//		todayUsedBatch.add(assignList.get(i).getBatch_id());
//	} else {
//		if (assignList.get(i).getFlag() == 0) {
//			for (i = 0; i < todayUsedTeacher.size(); i++) {
//				if (assignList.get(i).getTeacher_id() == todayUsedTeacher.get(i)) {
//					isfreeBatch = true;
//				}
//			}
//			for (i = 0; i < todayUsedBatch.size(); i++) {
//				if (assignList.get(i).getBatch_id() == todayUsedBatch.get(i)) {
//					isfreeTeacher = true;
//				}
//			}
//
//			if (isfreeBatch && isfreeTeacher) {
//				routine.add(assignList.get(i));
//				assignList.get(i).setFlag(1);
//				// assignList.get(i).setCounter(assignList.get(i).getCounter()++);
//				todayUsedTeacher.add(assignList.get(i).getTeacher_id());
//				todayUsedBatch.add(assignList.get(i).getBatch_id());
//				isfreeTeacher = false;
//				isfreeBatch = false;
//			} else {
//				System.out.println("Cloflict Course");
//			}
//		}
//
//	}
//	periodCounter++;
//	if (i == 10 && (routine.size() != assignList.size())) {
//		i = 1;
//	}
//
//}
//return routine;
