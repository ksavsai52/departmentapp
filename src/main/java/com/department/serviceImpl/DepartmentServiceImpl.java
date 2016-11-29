package com.department.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.department.domain.Department;
import com.department.repositories.DepartmentRepository;
import com.department.service.DepartmentService;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department getDepartmentById(Long id) {
		return departmentRepository.findOne(id);
	}

	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

}
