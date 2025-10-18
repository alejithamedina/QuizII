package com.example.QuizII.Service;

import com.example.QuizII.Model.Entrenador;
import com.example.QuizII.Repository.EntrenadorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrenadorService {

    @Autowired
    public EntrenadorRepository entrenadorRepository;

    //metodos

    public Entrenador guardar(Entrenador entrenador){
        return entrenadorRepository.save(entrenador);
    }
    public List<Entrenador> listar(){
        return entrenadorRepository.findAll();
    }
    public Optional<Entrenador> buscarPorId(Long id) {
        return entrenadorRepository.findById(id);
    }
    public void eliminarPorId(Long id) {
        if (!entrenadorRepository.existsById(id)) {
            throw new EntityNotFoundException("Entrenador no encontrado con id " + id);
        }
        entrenadorRepository.deleteById(id);
    }


}
