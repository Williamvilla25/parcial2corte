package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class CriaturaTest {

    @Test
    public void testDragonHaceDobleDeDanio() {
        // Arrange
        Dragon dragon = new Dragon("Chimuelo", 100, 20, "Escamas de Hierro");
        Mago mago = new Mago("Gandalf", 100, 15, "Luz");

        // Act: El dragón ataca (fuerza 20 * 2 = 40 de daño base)
        dragon.atacar(mago);

        // Assert: El mago mitiga 5 de daño (40 - 5 = 35 de daño real). 100 - 35 = 65
        assertEquals(65, mago.getSalud(), "La salud del mago debería ser 65 tras el ataque del dragón.");
    }

    @Test
    public void testMagoAtacaYGuerreroSeDefiende() {
        // Arrange
        Mago mago = new Mago("Harry", 100, 25, "Fuego");
        Guerrero guerrero = new Guerrero("Aragorn", 100, 20, "Espada");

        // Act: El mago ataca al guerrero (fuerza base 25)
        mago.atacar(guerrero);

        // Assert: El guerrero mitiga 8 de daño (25 - 8 = 17 de daño real). 100 - 17 = 83
        assertEquals(83, guerrero.getSalud(), "La salud del guerrero debería ser 83 tras el ataque del mago.");
    }

    @Test
    public void testGuerreroAtacaYDragonSeDefiende() {
        // Arrange
        Guerrero guerrero = new Guerrero("Hercules", 100, 30, "Espada");
        Dragon dragon = new Dragon("Smaug", 100, 20, "Escamas");

        // Act: El guerrero ataca al dragón (fuerza base 30)
        guerrero.atacar(dragon);

        // Assert: El dragón mitiga 10 de daño con sus escamas (30 - 10 = 20 de daño real). 100 - 20 = 80
        assertEquals(80, dragon.getSalud(), "La salud del dragón debería ser 80 tras el ataque del guerrero.");
    }

    @Test
    public void testAbelardoAtacaYSeDefiende() {
        // Arrange
        Abelardo abelardo = new Abelardo("Abelardo", 100, 20);
        Mago mago = new Mago("Gandalf", 100, 20, "Luz");

        // Act: Abelardo ataca (fuerza 20 + 4 de su habilidad oculta = 24 de daño)
        abelardo.atacar(mago);

        // Assert: El mago mitiga 5 de daño (24 - 5 = 19 de daño real). 100 - 19 = 81
        assertEquals(81, mago.getSalud(), "La salud del mago debería ser 81 tras el ataque de Abelardo.");

        // Prueba de defensa: Abelardo recibe un ataque de 40 de daño (se reduce a la mitad: 20)
        abelardo.defender(40);
        assertEquals(80, abelardo.getSalud(), "La salud de Abelardo debería ser 80 tras mitigar el daño a la mitad.");
    }

    @Test
    public void testCriaturaMuereCuandoSaludLlegaACero() {
        // Arrange
        Guerrero guerrero = new Guerrero("Hercules", 10, 20, "Espada");

        // Act: Recibe daño masivo que la deja sin vida
        guerrero.defender(50);

        // Assert
        assertFalse(guerrero.estaViva(), "La criatura no debería estar viva si su salud es 0.");
        assertEquals(0, guerrero.getSalud(), "La salud no debe ser negativa, debe quedarse en 0.");
    }
}