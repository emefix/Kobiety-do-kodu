package pl.martitafilix.celebrities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CelebrityController {
	
	@Autowired
	private Reading reading;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String celebrityList(Model model) {
		model.addAttribute("celebrities", "dsdsd");//reading.getCelebrities());
		return "list";
	}
	
	@RequestMapping("/add")
	public String addCelebrity(Model model) {
		return "add";
	}
	
	@RequestMapping("/celebrity-{id}")
	public String celebrityInfo(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("celebrity", reading.getCelebrityById(id));
		return "info";
	}

}
