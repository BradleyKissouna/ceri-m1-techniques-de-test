package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class IPokedexFactoryTest {
    private PokedexFactory pokedexFactory;
    private IPokemonMetadataProvider metadataProvider;
    private PokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        pokedexFactory = new PokedexFactory();
        metadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory(metadataProvider);
    }

    @Test
    public void testCreatePokedex() {
        IPokedex actualPokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        assertNotNull(actualPokedex);
    }

    @Test
    public void testCreateMultiplePokedexes() {
        IPokedex pokedex1 = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        IPokedex pokedex2 = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        assertNotEquals(pokedex1, pokedex2);
    }

}
