package edu.miu.cs489.pretest.exampractice.service.impl;

import edu.miu.cs489.pretest.exampractice.model.Course;
import edu.miu.cs489.pretest.exampractice.repository.CourseRepository;
import edu.miu.cs489.pretest.exampractice.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public Optional<Course> saveCourse(Course course) {
        Course course1 = courseRepository.save(course);
        return Optional.of(course1);
    }

    @Override
    public List<Course> getCourseByDepartment(String departmentName) {
        return courseRepository.findAllByDepartment_NameOrderByName(departmentName);
    }
}
