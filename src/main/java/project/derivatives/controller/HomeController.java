package project.derivatives.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("login");
	}
	
	
	@RequestMapping(value="/register")
	public ModelAndView test2(HttpServletResponse response) throws IOException{
		return new ModelAndView("register");
	}
	
	
	@RequestMapping(value="/dashboard", method = RequestMethod.POST)
			public ModelAndView testdash(HttpServletResponse resp, @RequestParam("userID") String uid, @RequestParam("pwd") String pwd) throws IOException{
			
			// if COUNT((SELECT * FROM users where user_name=uid && user_password = pwd))==1{
			// return new model("dashboard");
			//}
			//else{ ModelAndView model = new ModelAndView("home")
			//model.addObject("Invalid", "Invalid Login Credentials")}
			return new ModelAndView("dashboard");
	}
	
	
	@RequestMapping(value="/pricederivative")
	public ModelAndView test4(HttpServletResponse response) throws IOException{
		return new ModelAndView("pricederivative");
	}
	
	
	@RequestMapping(value="/portsummary")
	public ModelAndView test5(HttpServletResponse response) throws IOException{
		return new ModelAndView("portsummary");
	}
	
	
	@RequestMapping(value="/visualize")
	public ModelAndView test6(HttpServletResponse response) throws IOException{
		return new ModelAndView("visualize");
	}
}
