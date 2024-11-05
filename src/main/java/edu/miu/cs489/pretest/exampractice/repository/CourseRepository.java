package edu.miu.cs489.pretest.exampractice.repository;

import edu.miu.cs489.pretest.exampractice.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findAllByDepartment_NameOrderByName(String name);
}
