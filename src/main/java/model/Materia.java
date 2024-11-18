package model;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private MateriaEnum nombre;
    private List<Double> notas = new ArrayList<>();

    public Materia() {
    }

    public Materia(MateriaEnum nombre) {
        this.nombre = nombre;
    }

    public Materia(List<Double> notas) {
        this.notas = notas;
    }

    public Materia(MateriaEnum nombre, List<Double> notas) {
        this.nombre = nombre;
        this.notas = notas;
    }

    public MateriaEnum getNombre() {
        return nombre;
    }

    public void setNombre(MateriaEnum nombre) {
        this.nombre = nombre;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "Materia{" +
                "nombre=" + nombre +
                ", notas=" + notas +
                '}';
    }
}
