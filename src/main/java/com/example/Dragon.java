package com.example;

public class Dragon extends Criatura {
    private String escamas; // Atributo único del Dragón según el diagrama de clases

    // Constructor
    public Dragon(String nombre, int salud, int fuerza, String escamas) {
        super(nombre, salud, fuerza);
        this.escamas = escamas;
    }

    @Override
    public void atacar(Criatura objetivo) {
        // El dragón tiene un ataque más fuerte (fuerza * 2)[cite: 4]
        int dañoReal = this.fuerza * 2;
        System.out.println("🐉 " + this.nombre + " (Dragón) lanza una devastadora llamarada sobre " + objetivo.getNombre() + " infligiendo " + dañoReal + " de daño.");
        objetivo.defender(dañoReal);
    }

    @Override
    public void defender(int daño) {
        // El dragón usa sus escamas resistentes para absorber parte del daño
        int dañoReducido = Math.max(0, daño - 10);
        this.salud -= dañoReducido;
        if (this.salud < 0) {
            this.salud = 0;
        }
        System.out.println("🛡️ " + this.nombre + " (Dragón) resiste el impacto con sus escamas (" + this.escamas + "). Recibe " + dañoReducido + " de daño. Salud actual: " + this.salud);
    }

    // Getters y Setters
    public String getEscamas() {
        return escamas;
    }

    public void setEscamas(String escamas) {
        this.escamas = escamas;
    }
}