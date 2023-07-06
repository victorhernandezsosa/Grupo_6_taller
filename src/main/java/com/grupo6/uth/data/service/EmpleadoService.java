package com.grupo6.uth.data.service;

import com.grupo6.uth.data.entity.Empleado;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {

    private final EmpleadoRepository repository;

    public EmpleadoService(EmpleadoRepository repository) {
        this.repository = repository;
    }

    public Optional<Empleado> get(Long id) {
        return repository.findById(id);
    }

    public Empleado update(Empleado entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Page<Empleado> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<Empleado> list(Pageable pageable, Specification<Empleado> filter) {
        return repository.findAll(filter, pageable);
    }

    public int count() {
        return (int) repository.count();
    }

}
