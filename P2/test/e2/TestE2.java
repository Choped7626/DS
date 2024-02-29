package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class TestE2 {

    @Test
    void testPersonajes() {
        Personaje guerrero1 = new Warrior("guerrero1", 17, 8, 8);
        Sword sword1 = new Sword("Sword1", 7, 2, 3);
        Sword sword2 = new Sword("Sword2", 4, 4);

        Armor armor2 = new Armor("Armor1", 15, 9);

        FireBallSpell fireBallSpell1 = new FireBallSpell("FireBallSpell1", 7, 2, 3);

        Sword sword4 = new Sword("Sword4", 7, 2, 3);
        Sword sword5 = new Sword("Sword5", 7, 2, 3);
        Sword sword6 = new Sword("Sword6", 7, 2, 3);
        Sword sword7 = new Sword("Sword7", 7, 2, 3);


        //Objetos ataque
        guerrero1.anadirObjetosAtaque(sword1);
        guerrero1.anadirObjetosAtaque(fireBallSpell1);
        guerrero1.anadirObjetosAtaque(sword4);
        guerrero1.anadirObjetosAtaque(sword5);
        guerrero1.anadirObjetosAtaque(sword6);
        //Comprobamos que no se puedan añadir mas de 5 objetos a la lista
        assertThrows(IllegalArgumentException.class, () -> guerrero1.anadirObjetosAtaque(sword7));

        //Objetos defensa
        guerrero1.anadirObjetosDefensa(sword2);
        guerrero1.anadirObjetosDefensa(armor2);

        assertEquals("guerrero1", guerrero1.getName());
        assertEquals(17, guerrero1.getSalud());
        assertEquals(8, guerrero1.getFuerza());
        assertEquals(8, guerrero1.getMana());
        assertEquals(4, guerrero1.ProteccionTotal());
        assertTrue(guerrero1.getObjetosAtaques().contains(sword1));
        assertTrue(guerrero1.getObjetosAtaques().contains(fireBallSpell1));
        //Comprobamos que no se pueden añadir objetos de ataque en la lista de defensa si estos pueden ser objetos de ataque y defensa
        Wand wand1 = new Wand("Wand1", 3, 4, 2);
        assertThrows(IllegalArgumentException.class, () -> guerrero1.anadirObjetosDefensa(wand1));
        assertThrows(IllegalArgumentException.class, () -> guerrero1.anadirObjetosDefensa(sword1));

        //Y lo mismo para el caso contrario
        assertThrows(IllegalArgumentException.class, () -> guerrero1.anadirObjetosAtaque(sword2));

        Armor armor1 = new Armor("Armor1", 4, 2);
        guerrero1.anadirObjetosDefensa(armor1);
        assertTrue(guerrero1.getObjetosDefensas().contains(armor1));

        ///

        Personaje wizard1 = new Wizard("wizard1", 12, 5, 7);
        assertEquals("wizard1", wizard1.getName());
        assertEquals(12, wizard1.getSalud());
        assertEquals(5, wizard1.getFuerza());
        assertEquals(7, wizard1.getMana());

        Sword sword3 = new Sword("sword2", 3, 2);
        assertThrows(IllegalArgumentException.class, () -> wizard1.anadirObjetosAtaque(sword3));
        wizard1.anadirObjetosDefensa(sword3);
        assertTrue(wizard1.getObjetosDefensas().contains(sword3));
        assertFalse(wizard1.getObjetosAtaques().contains(sword1));
        assertFalse(wizard1.getObjetosDefensas().contains(sword2));
        assertFalse(wizard1.getObjetosAtaques().contains(fireBallSpell1));




        assertThrows(IllegalArgumentException.class, ()-> new Warrior("war",21,2,2));
        assertThrows(IllegalArgumentException.class, ()-> new Warrior("war",19,11,2));
        assertThrows(IllegalArgumentException.class, ()-> new Warrior("war",10,5,20));

        Warrior warrior = new Warrior("warrior", 12, 5,5);
        FireBallSpell fir1 = new FireBallSpell("fir1",2,2,2);
        warrior.anadirObjetosAtaque(fir1);
        assertThrows(IllegalArgumentException.class, ()->warrior.quitarSalud(-9));
        assertThrows(IllegalArgumentException.class, ()->warrior.anadirObjetosAtaque(new Sword("swordDefensa",4,5)));
        assertThrows(IllegalArgumentException.class, ()->warrior.anadirObjetosDefensa(new Wand("swordDefensa",4,5,2)));

        Sword s1 = new Sword("sword5",4,5);
        Sword s2 = new Sword("sword5",4,5);
        Sword s3 = new Sword("sword5",4,5);
        Sword s4 = new Sword("sword5",4,5);
        Sword s5 = new Sword("sword5",4,5);
        warrior.anadirObjetosDefensa(s1);
        warrior.anadirObjetosDefensa(s2);
        warrior.anadirObjetosDefensa(s3);
        warrior.anadirObjetosDefensa(s4);
        warrior.anadirObjetosDefensa(s5);
        assertThrows(IllegalArgumentException.class, ()->warrior.anadirObjetosDefensa(new Wand("swordDefensa",4,5)));







    }

    @Test
    void testObjetos() {

        //Sword usado como objeto de ataque
        Sword sword1 = new Sword("Sword1", 7, 2, 3);
        assertEquals("Sword1", sword1.getCodename());
        assertEquals(7, sword1.getDano());
        assertEquals(2, sword1.getMinMana());
        assertEquals(3, sword1.getUsosRestantes());

        //Sword usado como objeto de defensa
        Sword sword2 = new Sword("Sword2", 4, 2);
        assertEquals("Sword2", sword2.getCodename());
        assertEquals(4, sword2.getProteccion());
        assertEquals(2, sword2.getFuerzaMinima());

        //FireBallSpell es un objeto de ataque
        FireBallSpell fireBallSpell1 = new FireBallSpell("FireBallSpell1", 7, 2, 3);
        assertEquals("FireBallSpell1", fireBallSpell1.getCodename());
        assertEquals(7, fireBallSpell1.getDano());
        assertEquals(2, fireBallSpell1.getMinMana());
        assertEquals(3, fireBallSpell1.getUsosRestantes());

        //Armor es un objeto de proteccion
        Armor armor1 = new Armor("Armor1", 6, 4);
        assertEquals("Armor1", armor1.getCodename());
        assertEquals(6, armor1.getProteccion());
        assertEquals(4, armor1.getFuerzaMinima());

        //Wand usado como objeto de ataque
        Wand wand1 = new Wand("Wand1", 5, 4, 3);
        assertEquals("Wand1", wand1.getCodename());
        assertEquals(10, wand1.getDano());  //Cuando se usa Wand por primera vez, tiene que devolver el doble de su poder de ataque
        assertEquals(4, wand1.getMinMana());
        assertEquals(3, wand1.getUsosRestantes());

        //Wand usado como objeto de defensa
        Wand wand2 = new Wand("Wand2", 5, 2);
        assertEquals("Wand2", wand2.getCodename());
        assertEquals(5, wand2.getProteccion());
        assertEquals(2, wand2.getFuerzaMinima());
    }

    @Test
    void simularAtaqueTest() {

        //Partida
        Juego partida = new Juego();

        //Guerreros
        Warrior warrior1 = new Warrior("warrior1", 18,10,9);
        Warrior warrior2 = new Warrior("warrior2", 10,7,2);

        //Magos
        Wizard mago1 = new Wizard("mago1", 10,8,8);
        Wizard mago2 = new Wizard("mago2", 7,5,3);


        //Objetos de ataque
        FireBallSpell fireBall1 = new FireBallSpell("fireball1",5,2,3);
        Sword sword1 = new Sword("sword1", 5,3,4);
        Wand wand2 = new Wand("wand2",5,4,0);
        FireBallSpell fireBall2 = new FireBallSpell("fireball2",6,6,2);

        //Objetos de defensa
        Wand wand1 = new Wand("wand1",6,2);

        warrior1.anadirObjetosAtaque(fireBall1);
        mago1.anadirObjetosAtaque(sword1);
        assertEquals(5,partida.simularAtaque(warrior1,mago1));

        mago1.anadirObjetosDefensa(wand1);
        assertEquals(0, partida.simularAtaque(warrior1, mago1));

        warrior2.anadirObjetosAtaque(wand2);
        assertEquals(0, partida.simularAtaque(warrior2, mago1));

        assertThrows(IllegalArgumentException.class, ()->partida.simularAtaque(mago2,mago1));

        mago2.anadirObjetosAtaque(fireBall2);
        assertThrows(IllegalArgumentException.class, ()->partida.simularAtaque(mago2,mago1));

    }

    @Test
    void simularCombateTest() {

        //Juego
        Juego partida = new Juego();

        //Guerreros
        Warrior warrior1 = new Warrior("warrior1",15,5,6);
        Warrior warrior2 = new Warrior("warrior2", 11, 9, 8);
        Warrior warrior3 = new Warrior("warrior3", 20,10,10);

        //Magos
        Wizard mago1 = new Wizard("mago1", 12, 6,8);
        Wizard mago2 = new Wizard("mago2", 15, 4, 9);
        Wizard mago3 = new Wizard("mago3", 20,10,10);


        //Objetos de ataque
        FireBallSpell fireBall1 = new FireBallSpell("fireBall1", 5, 3,3);
        Sword sword1 = new Sword("sword 1", 6, 4,1);
        Wand wand1 = new Wand("wand1", 4, 4,2);
        FireBallSpell fireBall2 = new FireBallSpell("fireBall2",3,2,2);
        Wand wand3 = new Wand("wand2", 2, 4,3);
        Sword sword3 = new Sword("sword 3", 6, 4,1);

        FireBallSpell fireBall3 = new FireBallSpell("fireBall3", 3, 3, 2);
        Sword sword4 = new Sword("sword4", 3,3,2);


        //Objetos de defensa
        Armor armor1 = new Armor("armor1", 5,4);
        Sword sword2 = new Sword("sword2",5,5);

        warrior1.anadirObjetosAtaque(wand1);

        mago1.anadirObjetosAtaque(sword1);
        mago1.anadirObjetosAtaque(fireBall1);

        assertEquals(warrior1, partida.simularCombate(warrior1,mago1,2));

        mago2.anadirObjetosAtaque(fireBall2);
        mago2.anadirObjetosAtaque(sword3);
        warrior2.anadirObjetosAtaque(wand3);

        assertEquals(mago2, partida.simularCombate(warrior2,mago2,3));


        warrior3.anadirObjetosAtaque(fireBall3);
        warrior3.anadirObjetosDefensa(armor1);

        mago3.anadirObjetosAtaque(sword4);
        mago3.anadirObjetosDefensa(sword2);

        assertNull(partida.simularCombate(warrior3, mago3, 2));
    }
}
