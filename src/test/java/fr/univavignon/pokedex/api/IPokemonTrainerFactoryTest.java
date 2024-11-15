package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class IPokemonTrainerFactoryTest {
    private IPokemonTrainerFactory trainerFactory;
    private IPokedexFactory pokedexFactory;

    @Before
    public void setUp() {
        trainerFactory = mock(IPokemonTrainerFactory.class);
        pokedexFactory = mock(IPokedexFactory.class);
    }

    @Test
    public void testCreatePokemonTrainer() {
        PokemonTrainer trainer = trainerFactory.createTrainer("Zen", Team.INSTINCT, pokedexFactory);
        assertNotNull(trainer);
    }

    @Test
    public void testGetPokemonTrainerInfo() {
        PokemonTrainer expectedTrainer = trainerFactory.createTrainer("Zen", Team.INSTINCT, pokedexFactory);
        when(trainerFactory.createTrainer("Zen", Team.INSTINCT, pokedexFactory)).thenReturn(expectedTrainer);
        assertEquals(expectedTrainer.getName(), "Zen");
        assertEquals(expectedTrainer.getTeam(), Team.INSTINCT);
        assertEquals(expectedTrainer.getPokedex(), pokedexFactory);
    }

}
