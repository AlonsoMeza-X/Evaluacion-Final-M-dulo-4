package vistas;

import model.Alumno;
import model.Materia;
import model.MateriaEnum;
import service.AlumnoService;
import service.ArchivosService;
import service.PromediosServicioImp;
import until.ScannerSingleton;

import java.util.Scanner;

public class Menu extends MenuTemplate {
    private final String RUTA_ARCHIVO = "src/main/java/recurse/estudiantes.txt";
    private final AlumnoService alumnoService = new AlumnoService();
    private final PromediosServicioImp promediosServicioImp = new PromediosServicioImp();
    private final ArchivosService archivosService = new ArchivosService(promediosServicioImp);

    private Scanner sc = ScannerSingleton.getInstance();

    public Menu() {
        super();
    }

    @Override
    public void expotardatos() {
        try {
            System.out.println("=== Exportar Datos ===");


            if (alumnoService.listarAlumnos().isEmpty()) {
                System.out.println("No hay alumnos registrados para exportar");
                return;
            }


            archivosService.exportarDatos(alumnoService.listarAlumnos(), RUTA_ARCHIVO);
            System.out.println("Los datos han sido exportados exitosamente a: " + RUTA_ARCHIVO);
        } catch (Exception e) {
            System.out.println("Error al exportar los datos: " + e.getMessage());
        }
    }

    @Override
    public void crearAlumnos() {
        String run, nombre, apellido, direccion;

        try {
            System.out.println("Ingrese el RUN del estudiante");
            run = sc.nextLine();
            System.out.println("Ingrese el Nombre del estudiante");
            nombre = sc.nextLine();
            System.out.println("Ingrese el Apellido del estudiante");
            apellido = sc.nextLine();
            System.out.println("Ingrese la direccion de la casa");
            direccion = sc.nextLine();

            Alumno estudiante = new Alumno(run, nombre, apellido, direccion);

            alumnoService.crearAlumno(estudiante);

        } catch (IllegalArgumentException e) {
            System.out.println("Porfavor ingesar un texto valido y no un numero");
            ScannerSingleton.closeInstance();
            crearAlumnos();
        }
    }

    @Override
    public void agregarMateria() {
        int materia;
        String rut;
        MateriaEnum enums = null;

        System.out.println("Ingrese el Rut del Estudiante para registrar la Materia");
        for (Alumno estudiante : alumnoService.listarAlumnos()) {
            System.out.println("Run del estudinate :" + estudiante.getRut() + ", de nombre: " + estudiante.getNombre());
        }

        rut = sc.nextLine();

        if (!alumnoService.existenciaEstduiante(rut)) {
            System.out.println("El alumno no se encuentra");
            return;
        }


        alumnoService.materiasPorAlumnos(rut);
        System.out.println();

        System.out.println("Ingrese una Materia");
        System.out.println("""
                Elija una de las opciones :
                1. Matematicas
                2. Lenguaje
                3. Ciencias
                4. Historia
                5. Salir""");

        materia = sc.nextInt();
        sc.nextLine();

        switch (materia) {
            case 1:
                enums = MateriaEnum.MATEMATICAS;
                break;
            case 2:
                enums = MateriaEnum.LENGUAJE;
                break;
            case 3:
                enums = MateriaEnum.CIENCIA;
                break;
            case 4:
                enums = MateriaEnum.HISTORIA;
                break;
            case 5:
                System.out.println("Saliendo del registro de materias.");
                return;
            default:
                System.out.println("Porfavor elegir entre las opciones 1 al 5");
                return;
        }

        try {
            Materia nuevaMateria = new Materia(enums);
            alumnoService.agregarMateri(rut, nuevaMateria);
        } catch (Exception e) {
            System.out.println("Ocurrió un error al agregar la materia");
        }

    }

    @Override
    public void agregarNotasPasouno() {
        String rut;
        double nota;


        System.out.println("Listado de Estudiantes:");
        for (Alumno estudiante : alumnoService.listarAlumnos()) {
            System.out.println("Run del estudiante: " + estudiante.getRut() + ", Nombre: " + estudiante.getNombre());
        }


        System.out.println("Ingrese el Rut del Estudiante para agregar las notas:");
        rut = sc.nextLine();


        if (!alumnoService.existenciaEstduiante(rut)) {
            System.out.println("El alumno no se encuentra registrado.");
            return;
        }


        alumnoService.materiasPorAlumnos(rut);
        System.out.println();


        System.out.println("Ingrese el nombre de la materia:");
        String materiaNombre = sc.nextLine();


        Alumno estudiante = alumnoService.estaElEstudiante(rut);
        Materia materia = null;
        for (Materia m : estudiante.getMaterias()) {
            if (m.getNombre().toString().equalsIgnoreCase(materiaNombre)) {
                materia = m;
                break;
            }
        }

        if (materia == null) {
            System.out.println("El estudiante no está cursando esta materia");
            return;
        }

        try {
            System.out.println("Ingrese una nota entre 1.0 y 7.0:");
            nota = Double.parseDouble(sc.nextLine());

            if (nota >= 1.0 && nota <= 7.0) {
                materia.getNotas().add(nota);
                System.out.println("Nota agregada correctamente.");
            } else {
                System.out.println("La nota debe estar entre 1.0 y 7.0.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error al ingresar la nota. Ingresa un número para la nota.");
        }
    }

    @Override
    public void listarAlumnos() {
        System.out.println("Lista de los Estudiantes");

        for (Alumno estudiante : alumnoService.listarAlumnos()) {
            System.out.println(estudiante);
        }
    }

    @Override
    public void terminarPrograma() {
        System.out.println("Gracias por vivistar al regsitro de alumnos");
    }
}
