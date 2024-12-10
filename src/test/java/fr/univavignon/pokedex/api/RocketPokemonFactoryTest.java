package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class RocketPokemonFactoryTest {
    private RocketPokemonFactory rocketPokemonFactory;

    @Before
    public void setUp() {
        rocketPokemonFactory = new RocketPokemonFactory();
    }

    @Test
    public void testCreatePokemon() {
        // Test pour créer un Pokémon avec un index valide (0 -> "MISSINGNO")
        Pokemon missingno = rocketPokemonFactory.createPokemon(0, 0, 0, 0, 0);
        assertNotNull(missingno);
        assertEquals("MISSINGNO", missingno.getName());
        assertEquals(0, missingno.getCp());
        assertEquals(0, missingno.getHp());
        assertEquals(0, missingno.getDust());
        assertEquals(0, missingno.getCandy());
        assertEquals(0, missingno.getIv(), 1.0);

        // Test pour créer un Pokémon avec un index négatif (-1 -> "Ash's Pikachu")
        Pokemon ashPikachu = rocketPokemonFactory.createPokemon(-1, 100, 50, 1000, 10);
        assertNotNull(ashPikachu);
        assertEquals("Ash's Pikachu", ashPikachu.getName());
        assertEquals(1000, ashPikachu.getAttack());
        assertEquals(1000, ashPikachu.getDefense());
        assertEquals(1000, ashPikachu.getStamina());
        assertEquals(0, ashPikachu.getIv(), 0.1);


    }

    @Test
    public void testNegativeIndex() {
        Pokemon ashPikachu = rocketPokemonFactory.createPokemon(-1, 100, 50, 1000, 10);
        assertEquals("Ash's Pikachu", ashPikachu.getName());
        assertEquals(1000, ashPikachu.getAttack());
        assertEquals(1000, ashPikachu.getDefense());
        assertEquals(1000, ashPikachu.getStamina());
        assertEquals(0, ashPikachu.getIv(), 0.1);
    }

    @Test
    public void testInvalidIndex() {
        Pokemon missingno = rocketPokemonFactory.createPokemon(999, 10, 20, 30, 40);
        assertEquals("MISSINGNO", missingno.getName());
    }

    @Test
    public void testPerformanceGenerateRandomStat() {
        long startTime = System.nanoTime();
        int stat = RocketPokemonFactory.generateRandomStat();
        long endTime = System.nanoTime();

        long executionTime = endTime - startTime;
        assertFalse(executionTime < 1_000_000);
    }

    @Test
    public void testCalculateIV() {
        RocketPokemonFactory factory = new RocketPokemonFactory();
        
        // On répète le test plusieurs fois pour s'assurer que l'IV est toujours entre 0 et 15
        for (int i = 0; i < 1000; i++) {
            int iv = factory.calculateIV();
            assertTrue(iv >= 0 && iv <= 15);
        }
    }

}
