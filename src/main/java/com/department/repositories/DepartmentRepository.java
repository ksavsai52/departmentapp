package com.department.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.department.domain.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
