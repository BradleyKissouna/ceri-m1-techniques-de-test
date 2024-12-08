package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Pokedex class implementing the IPokedex interface.
 * 
 * This class provides an implementation for managing a collection of Pokemon,
 * along with their metadata, using a given metadata provider and Pokemon factory.
 * It allows adding, retrieving, and removing Pokemon, as well as accessing their
 * metadata and creating new Pokemon instances.
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

    /**
     * Constructs a new Pokedex with the specified metadata provider and Pokemon factory.
     * 
     * @param metadataProvider The metadata provider to use for retrieving Pokemon metadata.
     * @param pokemonFactory The factory to use for creating Pokemon instances.
     */
    public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
        this.pokemons = new ArrayList<>();
    }

    /**
     * Returns the number of Pokemon this Pokedex contains.
     * 
     * @return Number of Pokemon in this Pokedex.
     */
    @Override
    public int size() {
        return pokemons.size();
    }

    /**
     * Adds the given Pokemon to this Pokedex and returns its unique index.
     * 
     * @param pokemon Pokemon to add to this Pokedex.
     * @return Index of this Pokemon relative to this Pokedex.
     * @throws PokedexException If the given Pokemon is not valid.
     */
    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size() - 1; // Return the index of the added Pokemon
    }

    /**
     * Locates the Pokemon identified by the given id.
     * 
     * @param id Unique Pokedex relative identifier.
     * @return Pokemon denoted by the given identifier.
     * @throws PokedexException If the given id is not valid.
     */
    @Override
    public Pokemon getPokemon(int id){
        if (id < 0 || id >= pokemons.size()) {
            try {
                throw new PokedexException("Invalid Pokemon ID: " + id);
            } catch (PokedexException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return pokemons.get(id);
    }

    /**
     * Returns an unmodifiable list of all Pokemon this Pokedex contains.
     * 
     * @return Unmodifiable list of all Pokemon.
     */
    @Override
    public List<Pokemon> getPokemons() {
        return new ArrayList<>(pokemons); // Return a modifiable copy of the list
    }

    /**
     * Returns an unmodifiable list of all Pokemon this Pokedex contains, sorted by the given order.
     * 
     * @param order Comparator instance used for sorting the created view.
     * @return Sorted unmodifiable list of all Pokemon.
     */
    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedList = new ArrayList<>(pokemons);
        sortedList.sort(order);
        return sortedList;
    }

    /**
     * Retrieves and returns the metadata for the Pokemon denoted by the given index.
     * 
     * @param index Index of the Pokemon to retrieve metadata for.
     * @return Metadata of the Pokemon.
     * @throws PokedexException If the given index is not valid.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return metadataProvider.getPokemonMetadata(index);
    }

    /**
     * Creates a new Pokemon instance and adds it to the Pokedex.
     * 
     * This method utilizes the PokemonFactory to create a Pokemon with the specified
     * parameters and adds it to the internal list of Pokemon maintained by this Pokedex.
     *
     * @param index Index of the Pokemon to create.
     * @param cp Combat Power of the Pokemon.
     * @param hp Health Points of the Pokemon.
     * @param dust Dust required to upgrade the Pokemon.
     * @param candy Candy required to upgrade the Pokemon.
     * @return The created Pokemon instance.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        Pokemon pokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy);
        pokemons.add(pokemon);
        return pokemon;
    }

    /**
     * Removes the Pokemon at the specified index.
     * 
     * @param index Index of the Pokemon to remove.
     * @throws PokedexException If the index is not valid or if the Pokemon does not exist.
     */
    public void removePokemon(int index) throws PokedexException {
        if (index < 0 || index >= pokemons.size()) {
            throw new PokedexException("Invalid Pokemon ID: " + index);
        }
        pokemons.remove(index);
    }
}
