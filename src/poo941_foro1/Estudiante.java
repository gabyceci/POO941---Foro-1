/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo941_foro1;

/**
 *
 * @author Latitude E5470
 */
public class Estudiante {
    private String carnet;
    private String nombreCompleto;
 
    public Estudiante(String carnet, String nombreCompleto) {
        this.carnet = carnet;
        this.nombreCompleto = nombreCompleto;
    }
 
    public String getCarnet() {
        return carnet;
    }
 
    public String getNombreCompleto() {
        return nombreCompleto;
    }
 
    @Override
    public String toString() {
        return "Carnet: " + carnet + "\nNombre: " + nombreCompleto;
    }
}
 
