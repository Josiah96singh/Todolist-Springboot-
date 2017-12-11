package Myspringbootapp.fi.webcon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Myspringbootapp.fi.domain.LabelRepository;
import Myspringbootapp.fi.domain.Todo;
import Myspringbootapp.fi.domain.TodoRepository;
import Myspringbootapp.fi.domain.UserRepository;

@Controller
public class Webcontroller {
	
	@Autowired 
	private TodoRepository repository;
	
	@Autowired LabelRepository lrepository;
	
	@Autowired UserRepository urepository;
	
	@RequestMapping(value= "/")
	public String intro() {
		return "redirect:home";
	}

	@RequestMapping(value = "/home")
	public String list(Model model) {
	model.addAttribute("todo", repository.findAll());
	model.addAttribute("users", urepository.findAll());
	return "todolist";
	}
	
	@RequestMapping(value= "/add", method= RequestMethod.GET)
	public String adding(Model model) {
		model.addAttribute("todo", new Todo());
		model.addAttribute("labels", lrepository.findAll());
		return "add";
	}
	
	@RequestMapping(value = "/save",  method = RequestMethod.POST)
	public String saving(Todo todo) {
		repository.save(todo); {
			return "redirect:/home";
		}
	}
	
	@RequestMapping(value="/edit/{id}", method= RequestMethod.GET)
	public String edit(@PathVariable("id") Long todoId, Model model) {
		model.addAttribute("todo", repository.findOne(todoId));
		model.addAttribute("labels", lrepository.findAll());
		return "edit";
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long todoId, Model model) {
		repository.delete(todoId);
		return "redirect:../home";
	}
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/back")
	public String back(){
		return "redirect:/home";
	}
	
}
