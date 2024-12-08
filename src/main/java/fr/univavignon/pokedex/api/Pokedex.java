package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
     * Adds the given <tt>pokemon</tt> to this pokedex and returns
     * it unique index.
     * 
     * @param pokemon Pokemon to add to this pokedex.
     * @return Index of this pokemon relative to this pokedex.
     * @throws PokedexException If the given <tt>index</tt> is not valid.
     */
    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size() - 1; // Retourne l'index du Pokémon ajouté
    }
    /**
     * Locates the pokemon identified by the given <tt>id</tt>.
     * 
     * @param id Unique pokedex relative identifier.
     * @return Pokemon denoted by the given identifier.
     * @throws PokedexException If the given <tt>index</tt> is not valid.
     */

    /**
     * Locates the pokemon identified by the given <tt>id</tt>.
     * 
     * @param id Unique pokedex relative identifier.
     * @return Pokemon denoted by the given identifier.
     * @throws PokedexException If the given <tt>id</tt> is not valid.
     */
    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        // Check if the id is within valid range
        if (id < 0 || id >= pokemons.size()) {
            // Throw an exception if the id is invalid
            throw new PokedexException("Invalid Pokemon ID: " + id);
        }
        // Return the Pokemon at the specified id
        return pokemons.get(id);
    }

    /**
     * Returns an unmodifiable list of all pokemons this pokedex contains.
     * This method provides a snapshot of the current state of the pokedex.
     * 
     * @return Unmodifiable list of all pokemons.
     */
    @Override
    public List<Pokemon> getPokemons() {
        // Create a new ArrayList from the current list of pokemons to avoid
        // exposing the internal list to modifications.
        return new ArrayList<>(pokemons); // Return a modifiable copy of the list
    }

    /**
     * Returns an unmodifiable list of all pokemons this pokedex contains.
     * The list view will be sorted using the given <tt>order</tt>.
     * This method provides a snapshot of the current state of the pokedex.
     * 
     * @param order Comparator instance used for sorting the created view.
     * @return Sorted unmodifiable list of all pokemons.
     */
    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedList = new ArrayList<>(pokemons);
        sortedList.sort(order);
        return sortedList;
    }

    /**
     * Retrieves and returns the metadata for the pokemon
     * denoted by the given <tt>index</tt>.
     * 
     * @param index Index of the pokemon to retrieve metadata for.
     * @return Metadata of the pokemon.
     * @throws PokedexException If the given <tt>index</tt> is not valid.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return metadataProvider.getPokemonMetadata(index);
    }

    /**
     * Creates a new Pokemon instance and adds it to the pokedex.
     * 
     * This method utilizes the PokemonFactory to create a Pokemon
     * with the specified parameters and adds it to the internal list
     * of pokemons maintained by this pokedex.
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
        // Use the factory to create a new Pokemon with the given attributes
        Pokemon pokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy);
        
        // Add the created Pokemon to the pokedex
        pokemons.add(pokemon);
        
        // Return the created Pokemon instance
        return pokemon;
    }

    /**
     * Supprime le Pokémon à l'index indiqué.
     * 
     * @param index Index du Pokémon à supprimer.
     * @throws PokedexException Si l'index est nul ou si le Pokémon n'existe pas.
     */
    public void removePokemon(int index) throws PokedexException {
        if (index < 0 || index >= pokemons.size()) {
            throw new PokedexException("Invalid Pokemon ID: " + index);
        }
        pokemons.remove(index);
    }

}
