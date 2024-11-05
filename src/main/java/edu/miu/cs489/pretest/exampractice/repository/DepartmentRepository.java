package edu.miu.cs489.pretest.exampractice.repository;

import edu.miu.cs489.pretest.exampractice.model.Course;
import edu.miu.cs489.pretest.exampractice.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
    List<Department> getAllByOrderByNameAsc();
}
