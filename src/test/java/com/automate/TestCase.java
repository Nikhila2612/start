package com.automate;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.automate.controller.Controller;
import com.automate.pojo.DepartmentDetails;
import com.automate.service.service;
import com.fasterxml.jackson.databind.ObjectMapper;
//import static org.mockito.ArgumentMatchers.anyInt;

@WebMvcTest(Controller.class)
public class TestCase {
	@Autowired

	private Controller controller;
	
	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	private service service;

	private Object departmentdetails;
	
	@Test
	public void getDepartmentByIdTest() throws Exception{
		DepartmentDetails departmentdetails = new DepartmentDetails();
	
		
		departmentdetails.setEmailid("nikki@gmail.com");
		departmentdetails.setName("nikhila");
		departmentdetails.setPhoneno(123456789);
		
		when(service.getDepartmentById(anyInt())).thenReturn(departmentdetails);
		
		mockmvc.perform(MockMvcRequestBuilders.get("/department/12"))
		
		.andDo(print())
		
	
		.andExpect(MockMvcResultMatchers.jsonPath("emailid").value("nikki@gmail.com"))
		.andExpect(MockMvcResultMatchers.jsonPath("name").value("nikhila"))
		.andExpect(MockMvcResultMatchers.jsonPath("phoneno").value(123456789))
	    
	    .andExpect(status().isOk());
	}
	
	@Test
	public void saveDepartmentTest() throws Exception {
		//mock the user data that we have to save
		DepartmentDetails departmentdetails=new DepartmentDetails();
		departmentdetails.setId(1);
		departmentdetails.setEmailid("nikki@gmail.com");
		departmentdetails.setName("nikhila");
		departmentdetails.setPhoneno(999999999);
		
		
		when(service.saveDepartment(any(DepartmentDetails.class))).thenReturn(departmentdetails);
		//mock request user
		
		mockmvc.perform(MockMvcRequestBuilders.post("/department")
		
		.content(new ObjectMapper().writeValueAsString(departmentdetails))
		.contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isCreated())
		.andExpect(MockMvcResultMatchers.jsonPath("id").exists())
		.andExpect(MockMvcResultMatchers.jsonPath("emailid").value("nikki@gmail.com"))
		.andExpect(MockMvcResultMatchers.jsonPath("name").value("nikhila"))
		.andExpect(MockMvcResultMatchers.jsonPath("phoneno").value("999999999"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
 