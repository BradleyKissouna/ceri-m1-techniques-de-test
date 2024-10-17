package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
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
        when(pokedex.addPokemon(pokemon1)).thenReturn(1);
        when(pokedex.getPokemons()).thenReturn(Arrays.asList(pokemon1));
        assertTrue(pokedex.getPokemons().contains(pokemon1));
    }

    @Test
    public void testAddPokemon2() {
        when(pokedex.addPokemon(pokemon2)).thenReturn(2);
        when(pokedex.getPokemons()).thenReturn(Arrays.asList(pokemon2));
        assertTrue(pokedex.getPokemons().contains(pokemon2));
    }

    @Test
    public void testAddPokemon3() {
        when(pokedex.addPokemon(pokemon3)).thenReturn(3);
        when(pokedex.getPokemons()).thenReturn(Arrays.asList(pokemon3));
        assertTrue(pokedex.getPokemons().contains(pokemon3));
    }

    @Test
    public void testAddPokemon4() {
        when(pokedex.addPokemon(pokemon4)).thenReturn(4);
        when(pokedex.getPokemons()).thenReturn(Arrays.asList(pokemon4));
        assertTrue(pokedex.getPokemons().contains(pokemon4));
    }

    @Test
    public void testGetAllPokemons() {
        when(pokedex.getPokemons()).thenReturn(Arrays.asList(pokemon1, pokemon2, pokemon3, pokemon4));
        assertTrue(pokedex.getPokemons().contains(pokemon1));
        assertTrue(pokedex.getPokemons().contains(pokemon2));
        assertTrue(pokedex.getPokemons().contains(pokemon3));
        assertTrue(pokedex.getPokemons().contains(pokemon4));
    }
}
