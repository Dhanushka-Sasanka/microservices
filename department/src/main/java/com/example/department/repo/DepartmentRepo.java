package com.example.department.repo;

import com.example.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {

    Department findAllByDepartmentID(Long departmentID);
}
