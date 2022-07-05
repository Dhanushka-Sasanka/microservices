package com.example.department.controller;

import com.example.department.domain.APIResponse;
import com.example.department.entity.Department;
import com.example.department.service.DepartmentService;
import com.example.department.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.DEPARTMENT_REQ_MAPPING)
@Slf4j
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/")
    public APIResponse createDepartment(@RequestBody Department department) {
        log.info("createDepartment called.");
        Department savedDepartment = departmentService.createDepartment(department);
        log.info("savedDepartment : {}",savedDepartment);
        return APIResponse.builder()
                .responseCode(Constants.SUCCESS_CODE)
                .responseMsg(Constants.SUCCESS_MASSAGE)
                .data(savedDepartment)
                .build();

    }

    @GetMapping("/departments")
    public APIResponse getAllUsers() {
        log.info("getAllUsers called.");
        List<Department> allDepartment = departmentService.getAllDepartments();
        log.info("allDepartment : {}",allDepartment);
        return APIResponse.builder()
                .responseCode(Constants.SUCCESS_CODE)
                .responseMsg(Constants.GET_MESSAGE)
                .data(allDepartment)
                .build();

    }

    @GetMapping("/departments/{departmentID}")
    public APIResponse getDepartmentByUserID(@PathVariable("departmentID") Long departmentID) {
        log.info("getDepartmentByUserID called.");
        log.info("departmentID : {}",departmentID);
        Department departmentByUserID = departmentService.findDepartmentByDepartmentID(departmentID);
        log.info("departmentByUserID : {}",departmentByUserID);
        return APIResponse.builder()
                .responseCode(Constants.SUCCESS_CODE)
                .responseMsg(Constants.GET_MESSAGE)
                .data(departmentByUserID)
                .build();

    }


}
