package com.grupo6.uth.data.service;

import com.grupo6.uth.data.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>, JpaSpecificationExecutor<Empleado> {

}
