package fr.univavignon.pokedex.api;

/**
 * Factory class for creating PokemonTrainer instances.
 *
 * @author fv
 */
public class PokemonTrainerFactory implements IPokemonTrainerFactory {

    /**
     * Creates a PokemonTrainer instance.
     *
     * @param name Name of the created trainer.
     * @param team Team of the created trainer.
     * @param pokedexFactory Factory to use for creating associated pokedex instance.
     * @return Created trainer instance.
     */
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        // Crée un Pokedex pour le formateur
        IPokedex pokedex = pokedexFactory.createPokedex(
            new PokemonMetadataProvider(),
            new PokemonFactory(new PokemonMetadataProvider())
        );

        return new PokemonTrainer(name, team, pokedex);
    }

}
