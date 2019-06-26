package Application.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class MainController {

	@RequestMapping("")
	public ModelAndView Homepage() {
		ModelAndView modelView=new ModelAndView();
		modelView.setViewName("index");
		return modelView;
		
		
	}
	@RequestMapping("/routine")
	public ModelAndView getRoutine() {
		ModelAndView modelView=new ModelAndView();
		modelView.setViewName("routine");
		return modelView;
		
		
	}
	
}
