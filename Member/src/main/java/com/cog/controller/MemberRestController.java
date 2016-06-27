package com.cog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cog.entity.Member;
import com.cog.service.MemberService;

@RestController
@RequestMapping(value = "/rest")
public class MemberRestController {

	@Autowired
	MemberService service;
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public ResponseEntity<List<Member>> listAllUsers() {
		List<Member> members = service.findMembers();
		if (members.isEmpty()) {
			return new ResponseEntity<List<Member>>(HttpStatus.NO_CONTENT);// You
																			// many																	// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Member>>(members, HttpStatus.OK);
	}
}
