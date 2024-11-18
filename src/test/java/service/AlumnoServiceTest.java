package service;

import model.Alumno;
import model.Materia;
import model.MateriaEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AlumnoServiceTest {
    private AlumnoService alumnoService;
    @Mock
    private AlumnoService alumnoServices;

    @BeforeEach
    void setUp() {
        alumnoService = new AlumnoService();
    }

    @Test
    @DisplayName("Test de creación de un alumno")
    void crearAlumnoTest() {
        Alumno alumno = new Alumno("12345678-9", "Juan", "Pérez", "Calle Ficticia 123");
        alumnoService.crearAlumno(alumno);

        List<Alumno> estudiantes = alumnoService.listarAlumnos();
        assertTrue(estudiantes.contains(alumno), "El alumno no fue creado correctamente.");
    }

    @Test
    @DisplayName("Test para agregar una materia")
    void agregarMateriaTest() {
        Alumno alumno = new Alumno("12345678-9", "Juan", "Pérez", "Calle Ficticia 123");
        alumnoService.crearAlumno(alumno);

        Materia materia = new Materia(MateriaEnum.MATEMATICAS);

        alumnoService.agregarMateri(alumno.getRut(), materia);

        assertTrue(alumno.getMaterias().contains(materia), "La materia no fue agregada correctamente.");
    }

    @BeforeEach
    void setUps() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void materiasPorAlumnosTest() {
        Alumno alumno = new Alumno("12345678-9", "Juan", "Pérez", "Calle Ficticia 123");
        Materia materia = new Materia(MateriaEnum.MATEMATICAS);

        when(alumnoServices.listarAlumnos()).thenReturn(List.of(alumno));

        when(alumnoServices.materiasPorAlumnos(alumno.getRut())).thenReturn(List.of(materia));

        List<Alumno> estudiantes = alumnoServices.listarAlumnos();
        assertTrue(estudiantes.contains(alumno), "El alumno no fue encontrado.");

        List<Materia> materias = alumnoServices.materiasPorAlumnos(alumno.getRut());

        assertFalse(materias.isEmpty(), "El alumno no tiene materias registradas.");
        assertTrue(materias.contains(materia), "La materia no se ha añadido correctamente.");
    }
}