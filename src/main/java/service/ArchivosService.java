package service;

import model.Alumno;
import model.Materia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArchivosService {
    List<Alumno> alumnosACargar = new ArrayList<>();
    PromediosServicioImp promedioServiceImp = new PromediosServicioImp();

    public ArchivosService(PromediosServicioImp promedioServiceImp) {
        this.promedioServiceImp = promedioServiceImp;
    }

    public void exportarDatos(List<Alumno> estudiante, String rutaArchivo) {
        if (estudiante == null || rutaArchivo == null || estudiante.isEmpty()) {
            return;
        }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {

                for (Alumno alumno : estudiante) {
                    writer.write(String.format("Alumno : Rut %s - Nombre %s\n",
                            alumno.getRut(),
                            alumno.getNombre())
                    );

                    for (Materia materia : alumno.getMaterias()) {
                        writer.write(String.format("Materia : %s - Promedio : %.1f\n",
                                materia.getNombre(),
                                promedioServiceImp.calcularPromedio(materia.getNotas())
                        ));
                    }
                    writer.write("\n");
                }

        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}
