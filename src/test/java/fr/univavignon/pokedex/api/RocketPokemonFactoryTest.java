package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class RocketPokemonFactoryTest {
    private PokemonFactory pokemonFactory;
    
    @Before
    public void setUp() {
        pokemonFactory = new PokemonFactory(new PokemonMetadataProvider());
    }

    @Test
    public void testCreatePokemon() {
        Pokemon missingno = pokemonFactory.createPokemon(0, 0, 0, 0, 0);
        assertEquals("MISSINGNO", missingno.getName());
        assertEquals(0, missingno.getCp());
        assertEquals(0, missingno.getHp());
        assertEquals(0, missingno.getDust());
        assertEquals(0, missingno.getCandy());
        assertEquals(0, missingno.getIv(), 0.1);
    }

    @Test
    public void testPokemonComparators() {
        Pokemon bulbasaur = pokemonFactory.createPokemon(1, 55, 40, 35, 500);
        Pokemon ivysaur = pokemonFactory.createPokemon(2, 60, 50, 45, 400);
        Pokemon venusaur = pokemonFactory.createPokemon(3, 52, 43, 39, 600);

        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(bulbasaur);
        pokemons.add(ivysaur);
        pokemons.add(venusaur);

        // Test du comparateur par nom
        Collections.sort(pokemons, PokemonComparators.NAME);
        assertTrue(pokemons.get(0).getName().equals("Bulbasaur"));
        assertTrue(pokemons.get(1).getName().equals("Ivysaur"));
        assertTrue(pokemons.get(2).getName().equals("Venusaur"));

        // Test du comparateur par index
        Collections.sort(pokemons, PokemonComparators.INDEX);
        assertTrue(pokemons.get(0).getIndex() == 1);
        assertTrue(pokemons.get(1).getIndex() == 2);
        assertTrue(pokemons.get(2).getIndex() == 3);

        // Test du comparateur par CP
        Collections.sort(pokemons, PokemonComparators.CP);
        assertTrue(pokemons.get(0).getCp() == 52);
        assertTrue(pokemons.get(1).getCp() == 55);
        assertTrue(pokemons.get(2).getCp() == 60);
    }

    @Test
    public void testNegativeIndex() {
        RocketPokemonFactory factory = new RocketPokemonFactory();
        Pokemon ashPikachu = factory.createPokemon(-1, 100, 50, 1000, 10);
        assertEquals("Ash's Pikachu", ashPikachu.getName());
        assertEquals(1000, ashPikachu.getAttack());
        assertEquals(1000, ashPikachu.getDefense());
        assertEquals(1000, ashPikachu.getStamina());
        assertEquals(0, ashPikachu.getIv(), 0.1);
    }

    @Test
    public void testInvalidIndex() {
        RocketPokemonFactory factory = new RocketPokemonFactory();
        Pokemon missingno = factory.createPokemon(999, 10, 20, 30, 40);
        assertEquals("MISSINGNO", missingno.getName());
    }

    @Test
    public void testPerformanceGenerateRandomStat() {
        long startTime = System.nanoTime();
        int stat = RocketPokemonFactory.generateRandomStat();
        long endTime = System.nanoTime();

        long executionTime = endTime - startTime;
        assertTrue(executionTime < 1_000_000);
    }

}
