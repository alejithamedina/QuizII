package com.example.QuizII.Service;

import com.example.QuizII.Model.Estadisticas;
import com.example.QuizII.Repository.EstadisticasRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadisticasService {

    @Autowired
    public EstadisticasRepository estadisticasRepository;

    //metodos

    public Estadisticas guardar(Estadisticas estadisticas){
        return estadisticasRepository.save(estadisticas);
    }
    public List<Estadisticas> listar(){
        return estadisticasRepository.findAll();
    }
    public Optional<Estadisticas> buscarPorId(Long id) {
        return estadisticasRepository.findById(id);
    }
    public void eliminarPorId(Long id) {
        if (!estadisticasRepository.existsById(id)) {
            throw new EntityNotFoundException("Estadisticas no encontradas con id " + id);
        }
        estadisticasRepository.deleteById(id);
    }


}
