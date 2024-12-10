package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Implementation of the IPokedex interface.
 * Manages a collection of captured Pokemon and provides functionality to
 * add, retrieve, and sort them, as well as access their metadata.
 *
 * This class utilizes a metadata provider and a Pokemon factory to manage
 * the creation and retrieval of Pokemon and their associated metadata.
 *
 * @see IPokedex
 * @see IPokemonMetadataProvider
 * @see IPokemonFactory
 * @see Pokemon
 * @see PokemonMetadata
 * 
 * @author fv
 */
public class Pokedex implements IPokedex {

    private final IPokemonMetadataProvider metadataProvider;
    private final IPokemonFactory pokemonFactory;
    private final List<Pokemon> pokemons;

    public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
        this.pokemons = new ArrayList<>();
    }

    /**
     * Returns the number of pokemon this pokedex contains.
     * 
     * @return Number of pokemon in this pokedex.
     */
    @Override
    public int size() {
        return pokemons.size();
    }

    /**
     * Adds the given <code>pokemon</code> to this pokedex and returns
     * it unique index.
     * 
     * @param pokemon Pokemon to add to this pokedex.
     * @return Index of this pokemon relative to this pokedex.
     */
    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size() - 1; // Retourne l'index du Pokémon ajouté
    }

    /**
     * Locates the pokemon identified by the given <code>id</code>.
     * 
     * @param id Unique pokedex relative identifier.
     * @return Pokemon denoted by the given identifier.
     * @throws PokedexException If the given <tt>index</tt> is not valid.
     */
    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if (id < 0 || id >= pokemons.size()) {
            throw new PokedexException("Invalid Pokemon ID: " + id);
        }
        return pokemons.get(id);
    }

    /**
     * Returns an unmodifiable list of all pokemons this pokedex contains.
     * 
     * @return Unmodifiable list of all pokemons.
     */
    @Override
    public List<Pokemon> getPokemons() {
        return new ArrayList<>(pokemons); // Retourne une copie modifiable
    }

    /**
     * * Returns an unmodifiable list of all pokemons this pokedex contains.
     * 	 * The list view will be sorted using the given <code>order</code>.
     * 	 * 
     * 	 * @param order Comparator instance used for sorting the created view.
     * 	 * @return Sorted unmodifiable list of all pokemons.
     * 	 */
    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedList = new ArrayList<>(pokemons);
        sortedList.sort(order);
        return sortedList;
    }

    /**
     * Retrieves and returns the metadata for the pokemon
     * denoted by the given <code>index</code>.
     * 
     * @param index Index of the pokemon to retrieve metadata for.
     * @return Metadata of the pokemon.
     * @throws PokedexException If the given <code>index</code> is not valid.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return metadataProvider.getPokemonMetadata(index);
    }

    /**
     * Creates a Pokemon with statistics computed from its metadata.
     * 
     * This method retrieves the metadata for the specified Pokemon index and uses it to
     * calculate the base statistics. It then computes random IVs for each statistic and
     * returns a new Pokemon instance with these values.
     * 
     * @param index  The index of the Pokemon to create.
     * @param cp     The Combat Power (CP) of the Pokemon.
     * @param hp     The Health Points (HP) of the Pokemon.
     * @param dust   The required dust for upgrading the Pokemon.
     * @param candy  The required candy for upgrading the Pokemon.
     * @return The created Pokemon instance with computed statistics.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        Pokemon pokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy);
        pokemons.add(pokemon);
        return pokemon;
    }

}
