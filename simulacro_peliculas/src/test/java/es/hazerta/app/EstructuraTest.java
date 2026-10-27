package es.hazerta.app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.lang.reflect.Field;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

/** Comprueba la estructura del código (no necesita arrancar la aplicación). */
class EstructuraTest {

    @Test
    @DisplayName("TODO 1: la clase Pelicula lleva @Entity")
    void todo1_entidad() {
        assertTrue(Pelicula.class.isAnnotationPresent(Entity.class),
                "Falta la anotacion @Entity en Pelicula");
    }

    @Test
    @DisplayName("TODO 2: el campo id lleva @Id")
    void todo2_id() throws Exception {
        Field f = Pelicula.class.getDeclaredField("id");
        assertTrue(f.isAnnotationPresent(Id.class), "Falta @Id en el campo id");
    }

    @Test
    @DisplayName("TODO 3: PeliculaRepository extiende JpaRepository")
    void todo3_repositorio() {
        assertTrue(JpaRepository.class.isAssignableFrom(PeliculaRepository.class),
                "PeliculaRepository debe extender JpaRepository<Pelicula, Long>");
    }

    @Test
    @DisplayName("TODO 4: PeliculaController lleva @Controller")
    void todo4_controlador() {
        assertTrue(PeliculaController.class.isAnnotationPresent(Controller.class),
                "Falta la anotacion @Controller");
    }
}
