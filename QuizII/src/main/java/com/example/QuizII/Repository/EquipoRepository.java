package com.example.QuizII.Repository;

import com.example.QuizII.Model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {
}
