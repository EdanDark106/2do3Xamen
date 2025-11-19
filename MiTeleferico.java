package examen01;

import java.util.ArrayList;
import java.util.List;


public class MiTeleferico {
    private ArrayList<Linea> lineas;   
    private float cantidadIngresos;

    private final String[] COLORES_VALIDOS = {"AMARILLA", "ROJA", "VERDE"};

    public MiTeleferico() {
        this.lineas = new ArrayList<>();
        this.cantidadIngresos = 0;

        lineas.add(new Linea("AMARILLA"));
        lineas.add(new Linea("ROJA"));
        lineas.add(new Linea("VERDE"));
    }

    public void agregarPersonasFila(Persona p, String colorLinea) {
        String color = colorLinea.toUpperCase();
        for (Linea l : lineas) {
            if (l.getColor().equals(color)) {
                l.agregarPersona(p);
                return;
            }
        }
        System.out.println("Línea " + colorLinea + " no existe.");
    }

    public void agregarCabina(String colorLinea, int nroCab) {
        String color = colorLinea.toUpperCase();
        for (Linea l : lineas) {
            if (l.getColor().equals(color)) {
                l.agregarCabina(nroCab);
                return;
            }
        }
    }

    public void procesarTodasLasLineas() {
        for (Linea l : lineas) {
            l.subirPersonasACabinas();
        }
    }

    public float calcularIngresoTotalTodasLasLineas() {
        float total = 0;
        for (Linea l : lineas) {
            total += l.calcularIngresoTotal();
        }
        this.cantidadIngresos = total;
        return total;
    }

    public String lineaConMasIngresoSoloRegular() {
        Linea mejor = null;
        float maxIngresoRegular = -1;

        for (Linea l : lineas) {
            float ingresoReg = l.calcularIngresoSoloRegular();
            if (ingresoReg > maxIngresoRegular) {
                maxIngresoRegular = ingresoReg;
                mejor = l;
            }
        }
        return mejor != null ? mejor.getColor() : "Ninguna";
    }

    public void mostrarEstado() {
        System.out.println("ESTADO DE MI TELEFÉRICO");
        for (Linea l : lineas) {
            System.out.println("Línea " + l.getColor() + " - Ingreso total: " + l.calcularIngresoTotal());
            System.out.println("Ingreso solo regular: " + l.calcularIngresoSoloRegular());
        }
        System.out.println("Ingreso total del sistema: " + cantidadIngresos);
        System.out.println("Línea con más ingreso regular: " + lineaConMasIngresoSoloRegular());
    }
}