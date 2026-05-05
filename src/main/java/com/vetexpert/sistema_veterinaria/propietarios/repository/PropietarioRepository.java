package com.vetexpert.sistema_veterinaria.propietarios.repository;

import com.vetexpert.sistema_veterinaria.propietarios.model.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositorio JPA para la entidad Propietario.
 * Proporciona operaciones CRUD y consultas personalizadas.
 */
@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Long> {

    /**
     * Busca un propietario por su DNI.
     * Utilizado para validar unicidad.
     */
    Optional<Propietario> findByDni(String dni);

    /**
     * Verifica si existe un propietario con el DNI dado.
     */
    boolean existsByDni(String dni);

    /**
     * Busca un propietario por su correo electrónico.
     */
    Optional<Propietario> findByCorreo(String correo);
}
