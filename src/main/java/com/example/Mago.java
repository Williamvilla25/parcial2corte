package com.example;

/**
 * Subclase concreta Mago que extiende de Criatura.
 */
public class Mago extends Criatura {
    private String hechizos; // Atributo único del Mago según el diagrama de clases

    // Constructor
    public Mago(String nombre, int salud, int fuerza, String hechizos) {
        super(nombre, salud, fuerza);
        this.hechizos = hechizos;
    }

    @Override
    public void atacar(Criatura objetivo) {
        // El mago ataca con hechizos usando su fuerza base[cite: 4]
        int dañoReal = this.fuerza;
        System.out.println("🧙‍♂️ " + this.nombre + " (Mago) conjura un hechizo (" + this.hechizos + ") y ataca a " + objetivo.getNombre() + " con " + dañoReal + " de daño.");
        objetivo.defender(dañoReal);
    }

    @Override
    public void defender(int daño) {
        // El mago se defiende creando un escudo mágico que absorbe parte del daño
        int dañoReducido = Math.max(0, daño - 5);
        this.salud -= dañoReducido;
        if (this.salud < 0) {
            this.salud = 0;
        }
        System.out.println("🛡️ " + this.nombre + " (Mago) usa un escudo mágico para mitigar el ataque. Recibe " + dañoReducido + " de daño. Salud actual: " + this.salud);
    }

    // Getters y Setters
    public String getHechizos() {
        return hechizos;
    }

    public void setHechizos(String hechizos) {
        this.hechizos = hechizos;
    }
}