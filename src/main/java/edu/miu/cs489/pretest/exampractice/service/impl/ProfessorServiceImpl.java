package edu.miu.cs489.pretest.exampractice.service.impl;

import edu.miu.cs489.pretest.exampractice.model.Professor;
import edu.miu.cs489.pretest.exampractice.repository.ProfessorRepository;
import edu.miu.cs489.pretest.exampractice.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;

    @Override
    public Optional<Professor> addProfessor(Professor professor) {
        Professor savedProfessor= professorRepository.save(professor);
        return Optional.of(savedProfessor);
    }

    @Override
    public List<Professor> getAllProfessorsByLasName() {
        return professorRepository.findAllByOrderByLastNameAsc();
    }
}
