package com.example;

public class Main {

    // Método de simulación de batalla requerido por el parcial
    public static void simularBatalla(Criatura criatura1, Criatura criatura2) {
        System.out.println("\n========================================");
        System.out.println("⚔️ ¡INICIA LA BATALLA: " + criatura1.getNombre() + " VS " + criatura2.getNombre() + "! ⚔️");
        System.out.println("========================================");

        int turno = 1;
        
        // La batalla continúa hasta que una de las criaturas quede sin salud
        while (criatura1.estaViva() && criatura2.estaViva()) {
            System.out.println("\n--- Turno " + turno + " ---");
            
            // Ataca la criatura 1
            criatura1.atacar(criatura2);
            if (!criatura2.estaViva()) {
                break;
            }

            // Ataca la criatura 2
            criatura2.atacar(criatura1);
            if (!criatura1.estaViva()) {
                break;
            }

            turno++;
        }

        System.out.println("\n========================================");
        System.out.println("🏆 ¡FIN DE LA BATALLA! 🏆");
        if (criatura1.estaViva()) {
            System.out.println("🎉 ¡El ganador es " + criatura1.getNombre() + " con " + criatura1.getSalud() + " de salud restante!");
        } else {
            System.out.println("🎉 ¡El ganador es " + criatura2.getNombre() + " con " + criatura2.getSalud() + " de salud restante!");
        }
        System.out.println("========================================\n");
    }

    public static void main(String[] args) {
        // Creación de instancias de diferentes criaturas (incluyendo a Abelardo)
        Criatura dragon = new Dragon("Chimuelo", 100, 25, "Escamas de Hierro");
        Criatura mago = new Mago("Gandalf", 80, 20, "Fuego Fatuo");
        Criatura guerrero = new Guerrero("Aragorn", 90, 22, "Andúril");
        Criatura abelardo = new Abelardo("Abelardo", 95, 20);

        // Simulación de batallas entre ellas utilizando polimorfismo[cite: 8]
        simularBatalla(dragon, mago);
        simularBatalla(guerrero, abelardo);
    }
}