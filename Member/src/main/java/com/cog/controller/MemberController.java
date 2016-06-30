package com.cog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cog.entity.Member;
import com.cog.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService service;
	

	  private static final String WELCOME_VIEW = "newuser.jsp";

	  private static final String PATH = "/adduser";

	
	@RequestMapping(value = PATH, method = RequestMethod.POST)
	  public String addAddress(@ModelAttribute("m1") @Valid Member member,
	      BindingResult result, Model model) {

		result.
		System.out.println("Member:" + member);
	    model.addAttribute("member", member);
	    return "member.jsp";
	  }
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addMember(@RequestParam String name, @RequestParam Double salary, Model model){
		
		Member member = new Member(name, salary);
		
		boolean result = service.addMember(member);
		String message;
		if(result){
			message = "Registration Successful";
		}
		else{
			message = "Registration Failure";
		}
		
		model.addAttribute("msg", message);
		return "member.jsp";
	}
	
	@RequestMapping(value="/findAll", method=RequestMethod.GET)
	public String findMembers(Model model){
		
//		find all the employees an set into model
		List<Member> members = service.findMembers();
		model.addAttribute("members", members);
		
		return "list.jsp";
	}

}
