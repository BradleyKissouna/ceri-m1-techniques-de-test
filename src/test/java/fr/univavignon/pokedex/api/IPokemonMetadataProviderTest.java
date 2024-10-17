package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class IPokemonMetadataProviderTest {
    private IPokemonMetadataProvider metadataProvider;

    @Before
    public void setUp() {
        metadataProvider = mock(IPokemonMetadataProvider.class);
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata PikachuMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        when(metadataProvider.getPokemonMetadata(1)).thenReturn(PikachuMetadata);
        
        PokemonMetadata actualMetadata = metadataProvider.getPokemonMetadata(1);
        assertEquals(PikachuMetadata, actualMetadata);
    }

    @Test
    public void testGetPokemonMetadataInvalidIndex() throws PokedexException {
        when(metadataProvider.getPokemonMetadata(99)).thenThrow(new PokedexException("Invalid index"));

        assertThrows(PokedexException.class, () -> {
            metadataProvider.getPokemonMetadata(99);
        });
    }
}
