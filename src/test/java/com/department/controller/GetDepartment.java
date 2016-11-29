package com.department.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.department.controllers.DepartmentController;
import com.department.repositories.DepartmentRepository;
import com.department.service.DepartmentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/config/applicationContext.xml")
public class GetDepartment {

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
		Long id = 1l;
		when(departmentService.getDepartmentById(id)).thenReturn(departmentRepository.findOne(id));
		mockMvc.perform(get("/getDepartment/" + id)).andDo(print());
	}

}
