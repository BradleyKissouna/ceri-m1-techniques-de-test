package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class IPokemonMetadataProviderTest {
    private IPokemonMetadataProvider metadataProvider;

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
        when(metadataProvider.getPokemonMetadata(0)).thenThrow(new PokedexException("Index out of range"));
    
        assertThrows(PokedexException.class, () -> {
            metadataProvider.getPokemonMetadata(0);
        });

        when(metadataProvider.getPokemonMetadata(999)).thenThrow(new PokedexException("Index out of range"));
    
        assertThrows(PokedexException.class, () -> {
            metadataProvider.getPokemonMetadata(999);
        });
    }
}
