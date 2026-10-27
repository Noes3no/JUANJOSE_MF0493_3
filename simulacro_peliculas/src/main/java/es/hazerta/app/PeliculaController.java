package es.hazerta.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controlador: recibe las peticiones del navegador, usa el repositorio
 * y devuelve el nombre de la vista (plantilla HTML).
 */
@Controller
public class PeliculaController {

    private final PeliculaRepository repo;

    // Spring nos "inyecta" el repositorio aquí. No tocar.
    public PeliculaController(PeliculaRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String inicio() {
        return "redirect:/peliculas";
    }

    @GetMapping("/peliculas")
    public String listar(Model model) {
        model.addAttribute("peliculas", repo.findAll());
        return "lista";
    }

    @PostMapping("/peliculas/guardar")
    public String guardar(@ModelAttribute Pelicula pelicula) {
        repo.save(pelicula);
        return "redirect:/peliculas";
    }

    @GetMapping("/peliculas/borrar/{id}")
    public String borrar(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/peliculas";
    }
}
