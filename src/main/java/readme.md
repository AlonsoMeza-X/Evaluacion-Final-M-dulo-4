# ALUMNOS Y ASIGNATURAS

## INSTRUCCIONES
Lee cuidadosamente cada una de las cuestiones que se te presentan a continuación y responde de acuerdo con lo solicitado.

El Colegio Latinoamericano necesita desarrollar una aplicación que permita llevar el control de las notas de los estudiantes de 1ro medio y debe cumplir con las siguientes características:

---

## DESCRIPCIÓN:

### MENÚ
La aplicación debe contar con un menú el cual permita:
- Cargar un archivo con datos.
- Crear alumno.
- Agregar materia a alumno.
- Agregar notas.
- Exportar datos a un archivo.

### AGREGAR DATOS
Se debe permitir:
- Crear nuevos alumnos.
- Crear nuevas materias.
- Asignar materias a alumnos.
- Agregar notas a distintas materias.

### CÁLCULO DE PROMEDIOS
Se debe agregar la funcionalidad para calcular los promedios de cada materia y alumno.

### EXPORTAR DATOS
Se debe generar un archivo `.txt` con el promedio de notas de cada alumno existente. El resultado en el archivo `.txt` puede ser similar a lo siguiente:

Alumno : 17.423.112-4 - Samuel
Materia : MATEMATICAS - Promedio : 4.1
Alumno : 18.546.232-1 - Pepe
Materia : MATEMATICAS - Promedio : 4.4
Materia : LENGUAJE - Promedio : 3.4


---

## HITO 1

1. **Crear proyecto en Eclipse como Proyecto Maven simple** y crear la clase `MenuTemplate` en la carpeta `vistas`.
    - Implementar un `Scanner` para recibir datos por consola.
    - Métodos iniciales:
        - `exportarDatos`, `crearAlumno`, `agregarMateria`, `agregarNotaPasoUno`, `listarAlumnos`, `terminarPrograma`.
        - `iniciarMenu`: muestra el menú principal y enlaza los demás métodos según la entrada del usuario.
    - **Nota:** Solo `iniciarMenu` no debe sobrescribirse en las subclases.

2. **Crear clase `Menu` en la carpeta `vistas` que hereda de `MenuTemplate`.**
    - Agregar atributos:
        - `alumnoServicio` (instancia de `AlumnoServicio`).
        - `archivoServicio` (instancia de `ArchivoServicio`).
    - Sobrescribir métodos para implementar:
        - `exportarDatos`, `crearAlumno`, `agregarMateria`, `agregarNotaPasoUno`, `listarAlumnos`, `terminarPrograma`.

3. **Crear clase `Alumno` en la carpeta `modelos` con atributos:**
    - `Rut`, `Nombre`, `Apellido`, `Dirección`, `Materias` (lista de materias).
    - Generar getters y setters para todos los atributos.

4. **Crear enumeración `MateriaEnum` en la carpeta `modelos` con valores:**
    - `MATEMATICAS`, `LENGUAJE`, `CIENCIA`, `HISTORIA`.

5. **Crear clase `Materia` en la carpeta `modelos` con atributos:**
    - `Nombre` (de tipo `MateriaEnum`).
    - `Notas` (lista de notas).
    - Generar getters y setters.

6. **Crear clase `AlumnoServicio` en la carpeta `servicios` con los siguientes métodos y atributos:**
    - Atributo `listaAlumnos` (tipo `Map<String, Alumno>`).
    - Métodos:
        - `crearAlumno` (recibe un `Alumno`).
        - `agregarMateria` (recibe `rutAlumno` y `currentMate`).
        - `materiasPorAlumnos` (retorna lista de materias por alumno).
        - `listarAlumnos` (retorna el mapa de alumnos).

---

## HITO 2

1. **Crear clase `ArchivoServicio` en la carpeta `servicios` con los atributos y métodos:**
    - `alumnosACargar` (tipo `List` para manejar datos iterados del archivo).
    - `promediosServicioImp` (instancia de `PromedioServicioImp`).
    - Método `exportarDatos` (recibe un `Map<String, Alumno>` y la ruta de exportación).

2. **Crear clase `PromedioServicioImp` en la carpeta `servicios` con método:**
    - `calcularPromedio`: recibe lista de valores y retorna el promedio.

3. **Añadir dependencias para pruebas (JUnit5 y Mockito).**

4. **Escribir pruebas unitarias para `PromedioServicio` y `AlumnoServicio`:**
    - Métodos de prueba en `PromedioServicio`:
        - `calcularPromedioTest`.
    - Métodos de prueba en `AlumnoServicio`:
        - `crearAlumnoTest`, `agregarMateriaTest`, `materiasPorAlumnosTest`, `listarAlumnosTest`.

---

## VISTAS AL MOMENTO DE EJECUTAR

#### MENÚ PRINCIPAL:  
1. Crear Alumnos
2. Listar Alumnos
3. Agregar Materias
4. Agregar Notas
5. Salir
6. Exportar Datos  
   Selección:  

#### CREAR ALUMNO:  
--- Crear Alumno ---  
Ingresa RUT: 1.111.111-1  
Ingresa nombre: Milton  
Ingresa apellido: P.  
Ingresa dirección: Casita 1  
--- ¡Alumno agregado! ---  

#### AGREGAR MATERIA:  
--- Agregar Materia ---
Ingresa rut del Alumno: 1.111.111-1

MATEMATICAS
LENGUAJE
CIENCIA
HISTORIA
Selecciona una Materia: 1
--- ¡Materia agregada! ---
shell
Copiar código

#### AGREGAR NOTA:
--- Agregar Nota ---
Ingresa rut del Alumno: 1.111.111-1
Alumno tiene las siguientes materias agregadas:

MATEMATICAS
Seleccionar materia: 1
Ingresar nota: 6.5
--- ¡Nota agregada a MATEMATICAS! ---
shell
Copiar código

#### LISTAR ALUMNOS:
--- Listar Alumnos ---
Datos Alumno
RUT: 1.111.111-1
Nombre: Milton
Apellido: P.
Dirección: Casita 1
Materias
MATEMATICAS
Notas:
[6.5]

shell
Copiar código

#### EXPORTAR DATOS:
--- Exportar Datos ---
Ingresa la ruta en donde se encuentra el archivo notas.csv:
/home/usuario/datos-exportados
Datos exportados correctamente.

yaml
Copiar código
Archivo generado:  
Alumno : 1.111.111-1 - Milton
Materia : MATEMATICAS - Promedio : 6.5

Copiar código






