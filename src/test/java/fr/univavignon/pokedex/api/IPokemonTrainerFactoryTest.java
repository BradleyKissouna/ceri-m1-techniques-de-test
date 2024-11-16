package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class IPokemonTrainerFactoryTest {
    private PokemonTrainerFactory trainerFactory;
    private PokedexFactory pokedexFactory;

    /**
     * Initializes the PokemonTrainerFactory to be tested and a mock PokedexFactory
     * that will be used to create IPokedex instances.
     */
    @Before
    public void setUp() {
        trainerFactory = new PokemonTrainerFactory();
        pokedexFactory = mock(PokedexFactory.class);
    }

    /**
     * Verifies that a PokemonTrainer instance can be created with the trainer's
     * name, team and a pokedex factory.
     */
    @Test
    public void testCreatePokemonTrainer() {
        IPokedex pokedex = mock(IPokedex.class);
        when(pokedexFactory.createPokedex(any(), any())).thenReturn(pokedex);

        PokemonTrainer trainer = trainerFactory.createTrainer("Zen", Team.INSTINCT, pokedexFactory);

        assertNotNull("Trainer should not be null", trainer);
        assertEquals("Trainer name should be Zen", "Zen", trainer.getName());
        assertEquals("Trainer team should be INSTINCT", Team.INSTINCT, trainer.getTeam());
        assertEquals("Trainer's pokedex should match", pokedex, trainer.getPokedex());
    }

    /**
     * Verifies that a PokemonTrainer instance's attributes can be retrieved.
     */
    @Test
    public void testGetPokemonTrainerInfo() {
        IPokedex pokedex = mock(IPokedex.class);
        when(pokedexFactory.createPokedex(any(), any())).thenReturn(pokedex);

        PokemonTrainer expectedTrainer = new PokemonTrainer("Zen", Team.INSTINCT, pokedex);

        assertEquals("Trainer name should be Zen", "Zen", expectedTrainer.getName());
        assertEquals("Trainer team should be INSTINCT", Team.INSTINCT, expectedTrainer.getTeam());
        assertEquals("Trainer's pokedex should match", pokedex, expectedTrainer.getPokedex());
    }

}
