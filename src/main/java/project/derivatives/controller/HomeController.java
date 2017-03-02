package project.derivatives.controller;

import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
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
	
	@RequestMapping(value="/derivatives/register", method = RequestMethod.GET)
	public ModelAndView test_reg(){
		return new ModelAndView("register");
	}

	
	@RequestMapping(value="/derivatives/login", method = RequestMethod.POST)
	public ModelAndView test(Map<String, Object> map,@RequestParam("fname") String fn,
							 @RequestParam("lname") String ln,
							 @RequestParam("user") String un,
							 @RequestParam("rdoGender") String gen,
							 @RequestParam("email") String em,
							 @RequestParam("mobile") String mob,
							 @RequestParam("pass1") String pas) throws IOException{
		User u =new User(); 
		u.setFname(fn);
		u.setLname(ln);
		u.setUser(un);
		u.setRdoGender(gen);
		u.setEmail(em);
		u.setMobile(mob);
		u.setPass1(BCrypt.hashpw(pas, BCrypt.gensalt())); 
		userBo.create(u);
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
				
				
				ModelAndView model = null;
				if(uid.length()!=0 ||pwd.length()!=0){
					if (userBo.findUser(uid, pwd)!=null){
								User us =userBo.findUser(uid, pwd);
								if(BCrypt.checkpw(pwd,us.getPass1() )){
										model = new ModelAndView("dashboard");
										model.addObject("firstname",us.getFname());
										model.addObject("lastname",us.getLname());
										model.addObject("email",us.getEmail());
										model.addObject("mobile",us.getMobile());
										model.addObject("gender",us.getRdoGender());
										model.addObject("username",us.getUser());
								}
								else{model = new ModelAndView("login");
										model.addObject("Invalid", "Wrong Password"); 
									}
					}
					else{
						model = new ModelAndView("login");
						model.addObject("Invalid", "Username does not exist");
						}
				}
				else{
					model = new ModelAndView("login");
					model.addObject("Invalid", "Fields cannot be empty");
				}
						return model;
				
	}
	
	
	@RequestMapping(value="/derivatives/pricederivative")
	public ModelAndView test4(HttpServletResponse response) throws IOException{
		return new ModelAndView("pricederivative");
	}
	@RequestMapping(value="/derivatives/dashboard")
	public ModelAndView test4b(HttpServletResponse response) throws IOException{
		return new ModelAndView("dashboard");
	}
	@RequestMapping(value="/derivatives/portfoliolist")
	public ModelAndView test4c(HttpServletResponse response) throws IOException{
		return new ModelAndView("portfoliolist");
	}
	
	
	@RequestMapping(value="/derivatives/portsummary")
	public ModelAndView test5(HttpServletResponse response) throws IOException{
		return new ModelAndView("portsummary");
	}
	
	
	@RequestMapping(value="/derivatives/visualize")
	public ModelAndView test6(HttpServletResponse response) throws IOException{
		return new ModelAndView("visualize");
	}
	/*@RequestMapping(value="/derivatives/pricesummary")
	public ModelAndView test7(HttpServletResponse response) throws IOException{
		return new ModelAndView("pricesummary");
	}*/
	
	@RequestMapping(value="/dashboard/edit")
	public ModelAndView test9(HttpServletResponse response) throws IOException{
		return new ModelAndView("dashboardedit");
	}
	@RequestMapping(value="dashboard/derivatives/dashboard")
	public ModelAndView test10(HttpServletResponse response) throws IOException{
		return new ModelAndView("dashboard");
	}
	
	

}
