package service;

import model.Alumno;
import model.Materia;
import model.MateriaEnum;

import java.util.*;


public class AlumnoService {
    private Map<String, Alumno> listaAlumnos = new HashMap<>();

    {
        Materia alonsoMate = new Materia(MateriaEnum.MATEMATICAS, new ArrayList<>(Arrays.asList(6.0, 4.5, 5.8)));
        Materia alonsoLengua = new Materia(MateriaEnum.LENGUAJE, new ArrayList<>(Arrays.asList(4.3, 6.0, 5.3)));
        Alumno alonso = new Alumno("12.345.678-9", "Alonso", "Meza", "La comarca 05", new ArrayList<>(Arrays.asList(alonsoMate, alonsoLengua)));

        listaAlumnos.put(alonso.getRut(), alonso);
    }

    public void crearAlumno(Alumno alumno) {
        if (listaAlumnos.containsKey(alumno.getRut())) {
            System.out.println("El alumno se encuentra registrado");
            return;
        }
        listaAlumnos.put(alumno.getRut(), alumno);
        System.out.println("Estudiante agregado correctamente");

    }

    public void agregarMateri(String rutAlumno, Materia currentMateria) {
        if (listaAlumnos.containsKey(rutAlumno)) {
            Alumno estudiante = listaAlumnos.get(rutAlumno);
            estudiante.getMaterias().add(currentMateria);
            System.out.println("Se agregó correctamente la Materia");
        } else {
            System.out.println("No se encuentra regsitrado el rut del alumno");
        }
    }

    public List<Materia> materiasPorAlumnos(String rut) {
        if (listaAlumnos.containsKey(rut)) {
            Alumno estudiante = listaAlumnos.get(rut);
            List<Materia> materias = estudiante.getMaterias();


            System.out.println("Materias del estudiante " + estudiante.getNombre() + " " + estudiante.getApellido() + ":");
            if (materias.isEmpty()) {
                System.out.println("No tiene materias registradas.");
            } else {
                for (Materia materia : materias) {
                    System.out.println("- " + materia.getNombre());
                }
            }

            return materias;
        } else {
            System.out.println("No se encuentra el alumno.");
            return Collections.emptyList();
        }
    }

    public List<Alumno> listarAlumnos() {

        return new ArrayList<>(listaAlumnos.values());
    }

    public boolean existenciaEstduiante(String rut) {
        return listaAlumnos.containsKey(rut);
    }

    public Alumno estaElEstudiante(String rut) {
        return listaAlumnos.get(rut);
    }
}
