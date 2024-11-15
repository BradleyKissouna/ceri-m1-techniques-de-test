package fr.univavignon.pokedex.api;

public class PokedexFactory implements IPokedexFactory {

    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        // Créer un Pokedex en utilisant les providers donnés
        return new Pokedex(metadataProvider, pokemonFactory);
    }

}
