package project.derivatives.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import project.derivatives.busObj.UserBo;
import project.derivatives.model.User;

@Controller
public class HomeController {
	@Autowired
	UserBo userBo;

	@RequestMapping(value="/", method = RequestMethod.POST)
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("login");
	}
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView test0(HttpServletResponse response) throws IOException{
		return new ModelAndView("login");
	}
	
	
	@RequestMapping(value="/register")
	public ModelAndView test2(HttpServletResponse response, Map<String, Object> mapel) throws IOException{
		mapel.put("use", new User());
		return new ModelAndView("register");
	}
	
	
	@RequestMapping(value="/dashboard", method = RequestMethod.POST)
			public ModelAndView testdash(@RequestParam("userID") String uid, @RequestParam("pwd") String pwd) throws IOException{
				String ans="";
		
				ModelAndView model = new ModelAndView(ans);
					if (userBo.findUser(uid, pwd)==null){
								ans = "login";
								model.addObject("Invalid", "Invalid Login Credentials");
							}
					else{
						ans="dashboard";
						model.addObject("usedBy",uid);
					}
						
						return model;
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
	@RequestMapping(value="/pricesummary")
	public ModelAndView test7(HttpServletResponse response) throws IOException{
		return new ModelAndView("pricesummary");
	}

}
