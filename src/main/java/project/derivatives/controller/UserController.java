package project.derivatives.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import project.derivatives.model.User;

@Controller
public class UserController {
	
	
	@RequestMapping(value="register/verify", method= RequestMethod.POST)
	public String regVerify(User use, Map<String, Object> map){
		map.put("fname", use.getFname());
		map.put("lname", use.getLname());
		map.put("username", use.getUser());
		map.put("gender", use.getRdoGender());
		map.put("email", use.getEmail());
		map.put("mobile", use.getMobile());
		map.put("city", use.getCity());
		map.put("pass1", use.getPass1());
		map.put("pass2", use.getPass2());
		map.put("address", use.getAddress());
		map.put("about", use.getAbout());
		map.put("interest", use.getAddress());
		
		
		return"";
	}


	@RequestMapping(value="/login/verify", method=RequestMethod.POST)
	public ModelAndView test3(HttpServletResponse response) throws IOException{
		return new ModelAndView("dashboard");

}
}
