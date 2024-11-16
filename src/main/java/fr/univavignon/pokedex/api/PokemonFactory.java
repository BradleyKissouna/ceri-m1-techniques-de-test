package fr.univavignon.pokedex.api;

import java.util.Random;

public class PokemonFactory implements IPokemonFactory {

    private final IPokemonMetadataProvider metadataProvider;

    // Constructeur qui permet d'injecter un fournisseur de métadonnées
    public PokemonFactory(IPokemonMetadataProvider metadataProvider) {
        this.metadataProvider = metadataProvider;
    }

    // Méthode pour calculer les IV d'un Pokémon (Individual Values) entre 0 et 15
    private static int calculateIV() {
        Random random = new Random();
        return random.nextInt(16); // IV compris entre 0 et 15
    }

    /**
     * Crée un Pokémon avec des statistiques calculées à partir de ses métadonnées.
     *
     * @param index  L'index du Pokémon à créer.
     * @param cp     Le CP (Combat Power) du Pokémon.
     * @param hp     Les HP (Health Points) du Pokémon.
     * @param dust   La poussière nécessaire pour l'amélioration du Pokémon.
     * @param candy  Les bonbons nécessaires pour l'amélioration du Pokémon.
     * @return L'instance du Pokémon créé.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        PokemonMetadata metadata;

        try {
            // Tenter de récupérer les métadonnées du Pokémon à l'index donné
            metadata = metadataProvider.getPokemonMetadata(index);

            // Récupérer les statistiques de base du Pokémon
            int baseAttack = metadata.getAttack();
            int baseDefense = metadata.getDefense();
            int baseStamina = metadata.getStamina();

            // Calculer les IV pour chaque statistique
            int ivAttack = calculateIV();
            int ivDefense = calculateIV();
            int ivStamina = calculateIV();

            // Créer et retourner un nouvel objet Pokémon
            return new Pokemon(index, metadata.getName(), baseAttack + ivAttack, baseDefense + ivDefense,
                               baseStamina + ivStamina, cp, hp, dust, candy, 1.0);
        } catch (PokedexException e) {
            // Si une exception est levée, loggez-la et retournez un Pokémon par défaut
            System.err.println("Erreur lors de la récupération des métadonnées pour l'index " + index + ": " + e.getMessage());
            e.printStackTrace();
            // Vous pouvez retourner un Pokémon par défaut (par exemple MISSINGNO)
            return new Pokemon(index, "MISSINGNO", 0, 0, 0, cp, hp, dust, candy, 0.0);
        }
    }

}
