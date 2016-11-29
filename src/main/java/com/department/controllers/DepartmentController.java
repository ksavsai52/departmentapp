package com.department.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.department.domain.Department;
import com.department.service.DepartmentService;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(value = "/getDepartment/{id}", method = RequestMethod.GET)
	public @ResponseBody Department getDepartment(@PathVariable("id") Long id) {
		Department department = departmentService.getDepartmentById(id);
		return department;
	}
	
	@RequestMapping(value="/createDepartment", method = RequestMethod.POST)
	public @ResponseBody Department createDepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}

}
