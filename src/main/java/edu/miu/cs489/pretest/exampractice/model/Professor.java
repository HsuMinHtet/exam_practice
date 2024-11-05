package edu.miu.cs489.pretest.exampractice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "professor")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstName;
    private String lastName;
    @ManyToOne
    private Department departments; //->-------------|-

    @ManyToMany(mappedBy = "professorList")
    private List<Course> courseList;

    public Professor(String firstName, String lastName, Department departments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", departments=" + departments +
                '}';
    }
}
