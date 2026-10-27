# TAREAS_JJ

Prácticas del módulo **MF0493_3 · Implantación de aplicaciones web** (Hazerta).
Aplicaciones web Java con **Spring Boot + Spring MVC + Hibernate/JPA + Maven + H2 + Thymeleaf**.

**Autor:** Juan José García Geijo

## Contenido del repositorio

| Carpeta | Descripción |
|---|---|
| `ensayo_libros/` | Proyecto de práctica resuelto: gestión de libros (CRUD básico). 8 pruebas. |
| `ensayo_libros_resuelto/` | Copia de referencia del mismo ensayo, sin los comentarios de trabajo. |
| `simulacro_peliculas/` | Simulacro de examen resuelto: cartelera de películas. 8 pruebas. |
| `0_DOC_SOLUCIONES Y CAMBIOS/` | Informe de análisis de errores y registro de cambios de la solución. |

## Estado de la verificación (27/10/2026)

| Proyecto | Pruebas | Resultado |
|---|---|---|
| `ensayo_libros` | 8 | 8 correctas (0 fallos, 0 errores) |
| `ensayo_libros_resuelto` | 8 | 8 correctas (0 fallos, 0 errores) |
| `simulacro_peliculas` | 8 | 8 correctas (0 fallos, 0 errores) |
| **Total** | **24** | **24 correctas (100 %)** |

Además se generó `target/app.jar` y se comprobó la aplicación en ejecución: listado en
`http://localhost:8080/libros`, alta desde el formulario y borrado de registros.

## Cómo ejecutar los proyectos

Los proyectos necesitan el kit de herramientas del módulo (JDK 17, Maven y repositorio
local de dependencias). **Copia la carpeta del kit a `C:\examen`** antes de trabajar: en
rutas con etiquetas de integridad heredadas (por ejemplo, una carpeta restaurada desde
otro equipo) Windows puede denegar la escritura a `java.exe` y Maven falla con
`AccessDeniedException`.

Con el kit en su sitio, dentro de cada proyecto:

| Script | Para qué sirve |
|---|---|
| `probar.bat` | Ejecuta las pruebas JUnit (`mvn test`). |
| `arrancar.bat` | Arranca la aplicación en `http://localhost:8080`. |
| `empaquetar.bat` | Genera `target/app.jar`. |
| `ejecutar_jar.bat` | Ejecuta el JAR empaquetado. |

También se puede arrancar el JAR en cualquier equipo con Java 17 o superior:

```bash
java -jar target/app.jar
```

## Arquitectura

```
Navegador → Controller (Spring MVC) → Repository (Spring Data JPA) → Hibernate → H2
                ↓
          Vista Thymeleaf (lista.html)
```

- `Application.java`: punto de entrada de Spring Boot.
- `Libro.java` / `Pelicula.java`: entidades JPA (`@Entity`, `@Id`, `@GeneratedValue`).
- `*Repository.java`: interfaces que extienden `JpaRepository`.
- `*Controller.java`: controladores con las rutas de listado, alta y borrado.
- `lista.html`: vista Thymeleaf con la tabla y el formulario.
- `data.sql`: datos de ejemplo (3 registros).
- `src/test`: 8 pruebas automáticas por proyecto (estructura y funcionales).

## Documentación

La memoria de la práctica está en `0_DOC_SOLUCIONES Y CAMBIOS/`:

- `Garcia_Geijo_Juan_Jose_Documentacion.docx` — versión editable en Word.
- `Garcia_Geijo_Juan_Jose_Documentacion.pdf` — versión para entregar.
- `ANALISIS_DE_ERRORES.docx` y `REGISTRO_DE_CAMBIOS_Y_SOLUCIONES.docx` — informes técnicos.

## Pendientes para la entrega oficial

1. Ampliar al pliego completo si se exige: 2 tablas relacionadas 1:N, capa `Service`,
   edición de registros y validación de formularios.

El ZIP de entrega ya está generado sin la carpeta `target/`.

## Repositorio

Repositorio local **TAREAS_JJ**, publicado en:

<https://github.com/Noes3no/Ejercicio_jj>

Rama `main`, 6 commits descriptivos, autor `jj`. El historial está agrupado por
funcionalidad: estructura y scripts, entidad y repositorio JPA, controlador y vista,
simulacro de películas, documentación y README.
