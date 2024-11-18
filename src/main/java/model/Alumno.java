package model;

import service.PromediosServicioImp;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String rut;
    private String nombre;
    private String apellido;
    private String direccion;
    private List<Materia> materias = new ArrayList<>();

    public Alumno() {
    }

    public Alumno(String rut, String nombre, String apellido, String direccion) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }

    public Alumno(String rut, String nombre, String apellido, String direccion, List<Materia> materias) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.materias = materias;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("====================================================\n");
        sb.append(String.format("%-15s %-20s %-20s\n", "RUT", "Nombre Completo", "Dirección"));
        sb.append("====================================================\n");
        sb.append(String.format("%-15s %-20s %-20s\n",
                this.rut,
                this.nombre + " " + this.apellido,
                this.direccion));
        sb.append("====================================================\n");


        if (materias != null && !materias.isEmpty()) {
            sb.append("    Materias:\n");
            for (Materia materia : materias) {
                sb.append(String.format("        %-15s Promedio: %.1f\n",
                        materia.getNombre(),
                        new PromediosServicioImp().calcularPromedio(materia.getNotas())));
            }
        }
        return sb.toString();
    }
}
