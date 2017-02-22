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
		//u.setPass1(pas);
		u.setPass1(BCrypt.hashpw(pas, BCrypt.gensalt())); 
		/*try{
		MessageDigest password = MessageDigest.getInstance("MD5");
		password.update(pas.getBytes(), 0, pas.length());
		u.setPass1(new BigInteger(1,password.digest()).toString());
		}catch(Exception ex){
			ex.printStackTrace();
		}*/
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
				
				/*MessageDigest password;
				String pas1 = null;
				try {
					password = MessageDigest.getInstance("MD5");
					password.update(pwd.getBytes(), 0, pwd.length());
					pas1=new BigInteger(1,password.digest()).toString(16);
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
				ModelAndView model = null;
					if (userBo.findUser(uid, pwd)!=null){
								if(BCrypt.checkpw(pwd,userBo.findUser(uid, pwd).getPass1() )){
								model = new ModelAndView("dashboard");
								model.addObject("usedBy",uid);
								}
								else{model = new ModelAndView("login");
								model.addObject("Invalid", "Wrong Password"); }
							}
					else{
						model = new ModelAndView("login");
						model.addObject("Invalid", "Username does not exist");
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
