package com.department.service;

import com.department.domain.Department;

public interface DepartmentService {

	public Department getDepartmentById(Long id);

	public Department saveDepartment(Department department);

}
