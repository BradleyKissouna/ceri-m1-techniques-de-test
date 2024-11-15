package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {

    private final List<Pokemon> pokemons;

    public Pokedex() {
        this.pokemons = new ArrayList<>();
    }

    @Override
    public int size() {
        return pokemons.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size() - 1; // Retourne l'index de ce Pokémon
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if (id < 0 || id >= pokemons.size()) {
            throw new PokedexException("Invalid Pokemon ID: " + id);
        }
        return pokemons.get(id);
    }

    @Override
    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedPokemons = new ArrayList<>(pokemons);
        sortedPokemons.sort(order);
        return sortedPokemons;
    }

    // Méthodes héritées de IPokemonMetadataProvider et IPokemonFactory
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        // TODO
		return null;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        // TODO
		return null;
    }

}
