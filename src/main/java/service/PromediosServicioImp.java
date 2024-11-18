package service;

import java.util.List;

public class PromediosServicioImp {

    public Double calcularPromedio(List<Double> notas) {

        double sumNotas = 0;
        double promedio = 0;

        for (Double nota : notas) {
            sumNotas += nota;
        }
        if (notas.isEmpty()){
            System.out.println("El estudiante no posee notas registradas");
            return 0.0;
            } else {
            promedio = sumNotas / notas.size();
        }

        return promedio;
    }
}
