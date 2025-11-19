package examen01;

import java.util.ArrayList;
import java.util.Iterator;

class Linea {
    private String color;
    private ArrayList<Persona> filaPersonas;   
    private ArrayList<Cabina> cabinas;    
    private int cantidadCabinas;

    public Linea(String color) {
        this.color = color.toUpperCase();
        this.filaPersonas = new ArrayList<>();
        this.cabinas = new ArrayList<>();
        this.cantidadCabinas = 0;
    }

    public String getColor() { return color; }

    public void agregarPersona(Persona p) {
        filaPersonas.add(p);
    }

    public void agregarCabina(int nroCab) {
        cabinas.add(new Cabina(nroCab));
        cantidadCabinas++;
    }

    public void subirPersonasACabinas() {
        Iterator<Persona> it = filaPersonas.iterator();
        while (it.hasNext()) {
            Persona p = it.next();

            boolean subida = false;
            for (Cabina c : cabinas) {
                if (c.cantidadPersonas() == 0) {
                    if (c.agregarPrimeraPersona(p)) {
                        it.remove();
                        subida = true;
                        break;
                    }
                } else {
                    if (c.agregarPersona(p)) {
                        it.remove();
                        subida = true;
                        break;
                    }
                }
            }
            if (!subida) break;
        }
    }

    public float calcularIngresoTotal() {
        float total = 0;
        for (Cabina c : cabinas) {
            total += c.calcularIngreso();
        }
        return total;
    }

    public float calcularIngresoSoloRegular() {
        float total = 0;
        for (Cabina c : cabinas) {
            total += c.calcularIngresoSoloRegular();
        }
        return total;
    }

    public ArrayList<Cabina> getCabinas() { return cabinas; }
}
