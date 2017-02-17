package project.derivatives.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import project.derivatives.busObj.UserBo;
import project.derivatives.model.User;

@Controller
public class UserController {
	@Autowired
	UserBo userBo;
	@RequestMapping(value="register/create", method= RequestMethod.POST)
	public String regVerify(User use, Map<String, Object> map){
		userBo.create(use);
		
		return "redirect:/";
	}


	@RequestMapping(value="/login/verify", method=RequestMethod.POST)
	public String test3(HttpServletRequest request, ModelMap map ) throws IOException{
		String username = (String)request.getAttribute("userN");
		String password = (String)request.getAttribute("pwd");
		if (userBo.findUser(username, password).equals(null)){
			map.addAttribute("invalid", "Invalid Username or password");
			return "login";
		}else{
			map.addAttribute("user", username);
			return "dashboard";}

	}
}
