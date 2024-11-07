package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class IPokemonFactoryTest {
    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        pokemonFactory = mock(IPokemonFactory.class);
    }

    @Test
    public void testCreateMultiplePokemons() {
        Pokemon pikachu = mock(Pokemon.class);
        when(pikachu.getIndex()).thenReturn(1);
        when(pikachu.getName()).thenReturn("Pikachu");
        when(pikachu.getCp()).thenReturn(500);
        when(pikachu.getHp()).thenReturn(60);
        when(pikachu.getDust()).thenReturn(300);
        when(pikachu.getCandy()).thenReturn(25);

        Pokemon bulbizarre = mock(Pokemon.class);
        when(bulbizarre.getIndex()).thenReturn(0);
        when(bulbizarre.getName()).thenReturn("Bulbizarre");
        when(bulbizarre.getCp()).thenReturn(613);
        when(bulbizarre.getHp()).thenReturn(64);
        when(bulbizarre.getDust()).thenReturn(4000);
        when(bulbizarre.getCandy()).thenReturn(4);

        Pokemon salamèche = mock(Pokemon.class);
        when(salamèche.getIndex()).thenReturn(3);
        when(salamèche.getName()).thenReturn("Salamèche");
        when(salamèche.getCp()).thenReturn(600);
        when(salamèche.getHp()).thenReturn(55);
        when(salamèche.getDust()).thenReturn(250);
        when(salamèche.getCandy()).thenReturn(15);

        when(pokemonFactory.createPokemon(1, 500, 60, 300, 25)).thenReturn(pikachu);
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbizarre);
        when(pokemonFactory.createPokemon(3, 600, 55, 250, 15)).thenReturn(salamèche);

        Pokemon actualPikachu = pokemonFactory.createPokemon(1, 500, 60, 300, 25);
        Pokemon actualBulbizarre = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        Pokemon actualSalamèche = pokemonFactory.createPokemon(3, 600, 55, 250, 15);

        assertEquals(pikachu, actualPikachu);
        assertEquals(bulbizarre, actualBulbizarre);
        assertEquals(salamèche, actualSalamèche);

        assertEquals("Pikachu", actualPikachu.getName());
        assertEquals(613, actualBulbizarre.getCp());
        assertEquals(55, actualSalamèche.getHp());
    }

    @Test
    public void testGetPokemonInfo() {
        Pokemon pikachuFactory = mock(Pokemon.class);
        when(pikachuFactory.getIndex()).thenReturn(1);
        when(pikachuFactory.getName()).thenReturn("Pikachu");
        when(pikachuFactory.getCp()).thenReturn(500);
        when(pikachuFactory.getHp()).thenReturn(60);
        when(pikachuFactory.getDust()).thenReturn(300);
        when(pikachuFactory.getCandy()).thenReturn(25);

        PokemonMetadata pikachuMetadata = new PokemonMetadata(1, "Pikachu", 500, 60, 300);

        when(pokemonFactory.createPokemon(1, 500, 60, 300, 25)).thenReturn(pikachuFactory);
        
        Pokemon actualPikachu = new Pokemon(pikachuMetadata.getIndex(), pikachuMetadata.getName(), pikachuMetadata.getAttack(), pikachuMetadata.getDefense(), pikachuMetadata.getStamina(), pikachuFactory.getCp(), pikachuFactory.getHp(), pikachuFactory.getDust(), pikachuFactory.getCandy(), 0.9);

        assertEquals("Pikachu", actualPikachu.getName());
        assertEquals(500, actualPikachu.getCp());
        assertEquals(60, actualPikachu.getHp());
        assertEquals(300, actualPikachu.getDust());
        assertEquals(25, actualPikachu.getCandy());
        assertEquals(0.9, actualPikachu.getIv(), 0.01);
    }
}
