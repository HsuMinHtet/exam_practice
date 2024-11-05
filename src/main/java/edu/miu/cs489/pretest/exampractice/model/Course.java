package edu.miu.cs489.pretest.exampractice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="course_has_professor",
            joinColumns = @JoinColumn(name="course_id"),
            inverseJoinColumns = @JoinColumn(name="professor_id")
    )
    private List<Professor> professorList; //->----<-
    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department; //>--------------|-

    public Course(String name, List<Professor> professorList, Department department) {
        this.name = name;
        this.professorList = professorList;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                '}';
    }
}
