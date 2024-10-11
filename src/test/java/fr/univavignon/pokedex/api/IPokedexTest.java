package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class IPokedexTest {
    private IPokedex pokedex;
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Pokemon pokemon3;
    private Pokemon pokemon4;

    @Before
    public void setUp() {
        pokedex = mock(IPokedex.class);

        pokemon1 = new Pokemon(1, "Pikachu", 55, 40, 35, 500, 60, 300, 25, 0.9);
        pokemon2 = new Pokemon(2, "Bulbizarre", 60, 50, 45, 400, 50, 200, 20, 0.8);
        pokemon3 = new Pokemon(3, "Salamèche", 52, 43, 39, 600, 55, 250, 15, 0.85);
        pokemon4 = new Pokemon(4, "Carapuce", 50, 60, 50, 550, 60, 300, 30, 0.9);
    }

    @Test
    public void testAddPokemon1() {
        int index = pokedex.addPokemon(pokemon1);
        assertTrue(pokedex.getPokemons().contains(pokemon1));
        assertEquals(1, index);
    }

    @Test
    public void testAddPokemon2() {
        int index = pokedex.addPokemon(pokemon2);
        assertTrue(pokedex.getPokemons().contains(pokemon2));
        assertEquals(2, index);
    }

    @Test
    public void testAddPokemon3() {
        int index = pokedex.addPokemon(pokemon3);
        assertTrue(pokedex.getPokemons().contains(pokemon3));
        assertEquals(3, index);
    }

    @Test
    public void testAddPokemon4() {
        int index = pokedex.addPokemon(pokemon4);
        assertTrue(pokedex.getPokemons().contains(pokemon4));
        assertEquals(4, index);
    }

    @Test
    public void testGetPokemon1() throws PokedexException {
        Pokemon retrievedPokemon = pokedex.getPokemon(1);
        assertEquals(pokemon1, retrievedPokemon);
    }

    @Test
    public void testGetPokemon2() throws PokedexException {
        Pokemon retrievedPokemon = pokedex.getPokemon(2);
        assertEquals(pokemon2, retrievedPokemon);
    }

    @Test
    public void testGetPokemon3() throws PokedexException {
        Pokemon retrievedPokemon = pokedex.getPokemon(3);
        assertEquals(pokemon3, retrievedPokemon);
    }

    @Test
    public void testGetPokemon4() throws PokedexException {
        Pokemon retrievedPokemon = pokedex.getPokemon(4);
        assertEquals(pokemon4, retrievedPokemon);
    }

    @Test
    public void testGetAllPokemons() {
        List<Pokemon> allPokemons = pokedex.getPokemons();
        assertEquals(4, allPokemons.size());
        assertTrue(allPokemons.contains(pokemon1));
        assertTrue(allPokemons.contains(pokemon2));
        assertTrue(allPokemons.contains(pokemon3));
        assertTrue(allPokemons.contains(pokemon4));
    }
}
