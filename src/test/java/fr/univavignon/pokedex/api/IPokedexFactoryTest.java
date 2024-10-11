package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class IPokedexFactoryTest {
    private IPokedexFactory pokedexFactory;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        pokedexFactory = mock(IPokedexFactory.class);
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
    }

    @Test
    public void testCreatePokedex() {
        IPokedex expectedPokedex = mock(IPokedex.class);
        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(expectedPokedex);
        
        IPokedex actualPokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        assertEquals(expectedPokedex, actualPokedex);
    }

    @Test
    public void testCreateMultiplePokedexes() {
        IPokedex pokedex1 = mock(IPokedex.class);
        IPokedex pokedex2 = mock(IPokedex.class);
        
        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex1).thenReturn(pokedex2);

        assertEquals(pokedex1, pokedexFactory.createPokedex(metadataProvider, pokemonFactory));
        assertEquals(pokedex2, pokedexFactory.createPokedex(metadataProvider, pokemonFactory));
    }

    @Test
    public void testCreatePokedexReturnsNotNull() {
        IPokedex actualPokedex = mock(IPokedex.class);
        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(actualPokedex);

        IPokedex returnedPokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        assertNotNull(returnedPokedex);
    }
}
