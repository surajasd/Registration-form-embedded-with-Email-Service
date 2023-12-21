package com.webApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
//import com.webApp.controller.List;
import com.webApp.entity.Registration;
import com.webApp.repository.RegRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private RegRepository regrepo;
	
	public void saveRegd(Registration reg) {
		regrepo.save(reg);
		
	}

	public List<Registration> getAllRegistration() {
		List<Registration> regs = regrepo.findAll();
		return regs;
	}

	public void deleteRegById(long id) {
		regrepo.deleteById(id);
		
	}

	public Registration getById(long id) {
		Registration reg = regrepo.findById(id).get();
		return reg;
	}

}
