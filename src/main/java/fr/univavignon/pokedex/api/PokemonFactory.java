package fr.univavignon.pokedex.api;

import java.util.Random;

/**
 * A factory class for creating Pokemon instances, which includes computing their Individual Values (IVs).
 * Implements the IPokemonFactory interface.
 * 
 * @see IPokemonFactory
 */
public class PokemonFactory implements IPokemonFactory {

    private final IPokemonMetadataProvider metadataProvider;

    /**
     * Constructor that allows metadata provider injection.
     * 
     * @param metadataProvider The metadata provider to use for retrieving Pokemon metadata.
     */
    public PokemonFactory(IPokemonMetadataProvider metadataProvider) {
        this.metadataProvider = metadataProvider;
    }

    /**
     * Calculates an Individual Value (IV) for a Pokemon statistic, ranging from 0 to 15.
     * 
     * @return A random IV between 0 and 15.
     */
    @Override
    public int calculateIV() {
        Random random = new Random();
        return random.nextInt(16); // IV between 0 and 15
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
        PokemonMetadata metadata;

        try {
            // Attempt to retrieve the metadata for the Pokemon at the given index
            metadata = metadataProvider.getPokemonMetadata(index);

            // Retrieve the base statistics from the metadata
            int baseAttack = metadata.getAttack();
            int baseDefense = metadata.getDefense();
            int baseStamina = metadata.getStamina();

            // Calculate IVs for each statistic
            int ivAttack = calculateIV();
            int ivDefense = calculateIV();
            int ivStamina = calculateIV();

            // Create and return a new Pokemon object
            return new Pokemon(index, metadata.getName(), baseAttack + ivAttack, baseDefense + ivDefense,
                               baseStamina + ivStamina, cp, hp, dust, candy, 1.0);
        } catch (PokedexException e) {
            // Log the exception and return a default Pokemon if metadata retrieval fails
            System.err.println("Error retrieving metadata for index " + index + ": " + e.getMessage());
            e.printStackTrace();
            // Return a default Pokemon instance (e.g., MISSINGNO)
            return new Pokemon(index, "MISSINGNO", 0, 0, 0, cp, hp, dust, candy, 0.0);
        }
    }

}
