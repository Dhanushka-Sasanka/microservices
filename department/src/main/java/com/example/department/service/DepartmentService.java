package com.example.department.service;

import com.example.department.entity.Department;
import com.example.department.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepo departmentRepo;

    @Autowired
    public DepartmentService(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public Department createDepartment(Department department) {
        return departmentRepo.save(department);
    }

    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }

    public Department findDepartmentByDepartmentID(Long departmentID) {
        return departmentRepo.findAllByDepartmentID(departmentID);
    }
}
