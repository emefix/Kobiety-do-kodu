package pl.martitafilix.cats.controllers;

import java.text.ParseException;

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

import pl.martitafilix.cats.dao.JdbcCatDAO;
import pl.martitafilix.cats.dto.CatDTO;
import pl.martitafilix.cats.model.Cat;

@Controller
public class CatsController {

//	@Autowired private CatShelter catShelter;
	
	@Autowired
	private JdbcCatDAO jdbcCatDAO;
	
	@RequestMapping("/list")
	public String catList(Model model) {
		
		model.addAttribute("cats", jdbcCatDAO.getCats());
		return "list"; 
	}
	
	@GetMapping("/add")
	public String catAddingForm(Model model) {
		
		model.addAttribute("catDTO", new CatDTO());
		return "add";
	}
	
	@PostMapping("/add")
	public String handleCatAddingForm(
			@Validated @ModelAttribute("catDTO") CatDTO catDTO, BindingResult result) {
		
		if( !result.hasErrors()) {
			
			Cat cat = new Cat();
			cat.setName(catDTO.getName());
			try {
				cat.setDate_of_birth(Cat.SDF.parse(catDTO.getDate_of_birth()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			cat.setWeight(catDTO.getWeight());
			cat.setName_of_catKeeper(catDTO.getName_of_catKeeper());
			
			jdbcCatDAO.addCat(cat);
			
			return "redirect:/list";
		}
		return "add";
	}
	
	@RequestMapping("/cat-{id}")
	public String catInfo(@PathVariable("id") Integer id, Model model) {
		
		model.addAttribute("cat", jdbcCatDAO.getCatById(id));
		return "info";
	}
}
