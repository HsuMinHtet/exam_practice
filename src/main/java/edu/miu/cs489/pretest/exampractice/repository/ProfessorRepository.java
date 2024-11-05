package edu.miu.cs489.pretest.exampractice.repository;

import edu.miu.cs489.pretest.exampractice.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    List<Professor> findAllByOrderByLastNameAsc();
}
