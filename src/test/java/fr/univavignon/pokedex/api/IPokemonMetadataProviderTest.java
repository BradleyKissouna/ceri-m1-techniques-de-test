package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class IPokemonMetadataProviderTest {
    private PokemonMetadataProvider metadataProvider;

    @Before
    public void setUp() {
        metadataProvider = new PokemonMetadataProvider();
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata bulbasaur = metadataProvider.getPokemonMetadata(1);
        assertEquals(1, bulbasaur.getIndex());
        assertEquals("Bulbasaur", bulbasaur.getName());
        assertEquals(49, bulbasaur.getAttack());
        assertEquals(49, bulbasaur.getDefense());
        assertEquals(45, bulbasaur.getStamina());
    }

    public void testGetPokemonMetadataInvalidIndex() throws PokedexException {
        assertThrows(PokedexException.class, () -> {
            metadataProvider.getPokemonMetadata(0);
        });
        assertThrows(PokedexException.class, () -> {
            metadataProvider.getPokemonMetadata(999);
        });
    }

}
