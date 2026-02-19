package com.sample.unittestdemo.Test.Controllers;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.sample.unittestdemo.Controllers.SampleController;
import com.sample.unittestdemo.models.User;

import tools.jackson.databind.ObjectMapper;



@WebMvcTest(SampleController.class)
public class SampleControllerTest {
	
	@Autowired
	MockMvc mock;
	
	@Autowired
	ObjectMapper objectmapper;
	
	@Test
	void testGreet() throws Exception
	{
		mock.perform(get("/api/test"))
		.andExpect(status().isOk())
		.andExpect(content().string("Hello User!"));
	}
	
	@Test
	void TestgetById() throws Exception
	{
		mock.perform(get("/api/test/{id}",10))
		.andExpect(status().isOk())
		.andExpect(content().string("Id Received:10"));
	}
	

	@Test
	void TestaddUser() throws Exception
	{
		User user=new User(1,"Test",25);
		mock.perform(post("/api/test")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectmapper.writeValueAsString(user)))
		.andExpect(status().isOk())
		.andExpect(content().string("User Added with Id:1"));
	}

}
