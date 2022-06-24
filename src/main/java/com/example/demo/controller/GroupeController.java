package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Groupe;
import com.example.demo.services.groupeService;
@Controller
public class GroupeController {
	private groupeService GroupeService;

	public GroupeController(groupeService groupeService) {
		super();
		GroupeService = groupeService;
	}
	@GetMapping("/groups")
	public String listGroups(Model model)
	{
		model.addAttribute("groups", GroupeService.getAllgroupe());
		return "groups";
	}
	@GetMapping("/groups/new")
	public String createGroupFrom(Model model)
	{
		Groupe group=new Groupe();
		model.addAttribute("group", group);
		return "create_groups";	
	}
	@PostMapping("/groups")
	public String SaveGroup(@ModelAttribute("group") Groupe group)
	{
		GroupeService.saveGroupe(group);
		return "redirect:/groups";
	}
	
	@GetMapping("/groups/edit/{id}")
	public String editGroupFrom(@PathVariable Long id,Model model)
	{
		model.addAttribute("group",GroupeService.getGroupeById(id));
		return "edit_groups";
	}
	@PostMapping("/groups/{id}")
	public String updateGroup(@PathVariable Long id,
			@ModelAttribute("group") Groupe groupe,
			Model model)
	{
		
		Groupe updatinggroupe=GroupeService.getGroupeById(id);
		updatinggroupe.setName_groups(groupe.getName_groups());
		GroupeService.saveGroupe(updatinggroupe);
	    return "redirect:/groups";
	}
	
	@GetMapping("/groups/{id}")
	public String deleteGroup(@PathVariable Long id)
	{
		GroupeService.deleteGroupeById(id);
		return "redirect:/groups";
	}
	
	

}
