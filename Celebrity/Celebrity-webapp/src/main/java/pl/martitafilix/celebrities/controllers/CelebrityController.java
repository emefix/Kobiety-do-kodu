package pl.martitafilix.celebrities.controllers;

import java.util.Arrays;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.martitafilix.celebrities.CelebrityDAOChoice;
import pl.martitafilix.celebrities.CelebrityDAOChoice.DAO;
import pl.martitafilix.celebrities.domain.Celebrity;
import pl.martitafilix.celebrities.dto.CelebrityDTO;

@Controller
public class CelebrityController {
	
	@Autowired
	private CelebrityDAOChoice celebrityDAO;

	@RequestMapping("/list")
	public String celebrityList(Model model) {
		
		model.addAttribute("celebrities", celebrityDAO.getDAO().getCelebrities());
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
			celebrityDAO.getDAO().addCelebrity(celebrity);

			System.out.println(celebrity.printData());
			return "redirect:/list";
		}
		return "add"; // the form is not completed correctly.
	}

	@RequestMapping("/celebrity-{id}")
	public String celebrityInfo(Model model,
			@PathVariable(value = "id") Integer id) {
		
		model.addAttribute("celebrity", celebrityDAO.getDAO().getCelebrityById(id));		
		return "info";
	}

	@ResponseBody
	@GetMapping("/dao")
	public String celebrityDaoChoose(@RequestParam("dao") DAO dao, Model model/** , BindingResult result														 */) {

//		if (!result.hasErrors()) {
		DAO daos[] = DAO.values();
		model.addAttribute("daos", daos);

		Arrays.asList(daos).forEach(d -> {
			System.out.print(d + ", ");
			System.out.println();
		});

		return "response for: " + dao;
//		return "redirect:/list";
	}

	@GetMapping("/")
	public String daoChoose(Model model) {
		
		DAO daos[] = DAO.values();
		model.addAttribute("daos", daos);

//		Arrays.asList(daos).forEach(d -> {
//			System.out.print(d + ", ");
//			System.out.println();
//		});

		return "index";
	}

	@PostMapping("/")
	public String handleDaoChoose(@ModelAttribute("dao") DAO dao, 
			BindingResult result) {

		if (!result.hasErrors()) {

			celebrityDAO.setCelebrityDAO(dao);
			System.out.println(dao);

			return "redirect:/list";
		}
		return "index";
	}
}
