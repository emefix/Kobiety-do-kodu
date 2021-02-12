package pl.martitafilix.cats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CatsController {

	@Autowired
	private CatShelter catShelter;
	
	@RequestMapping("/list")
	public String catList(Model model) {
		model.addAttribute("cats", catShelter.getCats());
		return "list"; 
	}
	
	@RequestMapping("/add")
	public String addCat(Model model) {
		return "add";
	}
	
	@RequestMapping("/cat-{id}")
	public String catInfo(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("cat", catShelter.getCatById(id));
		return "info";
	}
}
