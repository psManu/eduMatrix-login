package com.psmanu;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@Autowired
	private UserManagementService userManagementService;
	
	@Autowired
	private InstituteManagementService instituteManagementService;
	
	@RequestMapping("/")
	public String getLoginBox(HttpServletRequest request, Model model){
		
		
		String saved_inst_id = "";
		String saved_inst_title = "";
		String saved_inst_city = "";
		
		Cookie[] cookies = request.getCookies();
		for(Cookie c : cookies){
			if(c.getName().equals("saved_inst_id")){saved_inst_id = c.getValue();}
			if(c.getName().equals("saved_inst_title")){saved_inst_title = c.getValue();}
			if(c.getName().equals("saved_inst_city")){saved_inst_city = c.getValue();}
		}
	
		if((!saved_inst_title.equals("")) && (!saved_inst_id.equals("0")) ){
			model.addAttribute("saved_inst_title", saved_inst_title);
			model.addAttribute("saved_inst_id", saved_inst_id);
			model.addAttribute("saved_inst_city", saved_inst_city);
		}
		
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam("inst_id") int inst_id,
						@RequestParam("username") String username,
						@RequestParam("password") String password,
						HttpServletResponse response, HttpServletRequest request, 
						Model model){
		
		
		
		
		User user = userManagementService.getUserAuthenticated(inst_id, username, password);
		
		if(user != null){
			
			String inst_name = instituteManagementService.getInstituteNameById(inst_id).getInstName();
			
			String inst_city = instituteManagementService.getInstituteNameById(inst_id).getInstCity();
			
			
			this.destroyCookies(request);
			Cookie titleCookie = new Cookie("saved_inst_title", inst_name);
			Cookie idCookie = new Cookie("saved_inst_id", ""+inst_id+"");
			Cookie cityCookie = new Cookie("saved_inst_city", inst_city); 
			
			
			titleCookie.setPath("/");
			idCookie.setPath("/");
			cityCookie.setPath("/");
			
			
			
			response.addCookie(idCookie);
			response.addCookie(titleCookie);
			response.addCookie(cityCookie);
			
			request.getSession().setAttribute("user", user);
			
			if(user.getAuthLevel().toLowerCase().equals("officer")){
				return "officerPage";
			}else if(user.getAuthLevel().toLowerCase().equals("manager")){
				return "managerPage";
			}else if(user.getAuthLevel().toLowerCase().equals("lecturer")){
				return "lecturerPage";
			}else{
				return "403";
			}	
			
		}else{
			model.addAttribute("login_status", "Invalid");
			return "login";
		}
		
	}
	
	
	
	
	@RequestMapping(value="/freshLogin", method=RequestMethod.GET)
	public String getFreshLogin(HttpServletRequest request, Model model){
		
		this.destroyCookies(request);
		
		return "login";
	}
	
	
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public void destroySession(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		request.getSession().setAttribute("user", null);
		response.sendRedirect("/Edu-Matrix/");
		
	}
	
	
	
/////////////////////////////// Common Methods ////////////////////////////////////////////////	
	@ModelAttribute
	public void addInstListForAll(Model model){
		model.addAttribute("inst_list", instituteManagementService.fetchAllInstitutes());
	}
	
	private void destroyCookies(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		for(Cookie c: cookies){
			
			if(c.getName().equals("saved_inst_id") 
					|| c.getName().equals("saved_inst_title") 
					|| c.getName().equals("saved_inst_city")){
				System.out.println(c.getValue());
				c.setMaxAge(0);
				c.setPath("/");
				c.setValue(null);				
			};
		}
	}

}
