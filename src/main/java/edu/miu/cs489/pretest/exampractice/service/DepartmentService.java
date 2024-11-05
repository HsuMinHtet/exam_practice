package edu.miu.cs489.pretest.exampractice.service;

import edu.miu.cs489.pretest.exampractice.model.Department;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DepartmentService {
    List<Department> getAllDepartments();
    Optional<Department> updateDepartment(Department department);
    Optional<Department> saveDepartment(Department department);
}
