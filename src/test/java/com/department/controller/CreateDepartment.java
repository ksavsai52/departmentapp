package com.department.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
import com.department.controllers.DepartmentController;
import com.department.domain.Department;
import com.department.repositories.DepartmentRepository;
import com.department.service.DepartmentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/config/applicationContext.xml")
public class CreateDepartment {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Mock
	private DepartmentService departmentService;

	@InjectMocks
	private DepartmentController departmentController;

	private MockMvc mockMvc;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(departmentController).build();
	}

	@Test
	public void testGetDepartment() throws Exception {
		Department department = new Department();
		department.setName("Drawing");
		department.setMinSalaryRange(40000);
		department.setMaxSalaryRange(50000);

		ObjectMapper objectMapper = new ObjectMapper();
		String dept = objectMapper.writeValueAsString(department);
		
		when(departmentService.saveDepartment(any())).thenReturn(departmentRepository.save(department));
		mockMvc.perform(post("/createDepartment").contentType(MediaType.APPLICATION_JSON).content(dept)).andDo(print());
	}

}
