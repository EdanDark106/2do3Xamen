package examen01;

import java.util.*;


class Persona {
    private String nombre;
    private int edad;
    private float pesoPersona;

    public Persona(String nombre, int edad, float peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.pesoPersona = peso;
    }

    public int getEdad() { return edad; }
    public float getPesoPersona() { return pesoPersona; }
    public String getNombre() { return nombre; }

    public float calcularTarifa() {
        if (edad < 25 || edad > 60) {
            return 1.5f;
        } else {
            return 3.0f;
        }
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + " años, " + pesoPersona + "kg)";
    }
}

