package edu.miu.cs489.pretest.exampractice.service;

import edu.miu.cs489.pretest.exampractice.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CourseService {
    Optional<Course> saveCourse(Course course);
    List<Course> getCourseByDepartment(String departmentName);
}
