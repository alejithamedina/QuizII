package com.example.QuizII.Service;

import com.example.QuizII.Model.Partido;
import com.example.QuizII.Repository.PartidoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidoService {
    @Autowired
    public PartidoRepository partidoRepository;

    //metodos

    public Partido guardar(Partido partido){
        return partidoRepository.save(partido);
    }
    public List<Partido> listar(){
        return partidoRepository.findAll();
    }
    public Optional<Partido> buscarPorId(Long id) {
        return partidoRepository.findById(id);
    }
    public void eliminarPorId(Long id) {
        if (!partidoRepository.existsById(id)) {
            throw new EntityNotFoundException("Partido no encontrado con id " + id);
        }
        partidoRepository.deleteById(id);
    }


}
