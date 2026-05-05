package com.vetexpert.sistema_veterinaria.config;

import com.vetexpert.sistema_veterinaria.auth.model.Usuario;
import com.vetexpert.sistema_veterinaria.auth.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Componente que inicializa datos por defecto en la base de datos.
 * Crea un usuario administrador si no existe.
 */
@Component
public class DataInitializer implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;

    public DataInitializer(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(String... args) {
        // Crear usuario admin por defecto si no existe
        if (!usuarioRepository.existsByUsername("admin")) {
            Usuario admin = new Usuario("admin", "admin123", "ADMIN");
            usuarioRepository.save(admin);
            System.out.println(">>> Usuario administrador creado: admin / admin123");
        }

        // Crear usuario veterinario por defecto si no existe
        if (!usuarioRepository.existsByUsername("veterinario")) {
            Usuario vet = new Usuario("veterinario", "vet123", "VETERINARIO");
            usuarioRepository.save(vet);
            System.out.println(">>> Usuario veterinario creado: veterinario / vet123");
        }
    }
}
