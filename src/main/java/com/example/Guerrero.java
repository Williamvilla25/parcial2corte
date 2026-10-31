package com.example;

public class Guerrero extends Criatura {
    private String arma;

    public Guerrero(String nombre, int salud, int fuerza, String arma) {
        super(nombre, salud, fuerza);
        this.arma = arma;
    }

    @Override
    public void atacar(Criatura objetivo) {
        System.out.println(this.nombre + " (Guerrero) embiste con su " + this.arma + ".");
        objetivo.defender(this.fuerza);
    }

    @Override
    public void defender(int danio) {
        int danioReducido = Math.max(0, danio - 3);
        this.salud -= danioReducido;
        
        if (this.salud < 0) {
            this.salud = 0;
        }
        System.out.println(this.nombre + " (Guerrero) bloquea parcialmente el ataque y recibe " + danioReducido + " de daño.");
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }
}