package edu.miu.cs489.pretest.exampractice;

import edu.miu.cs489.pretest.exampractice.model.Course;
import edu.miu.cs489.pretest.exampractice.model.Department;
import edu.miu.cs489.pretest.exampractice.model.Professor;
import edu.miu.cs489.pretest.exampractice.repository.CourseRepository;
import edu.miu.cs489.pretest.exampractice.repository.DepartmentRepository;
import edu.miu.cs489.pretest.exampractice.repository.ProfessorRepository;
import edu.miu.cs489.pretest.exampractice.service.CourseService;
import edu.miu.cs489.pretest.exampractice.service.DepartmentService;
import edu.miu.cs489.pretest.exampractice.service.ProfessorService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class ExamPracticeApplication {
    private final ProfessorService professorService;
    private final CourseService courseService;
    private final DepartmentService departmentService;

    public static void main(String[] args) {
        SpringApplication.run(ExamPracticeApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            //create Department
            Department department=new Department("Computer Science",null);
            Department department1=new Department("Mathematics",null);
            Department department2=new Department("Physics",null);
            departmentService.saveDepartment(department);
            departmentService.saveDepartment(department1);
            departmentService.saveDepartment(department2);

            //create professor
            Professor professor= new Professor("Alice","Smith",department);
            Professor professor1= new Professor("John","Doe",department1);
            Professor professor2= new Professor("Emma","Johnson",department2);
            Professor professor3= new Professor("Daniel","Lee",department);

            professorService.addProfessor(professor);
            professorService.addProfessor(professor1);
            professorService.addProfessor(professor2);
            professorService.addProfessor(professor3);
            System.out.println();
            System.out.println("____________________________________________________________");
            System.out.println("<< 1. Professors Sorted By Last Name Ascending>>");
            professorService.getAllProfessorsByLasName().forEach(System.out::println);

            //Create Course
            List<Professor> professorList1 =new ArrayList<>();
            professorList1.add(professor);
            professorList1.add(professor3);
            Course course=new Course("Data Structures",professorList1,department);
            courseService.saveCourse(course);

            List<Professor> professorList2 =new ArrayList<>();
            professorList2.add(professor);
            Course course1=new Course("Algorithms",professorList2, department);
            courseService.saveCourse(course1);

            List<Professor> professorList3 =new ArrayList<>();
            professorList3.add(professor3);
            Course course2=new Course("Operating Systems",professorList3,department);
            courseService.saveCourse(course2);

            List<Professor> professorList4 =new ArrayList<>();
            professorList4.add(professor1);
            Course course3=new Course("Calculus",professorList4,department1);
            courseService.saveCourse(course3);

            List<Professor> professorList5 =new ArrayList<>();
            professorList5.add(professor1);
            Course course4=new Course("Linear Algebra",professorList5,department1);
            courseService.saveCourse(course4);

            List<Professor> professorList6 =new ArrayList<>();
            professorList6.add(professor2);
            Course course5=new Course("Mechanics",professorList6,department2);
            courseService.saveCourse(course5);

            List<Professor> professorList7 =new ArrayList<>();
            professorList7.add(professor2);
            Course course6=new Course("Quantum Physics",professorList7,department2);
            courseService.saveCourse(course6);
            System.out.println("____________________________________________________________");
            System.out.println("<< 2. Course in the Computer Science Department(Sorted by Course Name) >>");
            courseService.getCourseByDepartment("Computer Science").forEach(System.out::println);

            System.out.println("____________________________________________________________");
            System.out.println("<< 3. Departments With Their Course (Sorted by Department Name) >>");
            departmentService.getAllDepartments().forEach(Department::printDepartWithCourseList);

        };
    }

}
