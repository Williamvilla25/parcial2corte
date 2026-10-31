package com.example;


public abstract class Criatura {
    protected String nombre;
    protected int salud;
    protected int fuerza;

    // Constructor para inicializar los atributos básicos
    public Criatura(String nombre, int salud, int fuerza) {
        this.nombre = nombre;
        this.salud = salud;
        this.fuerza = fuerza;
    }

    // Métodos abstractos (cada subclase debe definir su propia lógica)
    public abstract void atacar(Criatura objetivo);
    public abstract void defender(int daño);

    // Método concreto: indica si la criatura sigue con vida
    public boolean estaViva() {
        return this.salud > 0;
    }

    // Getters y Setters básicos para acceder a los atributos de forma segura
    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getFuerza() {
        return fuerza;
    }
}