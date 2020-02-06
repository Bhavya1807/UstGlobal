package com.ust.mail_simulation.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.ust.mail_simulation.model.MailDTO;
import com.ust.mail_simulation.model.UserDTO;
import com.ust.mail_simulation.service.MyService;

@Component
@RequestMapping("/")
public class MyController {
	@Autowired
	MyService ms;
	HttpSession h;
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	@RequestMapping("/composemail")
	public ModelAndView composemail(){
		if(h.getAttribute("email")!=null) {
		return new ModelAndView("composemail");
	}else {
		  return new ModelAndView("login","msg3","Login First!!!!");
	  }
	}
	
	@RequestMapping("/forgotpassword")
	public String forgotpassword(){
		return "forgotpassword";
	}
	@RequestMapping("/inbox")
	public ModelAndView inbox(){
		if(h.getAttribute("email")!=null) {
		List<MailDTO> From_id=ms.inbox();
	
		return new ModelAndView("inbox","From_id",From_id);
		  }else {
			  return new ModelAndView("login","msg3","Login First!!!!");
		  }
	}
	@RequestMapping("/sentitem")
	public ModelAndView sent(){
		if(h.getAttribute("email")!=null) {
		List<MailDTO> From_id=ms.sentitem();
		return new ModelAndView("sentitem","From_id",From_id);
		  }else {
			  return new ModelAndView("login","msg3","Login First!!!!");
		  }
	}
	@RequestMapping("/mail")
	public ModelAndView mailpage(@RequestParam int id){
		if(h.getAttribute("email")!=null) {
		List<MailDTO> From_id=ms.mail(id);
		return new ModelAndView("mail","From_id",From_id);
		  }else {
			  return new ModelAndView("login","msg3","Login First!!!!");
		  }
	}
	@RequestMapping("/composedraft")
	public ModelAndView composedraft(@RequestParam int id){
		if(h.getAttribute("email")!=null) {
		MailDTO From_id=ms.composedraft(id);
		return new ModelAndView("composedraft","From_id",From_id);
		  }else {
			  return new ModelAndView("login","msg3","Login First!!!!");
		  }
	}
	@RequestMapping("/deleteitem")
	public ModelAndView deleteitem(){
		if(h.getAttribute("email")!=null) {
		List<MailDTO> From_id=ms.deleteitem();
		return new ModelAndView("deleteitem","From_id",From_id);
	  }else {
		  return new ModelAndView("login","msg3","Login First!!!!");
	  }
	}
	@RequestMapping("/draft")
	public ModelAndView draft(){
		if(h.getAttribute("email")!=null) {
		List<MailDTO> From_id=ms.draft();
		return new ModelAndView("draft","From_id",From_id);
		 }else {
			  return new ModelAndView("login","msg3","Login First!!!!");
		  }
		}
	@RequestMapping("/registration")
	public String registration(){
		return "registration";
	}
	@RequestMapping(value="/loginValidation",method=RequestMethod.POST)
	public ModelAndView loginValidation(@ModelAttribute UserDTO dto,HttpServletRequest req){
		UserDTO udto=ms.login(dto);
		if(udto!=null){
			h=req.getSession();
			h.setAttribute("email",dto.getEmail());
			System.out.println("Login Success");
			return new ModelAndView("Home","dto",udto);
		}else{
			System.out.println("Login Failed");
			 return new ModelAndView("login","msg","Login failed.. Invalid email and password!!");
			}
	}
	@RequestMapping(value="/registrationData",method=RequestMethod.POST)
	public ModelAndView registrationData(@ModelAttribute UserDTO rdto){
		boolean b=ms.register(rdto);
			if(b){
	return new ModelAndView("login","dto","Registration Successfull.. User can login to their account... ");
			}else{
				return new ModelAndView("registration","dto","User Already Registered..Registration Not Done ...");
			}
	}
	@RequestMapping(value="/logout")
	public ModelAndView logout(HttpServletRequest req){
		System.out.println("logout");
		 if(h.getAttribute("email")!=null) {
			
			h.setAttribute("email",null);
			 return new ModelAndView("login","msg2","Logout Successful.. Login First");
			
		}else{
			return new ModelAndView("login","msg2","Login First.. User is not loggged in ");
		}
	}
	@RequestMapping(value="/composeData",method=RequestMethod.POST)
	public ModelAndView composeEmail(HttpServletRequest req){
		if(h.getAttribute("email")!=null) {
	
		boolean b=ms.composeEmail(req);
		if(b){
			return new ModelAndView("Home","msg1","Mail Successfully Sent");
		}else{
			return new ModelAndView("Home","msg1","Mail saved to drafts");
		}
		}else{
			return new ModelAndView("login","msg2","Login First.. User is not loggged in ");
		}
	}
	  @RequestMapping("/sentdelete")
	  public ModelAndView sentdelete(@RequestParam int id) {
		 if(h.getAttribute("email")!=null) { 
		  boolean b=ms.sentdelete(id);
		  if(b) {
		  return new ModelAndView("Home","msg","Message deleted..");
		  }else {
			  return new ModelAndView("Home","msg","delete failed");
		  }
	 }else{
			return new ModelAndView("login","msg2","Login First.. User is not loggged in ");
		}
	  }
	@RequestMapping(value="/forgotdata",method=RequestMethod.POST)
	public ModelAndView forgotpassword(HttpServletRequest req){
		boolean b=ms.forgotpasswword(req);
		if(b){
			return new ModelAndView("changepassword");
		}else{
			return new ModelAndView("forgotpassword","msg1","Security question and answer is wrong");
		}
		
	}
	@RequestMapping(value="/changePass",method=RequestMethod.POST)
	public ModelAndView changePass(HttpServletRequest req) {
		boolean b=ms.changePass(req);
		if(b){
			return new ModelAndView("login");
		}else{
			return new ModelAndView("changepassword","msg","Password Not Changed.. Confirm Password and New Password are not same.");
		}
	}
	@RequestMapping(value="/composedraftData",method=RequestMethod.POST)
	public ModelAndView composedraftData(HttpServletRequest req){
		if(h.getAttribute("email")!=null) { 
		boolean b=ms.composedraftEmail(req);
		if(b){
			return new ModelAndView("Home","msg1","Mail Successfully Sent");
		}else{
			return new ModelAndView("Home","msg1","Mail saved to drafts");
		}
		}else{
			return new ModelAndView("login","msg2","Login First.. User is not loggged in ");
		}
	}
	@RequestMapping("/inboxdelete")
	  public ModelAndView inboxdelete(@RequestParam int id) {
		if(h.getAttribute("email")!=null) { 
		  boolean b=ms.inboxdelete(id);
		  if(b) {
		  return new ModelAndView("Home","msg","Message deleted..");
		  }else {
			  return new ModelAndView("Home","msg","delete failed");
		  }
	}else{
		return new ModelAndView("login","msg2","Login First.. User is not loggged in ");
	}
	  }
	@RequestMapping("/draftdelete")
	  public ModelAndView draftdelete(@RequestParam int id) {
		if(h.getAttribute("email")!=null) { 
		  boolean b=ms.draftdelete(id);
		  if(b) {
		  return new ModelAndView("Home","msg","Message deleted..");
		  }else {
			  return new ModelAndView("Home","msg","delete failed");
		  }
		}else{
			return new ModelAndView("login","msg2","Login First.. User is not loggged in ");
		}
	  }
}
