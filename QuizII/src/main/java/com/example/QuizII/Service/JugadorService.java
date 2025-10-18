package com.example.QuizII.Service;

import com.example.QuizII.Model.Jugador;
import com.example.QuizII.Repository.JugadorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {
    @Autowired
    public JugadorRepository jugadorRepository;

    //metodos

    public Jugador guardar(Jugador jugador){
        return jugadorRepository.save(jugador);
    }
    public List<Jugador> listar(){
        return jugadorRepository.findAll();
    }
    public Optional<Jugador> buscarPorId(Long id) {
        return jugadorRepository.findById(id);
    }
    public void eliminarPorId(Long id) {
        if (!jugadorRepository.existsById(id)) {
            throw new EntityNotFoundException("Jugador no encontrado con id " + id);
        }
        jugadorRepository.deleteById(id);
    }


}
