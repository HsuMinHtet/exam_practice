package edu.miu.cs489.pretest.exampractice.service;

import edu.miu.cs489.pretest.exampractice.model.Professor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProfessorService {
    Optional<Professor> addProfessor(Professor professor);
    List<Professor> getAllProfessorsByLasName();
}
