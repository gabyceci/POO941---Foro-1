/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo941_foro1;
 
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;
 
/**
 * FORO 1 POO
* Jose Alejandro Henríquez Hernández 
* Gabriela Cecibel Arévalo Molina 
* David Josué Pérez Hernández 
* Alisson Andrea Lopez Vasquez  
* Diego Andrés Guevara Girón 
 *
 * @author Latitude E5470
 */
public class POO941_Foro1 {
 
    // Map
    private static Map<String, Estudiante> estudiantes = new HashMap<>();
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion;
        do {
            String menu = "Sistema de estudiantes\n\n"
                    + "1. Ingresar alumno\n"
                    + "2. Buscar alumno\n"
                    + "3. Eliminar alumno\n"
                    + "4. Mostrar todos los alumnos\n"
                    + "5. Salir";
 
            String respuesta = JOptionPane.showInputDialog(null, menu, "Menu", JOptionPane.PLAIN_MESSAGE);
 
            if (respuesta == null) break;
 
            try {
                opcion = Integer.parseInt(respuesta.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese una opcion valida (numero).");
                continue;
            }
 
            switch (opcion) {
                case 1:
                    ingresarAlumno();
                    break;
                case 2:
                    buscarAlumno();
                    break;
                case 3:
                    eliminarAlumno();
                    break;
                case 4:
                    mostrarTodos();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida.");
            }
        } while (true);
    }
 
    // Ingresar alumnos, solicitando carnet y nombre completo
    private static void ingresarAlumno() {
        String carnet = JOptionPane.showInputDialog(null, "Ingrese el carnet del alumno:");
        if (carnet == null || carnet.trim().isEmpty()) return;
 
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre completo del alumno:");
        if (nombre == null || nombre.trim().isEmpty()) return;
 
        Estudiante nuevo = new Estudiante(carnet.trim(), nombre.trim());
        estudiantes.put(carnet.trim(), nuevo); // put() -> asigna/actualiza valor en el Map
 
        JOptionPane.showMessageDialog(null, "Alumno ingresado exitosamente");
    }
 
    // Buscar alumno por carnet y mostrarlo
    private static void buscarAlumno() {
        String carnet = JOptionPane.showInputDialog(null, "Ingrese el carnet a buscar:");
        if (carnet == null) return;
 
        Estudiante encontrado = estudiantes.get(carnet.trim()); // get() -> busqueda O(1) por llave
 
        if (encontrado != null) {
            JOptionPane.showMessageDialog(null, encontrado.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Alumno no encontrado, no se puede Mostrar");
        }
    }
 
    // Eliminar alumno por carnet
    private static void eliminarAlumno() {
        String carnet = JOptionPane.showInputDialog(null, "Ingrese el carnet a eliminar:");
        if (carnet == null) return;
 
        if (estudiantes.containsKey(carnet.trim())) {
            estudiantes.remove(carnet.trim()); // remove() -> elimina por llave
            JOptionPane.showMessageDialog(null, "Alumno eliminado exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "Alumno no encontrado, No se puede Eliminar");
        }
    }
 
    // Mostrar todos los alumnos registrados
    private static void mostrarTodos() {
        if (estudiantes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay alumnos registrados.");
            return;
        }
 
        StringBuilder sb = new StringBuilder("LISTA DE ALUMNOS:\n\n");
        for (Estudiante e : estudiantes.values()) {
            sb.append(e.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
