package com.webApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webApp.dto.RegistrationDTO;
import com.webApp.entity.Registration;
import com.webApp.service.RegistrationService;
import com.webApp.util.EmailService;

@Controller
public class RegController {
	@Autowired
	private EmailService es;
	
	@Autowired
	private RegistrationService regService;
	//http://localhost:8080/view-registration-page
	// Handler Methods
	@RequestMapping("/view-registration-page")
	public String viewsReg() {
		return "new_reg";
	}
//	@RequestMapping("/SaveReg")
//	public String saveRegistration(@ModelAttribute Registration regd) {
//		regService.saveRegd(regd);
//		return "new_reg";
//	}
//	@RequestMapping("/SaveReg")
//	public String saveRegistration(
//			@RequestParam("firstname") String fname,
//			@RequestParam("lastname") String lname,
//			@RequestParam("email") String email,
//			@RequestParam("mobile") long mobile,
//			ModelMap model
//			) {
//		Registration regd = new Registration();
//		regd.setFirstname(fname);
//		regd.setLastname(lname);
//		regd.setEmail(email);
//		regd.setMobile(mobile);
//		
//		regService.saveRegd(regd);
//		model.addAttribute("msg","record saved");
//		return "new_reg";
//	}
	@RequestMapping("/SaveReg")
	public String saveRegistration(
		RegistrationDTO dto,
			ModelMap model
			) {
		Registration regd = new Registration();
		regd.setFirstname(dto.getFirstname());
		regd.setLastname(dto.getLastname());
		regd.setEmail(dto.getEmail());
		regd.setMobile(dto.getMobile());
		
		regService.saveRegd(regd);
		es.sendEmail(dto.getEmail(), "Welcome", "test");
		model.addAttribute("msg","record saved");
		return "new_reg";
	}
	@RequestMapping("/getAllReg")
	public String getAllRegistration(Model model) {
		List<Registration> reg = regService.getAllRegistration();
		System.out.println(reg);
		model.addAttribute("registrations",reg);
		return "list_registrations";
	}
	@RequestMapping("/delete")
	public String deleteRegById (@RequestParam("id") long id, Model model) {
		regService.deleteRegById(id);
		List<Registration> reg = regService.getAllRegistration();
		model.addAttribute("registrations",reg);
		return "list_registrations";
	}
	@RequestMapping("/getById")
	public String getById(@RequestParam("id") long id, Model model) {
		Registration reg =regService.getById(id);
		model.addAttribute("regd", reg);
		return "update_registration";
	}
	@RequestMapping("/updateReg")
	public String updateRegistration(
			RegistrationDTO dto,
				ModelMap model
				) {
			Registration regd = new Registration();
			regd.setId(dto.getId());
			regd.setFirstname(dto.getFirstname());
			regd.setLastname(dto.getLastname());
			regd.setEmail(dto.getEmail());
			regd.setMobile(dto.getMobile());
			
			regService.saveRegd(regd);
			model.addAttribute("msg","record updated");
			es.sendEmail(dto.getEmail(), "record updated", "test");
			List<Registration> reg = regService.getAllRegistration();
			model.addAttribute("registrations",reg);
			return "list_registrations";
		
	}

}
