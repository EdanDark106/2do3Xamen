package examen01;

import java.util.ArrayList;

class Cabina {
    private int nroCabina;
    private ArrayList<Persona> personasAbordo;

    private static final int MAX_PERSONAS = 10;
    private static final float PESO_MAXIMO = 850.0f;

    public Cabina(int nroCabina) {
        this.nroCabina = nroCabina;
        this.personasAbordo = new ArrayList<>();
    }

    public int getNroCabina() { return nroCabina; }

    public boolean agregarPrimeraPersona(Persona p) {
        if (personasAbordo.isEmpty()) { 
            if (personasAbordo.size() < MAX_PERSONAS && 
                (personasAbordo.stream().mapToDouble(per -> per.getPesoPersona()).sum() + p.getPesoPersona()) <= PESO_MAXIMO) {
                personasAbordo.add(p);
                return true;
            }
        }
        return false;
    }

    public boolean agregarPersona(Persona p) {
        float pesoActual = (float) personasAbordo.stream().mapToDouble(per -> per.getPesoPersona()).sum();
        if (personasAbordo.size() < MAX_PERSONAS && (pesoActual + p.getPesoPersona()) <= PESO_MAXIMO) {
            personasAbordo.add(p);
            return true;
        }
        return false;
    }

    public float calcularIngreso() {
        float ingreso = 0;
        for (Persona p : personasAbordo) {
            ingreso += p.calcularTarifa();
        }
        return ingreso;
    }

    public float calcularIngresoSoloRegular() {
        float ingreso = 0;
        for (Persona p : personasAbordo) {
            if (p.getEdad() >= 25 && p.getEdad() <= 60) {
                ingreso += 3.0f;
            }
        }
        return ingreso;
    }

    public int cantidadPersonas() {
        return personasAbordo.size();
    }

    @Override
    public String toString() {
        return "Cabina " + nroCabina + " (" + personasAbordo.size() + " personas)";
    }
}
