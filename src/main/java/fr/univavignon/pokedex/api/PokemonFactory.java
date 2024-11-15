package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PokemonFactory implements IPokemonFactory {

    // Map d'index à noms pour les Pokémon de la première génération (0 à 150)
    private static Map<Integer, String> index2name;
    static {
        Map<Integer, String> aMap = new HashMap<>();
        aMap.put(0, "MISSINGNO");
        aMap.put(1, "Bulbasaur");
        aMap.put(2, "Ivysaur");
        aMap.put(3, "Venusaur");
        aMap.put(4, "Charmander");
        aMap.put(5, "Charmeleon");
        aMap.put(6, "Charizard");
        aMap.put(7, "Squirtle");
        aMap.put(8, "Wartortle");
        aMap.put(9, "Blastoise");
        aMap.put(10, "Caterpie");
        aMap.put(11, "Metapod");
        aMap.put(12, "Butterfree");
        aMap.put(13, "Weedle");
        aMap.put(14, "Kakuna");
        aMap.put(15, "Beedrill");
        aMap.put(16, "Pidgey");
        aMap.put(17, "Pidgeotto");
        aMap.put(18, "Pidgeot");
        aMap.put(19, "Rattata");
        aMap.put(20, "Raticate");
        aMap.put(21, "Spearow");
        aMap.put(22, "Fearow");
        aMap.put(23, "Ekans");
        aMap.put(24, "Arbok");
        aMap.put(25, "Pikachu");
        aMap.put(26, "Raichu");
        aMap.put(27, "Sandshrew");
        aMap.put(28, "Sandslash");
        aMap.put(29, "Nidoran♀");
        aMap.put(30, "Nidorina");
        aMap.put(31, "Nidoqueen");
        aMap.put(32, "Nidoran♂");
        aMap.put(33, "Nidorino");
        aMap.put(34, "Nidoking");
        aMap.put(35, "Clefairy");
        aMap.put(36, "Clefable");
        aMap.put(37, "Vulpix");
        aMap.put(38, "Ninetales");
        aMap.put(39, "Zubat");
        aMap.put(40, "Golbat");
        aMap.put(41, "Oddish");
        aMap.put(42, "Gloom");
        aMap.put(43, "Vileplume");
        aMap.put(44, "Paras");
        aMap.put(45, "Parasect");
        aMap.put(46, "Venonat");
        aMap.put(47, "Venomoth");
        aMap.put(48, "Diglett");
        aMap.put(49, "Dugtrio");
        aMap.put(50, "Meowth");
        aMap.put(51, "Persian");
        aMap.put(52, "Psyduck");
        aMap.put(53, "Golduck");
        aMap.put(54, "Machop");
        aMap.put(55, "Machoke");
        aMap.put(56, "Machamp");
        aMap.put(57, "Bellsprout");
        aMap.put(58, "Weepinbell");
        aMap.put(59, "Victreebel");
        aMap.put(60, "Tentacool");
        aMap.put(61, "Tentacruel");
        aMap.put(62, "Geodude");
        aMap.put(63, "Graveler");
        aMap.put(64, "Golem");
        aMap.put(65, "Ponyta");
        aMap.put(66, "Rapidash");
        aMap.put(67, "Slowpoke");
        aMap.put(68, "Slowbro");
        aMap.put(69, "Magnemite");
        aMap.put(70, "Magneton");
        aMap.put(71, "Farfetch'd");
        aMap.put(72, "Doduo");
        aMap.put(73, "Dodrio");
        aMap.put(74, "Seel");
        aMap.put(75, "Dewgong");
        aMap.put(76, "Grimer");
        aMap.put(77, "Muk");
        aMap.put(78, "Shellder");
        aMap.put(79, "Cloyster");
        aMap.put(80, "Gastly");
        aMap.put(81, "Haunter");
        aMap.put(82, "Gengar");
        aMap.put(83, "Onix");
        aMap.put(84, "Drowzee");
        aMap.put(85, "Hypno");
        aMap.put(86, "Krabby");
        aMap.put(87, "Kingler");
        aMap.put(88, "Exeggcute");
        aMap.put(89, "Exeggutor");
        aMap.put(90, "Cubone");
        aMap.put(91, "Marowak");
        aMap.put(92, "Hitmonlee");
        aMap.put(93, "Hitmonchan");
        aMap.put(94, "Lickitung");
        aMap.put(95, "Koffing");
        aMap.put(96, "Weezing");
        aMap.put(97, "Rhyhorn");
        aMap.put(98, "Rhydon");
        aMap.put(99, "Chansey");
        aMap.put(100, "Tangela");
        aMap.put(101, "Kangaskhan");
        aMap.put(102, "Horsea");
        aMap.put(103, "Seadra");
        aMap.put(104, "Goldeen");
        aMap.put(105, "Seaking");
        aMap.put(106, "Staryu");
        aMap.put(107, "Starmie");
        aMap.put(108, "Mr. Mime");
        aMap.put(109, "Scyther");
        aMap.put(110, "Jynx");
        aMap.put(111, "Electrode");
        aMap.put(112, "Exeggutor");
        aMap.put(113, "Lickitung");
        aMap.put(114, "Koffing");
        aMap.put(115, "Weezing");
        aMap.put(116, "Rhyhorn");
        aMap.put(117, "Rhydon");
        aMap.put(118, "Chansey");
        aMap.put(119, "Tangela");
        aMap.put(120, "Kangaskhan");
        aMap.put(121, "Horsea");
        aMap.put(122, "Seadra");
        aMap.put(123, "Goldeen");
        aMap.put(124, "Seaking");
        aMap.put(125, "Staryu");
        aMap.put(126, "Starmie");
        aMap.put(127, "Kabuto");
        aMap.put(128, "Kabutops");
        aMap.put(129, "Aerodactyl");
        aMap.put(130, "Snorlax");
        aMap.put(131, "Mew");

        index2name = aMap;
    }

    private static int generateRandomStat() {
        int total = 0;
        for (int i = 0; i < 1000000; i++) {
            Random rn = new Random();
            int r = rn.nextInt(2);
            total += r;
        }
        return total / 10000;
    }

    /**
     * Crée un Pokémon avec des statistiques générées aléatoirement, ou avec des valeurs fixes pour des Pokémon spéciaux.
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
        // Récupérer le nom du Pokémon basé sur l'index
        String name;
        if (!index2name.containsKey(index)) {
            name = index2name.get(0);  // Utiliser MISSINGNO si l'index n'est pas trouvé
        } else {
            name = index2name.get(index);
        }

        // Définir les statistiques de base
        int attack;
        int defense;
        int stamina;
        double iv;

        // Si l'index est spécial (comme MISSINGNO), on lui donne des stats fixes
        if (index < 0) {
            attack = 1000;
            defense = 1000;
            stamina = 1000;
            iv = 0;  // IV de 0 pour les Pokémon spéciaux comme MISSINGNO
        } else {
            // Pour les Pokémon normaux, on génère des statistiques aléatoires
            attack = generateRandomStat();
            defense = generateRandomStat();
            stamina = generateRandomStat();
            iv = 1;  // IV de 1 (100%) pour les Pokémon normaux
        }

        // Créer et retourner un nouvel objet Pokémon
        return new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);
    }

}
