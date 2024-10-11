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
        IPokedex pokedex = mock(IPokedex.class); // Création d'un pokedex mocké
        PokemonTrainer expectedTrainer = new PokemonTrainer("Zen", Team.INSTINCT, pokedex);
        when(trainerFactory.createTrainer("Zen", Team.INSTINCT, pokedexFactory)).thenReturn(expectedTrainer);
        
        PokemonTrainer actualTrainer = trainerFactory.createTrainer("Zen", Team.INSTINCT, pokedexFactory);
        assertEquals(expectedTrainer, actualTrainer);
    }

    @Test
    public void testCreateMultiplePokemonTrainers() {
        IPokedex pokedex1 = mock(IPokedex.class);
        IPokedex pokedex2 = mock(IPokedex.class);
        IPokedex pokedex3 = mock(IPokedex.class);

        PokemonTrainer trainer1 = new PokemonTrainer("Zen", Team.INSTINCT, pokedex1);
        PokemonTrainer trainer2 = new PokemonTrainer("Misty", Team.INSTINCT, pokedex2);
        PokemonTrainer trainer3 = new PokemonTrainer("Brock", Team.INSTINCT, pokedex3);

        when(trainerFactory.createTrainer("Zen", Team.INSTINCT, pokedexFactory)).thenReturn(trainer1);
        when(trainerFactory.createTrainer("Misty", Team.INSTINCT, pokedexFactory)).thenReturn(trainer2);
        when(trainerFactory.createTrainer("Brock", Team.INSTINCT, pokedexFactory)).thenReturn(trainer3);

        assertEquals(trainer1, trainerFactory.createTrainer("Zen", Team.INSTINCT, pokedexFactory));
        assertEquals(trainer2, trainerFactory.createTrainer("Misty", Team.INSTINCT, pokedexFactory));
        assertEquals(trainer3, trainerFactory.createTrainer("Brock", Team.INSTINCT, pokedexFactory));
    }

    @Test
    public void testCreateTrainerReturnsNotNull() {
        // Test pour s'assurer que la création d'un entraîneur ne renvoie pas null
        IPokedex pokedex = mock(IPokedex.class); // Création d'un pokedex mocké
        PokemonTrainer actualTrainer = new PokemonTrainer("Gary", Team.INSTINCT, pokedex);
        when(trainerFactory.createTrainer("Gary", Team.INSTINCT, pokedexFactory)).thenReturn(actualTrainer);

        PokemonTrainer returnedTrainer = trainerFactory.createTrainer("Gary", Team.INSTINCT, pokedexFactory);
        assertNotNull(returnedTrainer);
    }
}
