package pl.martitafilix.celebrities.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.martitafilix.celebrities.Reading;
import pl.martitafilix.celebrities.domain.Celebrity;
import pl.martitafilix.celebrities.dto.CelebrityDTO;

@Controller
public class CelebrityController {

	@Autowired
	private Reading reading;

	@RequestMapping("/list")
	public String celebrityList(Model model) {
		model.addAttribute("celebrities", reading.getCelebrities());
		return "list";
	}

//	@RequestMapping(value = "/add", method = RequestMethod.GET )
	@GetMapping("/add")
	public String celebrityAddingForm(Model model) { 
		CelebrityDTO celebrityDTO = new CelebrityDTO();
		model.addAttribute("celebrityDTO", celebrityDTO);
		return "add";
	}

//	@RequestMapping(value = "/add" , method = RequestMethod.POST )
	@PostMapping("/add")
	public String handleCelebrityAddingForm(
			@Validated @ModelAttribute("celebrityDTO") CelebrityDTO celebrityDTO, 
			BindingResult result) {

		if (!result.hasErrors()) {

			Celebrity celebrity = new Celebrity();
			celebrity.setName(celebrityDTO.getName());
			celebrity.setCanSing(celebrityDTO.isCanSing());
			celebrity.setCanAct(celebrityDTO.isCanAct());
			celebrity.setCanDance(celebrityDTO.isCanDance());
			reading.addCelebrity(celebrity);
			
			System.out.println(celebrity.printData());
			return "redirect:/list";
		}
		return "add"; // the form is not completed correctly.
	}

	@RequestMapping("/celebrity-{id}")
	public String celebrityInfo(@PathVariable("id") 
			Integer id, Model model) {
		model.addAttribute("celebrity", reading.getCelebrityById(id));
		return "info";
	}
}
