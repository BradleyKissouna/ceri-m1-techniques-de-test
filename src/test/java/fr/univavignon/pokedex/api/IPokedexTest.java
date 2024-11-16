package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class IPokedexTest {
    private Pokedex pokedex;
    private PokemonMetadataProvider metadataProvider;
    private Pokemon pikachu;

    @Before
    public void setUp() {
        metadataProvider = new PokemonMetadataProvider();
        pokedex = new Pokedex(metadataProvider, new PokemonFactory(metadataProvider));
        pikachu = new Pokemon(150, "Pikachu", 55, 40, 35, 500, 60, 300, 25, 0.9);
    }

    @Test
    public void testAddPikachu() {
        assertEquals(pokedex.addPokemon(pikachu), 0);
        assertSame(pikachu, pokedex.getPokemons().get(0));
        assertTrue(pokedex.getPokemons().contains(pikachu));
    }

    @Test
    public void testGetPokedexInfo() throws PokedexException {
        assertEquals(0, pokedex.size());
        pokedex.addPokemon(pikachu);
        assertEquals(1, pokedex.size());
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        pokedex.addPokemon(pikachu);
        assertEquals(pikachu, pokedex.getPokemon(0));

        assertThrows(PokedexException.class, () -> pokedex.getPokemon(1));
    }

    @Test
    public void testGetPokemons() {
        pokedex.addPokemon(pikachu);
        assertEquals(pikachu, pokedex.getPokemons().get(0));
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        assertTrue(pokedex.getPokemonMetadata(1).getName().equals("Bulbasaur"));
    }

    @Test
    public void testCreatePokemon() throws PokedexException {
        pokedex.createPokemon(0, 0, 0, 0, 0);
        assertEquals(0, pokedex.size());
    }

}
