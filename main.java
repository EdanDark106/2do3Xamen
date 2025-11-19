package examen01;

public class main {
    public static void main(String[] args) {
    MiTeleferico mt = new MiTeleferico();

    mt.agregarCabina("roja", 101);
    mt.agregarCabina("roja", 102);
    mt.agregarCabina("verde", 201);
    mt.agregarCabina("amarilla", 301);

    mt.agregarPersonasFila(new Persona("Juan", 30, 80), "roja");
    mt.agregarPersonasFila(new Persona("Ana", 20, 55), "roja");
    mt.agregarPersonasFila(new Persona("Pedro", 65, 90), "verde");
    mt.agregarPersonasFila(new Persona("Luis", 35, 100), "verde");
    mt.agregarPersonasFila(new Persona("Maria", 18, 50), "amarilla");

    mt.procesarTodasLasLineas();

    mt.calcularIngresoTotalTodasLasLineas();
    mt.mostrarEstado();
}
}

