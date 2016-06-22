package com.cog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addMember(Model model){
		
		model.addAttribute("m1", "String value");
		return "member";
	}

}