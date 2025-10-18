package com.example.QuizII.Service;

import com.example.QuizII.Model.Equipo;
import com.example.QuizII.Repository.EquipoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {
    @Autowired
    public EquipoRepository equipoRepository;

    //metodos

    public Equipo guardar(Equipo equipo){
        return equipoRepository.save(equipo);
    }
    public List<Equipo> listar(){
        return equipoRepository.findAll();
    }
    public Optional<Equipo> buscarPorId(Long id) {
        return equipoRepository.findById(id);
    }
    public void eliminarPorId(Long id) {
        if (!equipoRepository.existsById(id)) {
            throw new EntityNotFoundException("Equipo no encontrado con id " + id);
        }
        equipoRepository.deleteById(id);
    }


}
