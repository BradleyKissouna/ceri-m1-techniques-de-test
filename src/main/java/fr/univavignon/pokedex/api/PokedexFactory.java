package fr.univavignon.pokedex.api;


public class PokedexFactory implements IPokedexFactory {

    /**
     * Creates a new instance of Pokedex using the provided metadata provider and 
     * Pokemon factory.
     *
     * @param metadataProvider the metadata provider to use for retrieving Pokemon metadata.
     * @param pokemonFactory the factory to use for creating Pokemon instances.
     * @return a new Pokedex instance initialized with the provided metadata provider 
     *         and Pokemon factory.
     */
    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        return new Pokedex(metadataProvider, pokemonFactory);
    }

}
