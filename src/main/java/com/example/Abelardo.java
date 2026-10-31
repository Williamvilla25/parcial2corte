package com.example;

public class Abelardo extends Criatura {
    private final String habilidadOculta;

    
    public Abelardo(String nombre, int salud, int fuerza) {
        super(nombre, salud, fuerza);
        this.habilidadOculta = "Bienvenido a la patria milagro";
    }

    @Override
    public void atacar(Criatura objetivo) {
        System.out.println(this.nombre + " (Abelardo) utiliza su técnica secreta: " + this.habilidadOculta + ".");
        
        objetivo.defender(this.fuerza + 4);
    }

    @Override
    public void defender(int danio) {
        int danioReducido = danio / 2;
        this.salud -= danioReducido;
        
        if (this.salud < 0) {
            this.salud = 0;
        }
        System.out.println(this.nombre + " (Abelardo) hace un movimiento ágil esquivando parte del golpe y recibe " + danioReducido + " de daño.");
    }

    public String getHabilidadOculta() {
        return habilidadOculta;
    }
}