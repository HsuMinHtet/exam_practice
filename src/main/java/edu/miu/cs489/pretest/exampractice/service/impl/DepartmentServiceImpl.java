package edu.miu.cs489.pretest.exampractice.service.impl;

import edu.miu.cs489.pretest.exampractice.model.Department;
import edu.miu.cs489.pretest.exampractice.repository.DepartmentRepository;
import edu.miu.cs489.pretest.exampractice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.getAllByOrderByNameAsc();
    }

    @Override
    public Optional<Department> updateDepartment(Department department) {
        Optional<Department> foundDepartment = departmentRepository.findById(department.getId());
        foundDepartment.ifPresent(department1 -> {
            departmentRepository.save(department);
        });
        return foundDepartment;
    }

    @Override
    public Optional<Department> saveDepartment(Department department) {
        Department savedDepartment = departmentRepository.save(department);
        return Optional.of(savedDepartment);
    }
}
