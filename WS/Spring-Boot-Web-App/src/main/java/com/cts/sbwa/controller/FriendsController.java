package com.cts.sbwa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

/*@Controller
@RequestMapping("friends")
@Scope("session")
public class FriendsController {
	
	List<String> friends;
	
	public FriendsController() {
		friends= new ArrayList<>();
	}

	@GetMapping
	public ModelAndView friendsAction(@RequestParam(value="fnm",required=false)String friendName) {
		if(friendName!=null)
			friends.add(friendName);
		return new ModelAndView("friends-page","friends",friends);
	}
}*/

@Controller
@RequestMapping("friends")
public class FriendsController {
	
	@GetMapping
	public String friendsAction(
			HttpSession session,
			@RequestParam(value="fnm",required=false)String friendName) {
		
		List<String> friends = (List<String>) session.getAttribute("friends");
		if(friends==null)
			friends=new ArrayList<>();
		
		if(friendName!=null)
			friends.add(friendName);
		
		session.setAttribute("friends",friends);
		
		return "friends-page";
	}
}
