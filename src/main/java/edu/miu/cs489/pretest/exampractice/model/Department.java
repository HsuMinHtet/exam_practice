package edu.miu.cs489.pretest.exampractice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    private List<Course> courseList=new ArrayList<Course>(); //-|----------<-

    public Department(String name, List<Course> courseList) {
        this.name = name;
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                '}';
    }

    public void printDepartWithCourseList() {
        System.out.println("Department: " + name);
        System.out.println("Courses Name:");
        if (courseList != null && !courseList.isEmpty()) {
            courseList.forEach(course -> System.out.println(" - " + course.getName()));
        }
        System.out.println();
    }


}
