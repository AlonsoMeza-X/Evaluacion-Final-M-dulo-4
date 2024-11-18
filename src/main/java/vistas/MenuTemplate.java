package vistas;

import until.ScannerSingleton;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuTemplate {
    private final Scanner sc;

    public MenuTemplate() {
        this.sc = ScannerSingleton.getInstance();
    }

    public void iniciarMenu() {
        int option;
        try {
            do {
                System.out.println("""
                        ===================== 
                           Menú Principal:
                        =====================
                         ¿Qué desea realizar?
                        
                         1. Crear Alumnos
                         2. Listar Alumnos
                         3. Agregar Materias
                         4. Agregar Notas
                         5. Salir
                         6. Exportar Datos
                         Selección:""");

                option = sc.nextInt();
                sc.nextLine();
                System.out.println();
                switch (option) {
                    case 1:
                        crearAlumnos();
                        System.out.println();
                        break;
                    case 2:
                        listarAlumnos();
                        System.out.println();
                        break;
                    case 3:
                        agregarMateria();
                        System.out.println();
                        break;
                    case 4:
                        agregarNotasPasouno();
                        System.out.println();
                        break;
                    case 5:
                        terminarPrograma();
                        ScannerSingleton.closeInstance();
                        break;
                    case 6:
                        expotardatos();
                        System.out.println();
                        break;
                    default:
                        System.out.println("Porfavor, elegir las opcines entre 1 al 6");
                }
            } while (option != 5);
        } catch (InputMismatchException e) {
            System.out.println("Error: Debes ingresar un número válido.");
            iniciarMenu();
            ScannerSingleton.closeInstance();
        }
    }

    public void expotardatos() {
    }

    public void crearAlumnos() {
    }

    public void agregarMateria() {
    }

    public void agregarNotasPasouno() {
    }

    public void listarAlumnos() {
    }

    public void terminarPrograma() {
    }
}
