package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    private Map<Integer, PokemonMetadata> metadataMap = new HashMap<>();

    public PokemonMetadataProvider() {
        metadataMap.put(1, new PokemonMetadata(1, "Bulbasaur", 49, 49, 45));
        metadataMap.put(2, new PokemonMetadata(2, "Ivysaur", 62, 63, 60));
        metadataMap.put(3, new PokemonMetadata(3, "Venusaur", 82, 83, 80));
        metadataMap.put(4, new PokemonMetadata(4, "Charmander", 52, 43, 39));
        metadataMap.put(5, new PokemonMetadata(5, "Charmeleon", 64, 58, 50));
        metadataMap.put(6, new PokemonMetadata(6, "Charizard", 84, 78, 78));
        metadataMap.put(7, new PokemonMetadata(7, "Squirtle", 48, 65, 44));
        metadataMap.put(8, new PokemonMetadata(8, "Wartortle", 63, 80, 59));
        metadataMap.put(9, new PokemonMetadata(9, "Blastoise", 83, 100, 79));
        metadataMap.put(10, new PokemonMetadata(10, "Caterpie", 30, 35, 30));
        metadataMap.put(11, new PokemonMetadata(11, "Metapod", 20, 55, 40));
        metadataMap.put(12, new PokemonMetadata(12, "Butterfree", 45, 50, 60));
        metadataMap.put(13, new PokemonMetadata(13, "Weedle", 35, 30, 40));
        metadataMap.put(14, new PokemonMetadata(14, "Kakuna", 25, 50, 45));
        metadataMap.put(15, new PokemonMetadata(15, "Beedrill", 90, 40, 65));
        metadataMap.put(16, new PokemonMetadata(16, "Pidgey", 45, 40, 40));
        metadataMap.put(17, new PokemonMetadata(17, "Pidgeotto", 60, 55, 50));
        metadataMap.put(18, new PokemonMetadata(18, "Pidgeot", 80, 75, 70));
        metadataMap.put(19, new PokemonMetadata(19, "Rattata", 56, 35, 30));
        metadataMap.put(20, new PokemonMetadata(20, "Raticate", 81, 60, 55));
        metadataMap.put(21, new PokemonMetadata(21, "Spearow", 60, 30, 30));
        metadataMap.put(22, new PokemonMetadata(22, "Fearow", 90, 65, 60));
        metadataMap.put(23, new PokemonMetadata(23, "Ekans", 60, 44, 35));
        metadataMap.put(24, new PokemonMetadata(24, "Arbok", 85, 69, 60));
        metadataMap.put(25, new PokemonMetadata(25, "Pikachu", 55, 40, 35));
        metadataMap.put(26, new PokemonMetadata(26, "Raichu", 90, 55, 60));
        metadataMap.put(27, new PokemonMetadata(27, "Sandshrew", 50, 75, 60));
        metadataMap.put(28, new PokemonMetadata(28, "Sandslash", 75, 100, 85));
        metadataMap.put(29, new PokemonMetadata(29, "Nidorano", 47, 52, 45));
        metadataMap.put(30, new PokemonMetadata(30, "Nidorina", 62, 57, 70));
        metadataMap.put(31, new PokemonMetadata(31, "Nidoqueen", 92, 87, 100));
        metadataMap.put(32, new PokemonMetadata(32, "Nidorano", 56, 47, 40));
        metadataMap.put(33, new PokemonMetadata(33, "Nidorino", 71, 57, 70));
        metadataMap.put(34, new PokemonMetadata(34, "Nidoking", 102, 77, 85));
        metadataMap.put(35, new PokemonMetadata(35, "Clefairy", 70, 48, 60));
        metadataMap.put(36, new PokemonMetadata(36, "Clefable", 95, 73, 95));
        metadataMap.put(37, new PokemonMetadata(37, "Vulpix", 41, 40, 65));
        metadataMap.put(38, new PokemonMetadata(38, "Ninetales", 76, 75, 100));
        metadataMap.put(39, new PokemonMetadata(39, "Zubat", 45, 35, 40));
        metadataMap.put(40, new PokemonMetadata(40, "Golbat", 80, 70, 75));
        metadataMap.put(41, new PokemonMetadata(41, "Oddish", 50, 55, 45));
        metadataMap.put(42, new PokemonMetadata(42, "Gloom", 65, 70, 60));
        metadataMap.put(43, new PokemonMetadata(43, "Vileplume", 75, 85, 75));
        metadataMap.put(44, new PokemonMetadata(44, "Paras", 35, 70, 60));
        metadataMap.put(45, new PokemonMetadata(45, "Parasect", 60, 95, 80));
        metadataMap.put(46, new PokemonMetadata(46, "Venonat", 60, 55, 60));
        metadataMap.put(47, new PokemonMetadata(47, "Venomoth", 65, 60, 60));
        metadataMap.put(48, new PokemonMetadata(48, "Diglett", 55, 25, 40));
        metadataMap.put(49, new PokemonMetadata(49, "Dugtrio", 80, 50, 70));
        metadataMap.put(50, new PokemonMetadata(50, "Meowth", 45, 35, 45));
        metadataMap.put(51, new PokemonMetadata(51, "Persian", 70, 60, 65));
        metadataMap.put(52, new PokemonMetadata(52, "Psyduck", 52, 48, 50));
        metadataMap.put(53, new PokemonMetadata(53, "Golduck", 80, 82, 70));
        metadataMap.put(54, new PokemonMetadata(54, "Machop", 80, 35, 35));
        metadataMap.put(55, new PokemonMetadata(55, "Machoke", 100, 65, 60));
        metadataMap.put(56, new PokemonMetadata(56, "Machamp", 130, 95, 85));
        metadataMap.put(57, new PokemonMetadata(57, "Bellsprout", 75, 35, 40));
        metadataMap.put(58, new PokemonMetadata(58, "Weepinbell", 90, 50, 65));
        metadataMap.put(59, new PokemonMetadata(59, "Victreebel", 105, 65, 80));
        metadataMap.put(60, new PokemonMetadata(60, "Tentacool", 40, 35, 40));
        metadataMap.put(61, new PokemonMetadata(61, "Tentacruel", 70, 65, 80));
        metadataMap.put(62, new PokemonMetadata(62, "Geodude", 80, 100, 40));
        metadataMap.put(63, new PokemonMetadata(63, "Graveler", 95, 115, 55));
        metadataMap.put(64, new PokemonMetadata(64, "Golem", 110, 130, 80));
        metadataMap.put(65, new PokemonMetadata(65, "Ponyta", 65, 40, 40));
        metadataMap.put(66, new PokemonMetadata(66, "Rapidash", 80, 70, 80));
        metadataMap.put(67, new PokemonMetadata(67, "Slowpoke", 65, 65, 65));
        metadataMap.put(68, new PokemonMetadata(68, "Slowbro", 100, 75, 95));
        metadataMap.put(69, new PokemonMetadata(69, "Magnemite", 35, 35, 70));
        metadataMap.put(70, new PokemonMetadata(70, "Magneton", 60, 60, 95));
        metadataMap.put(71, new PokemonMetadata(71, "Farfetch'd", 65, 55, 40));
        metadataMap.put(72, new PokemonMetadata(72, "Doduo", 85, 45, 35));
        metadataMap.put(73, new PokemonMetadata(73, "Dodrio", 110, 70, 60));
        metadataMap.put(74, new PokemonMetadata(74, "Seel", 65, 45, 55));
        metadataMap.put(75, new PokemonMetadata(75, "Dewgong", 90, 70, 85));
        metadataMap.put(76, new PokemonMetadata(76, "Grimer", 80, 50, 65));
        metadataMap.put(77, new PokemonMetadata(77, "Muk", 105, 75, 85));
        metadataMap.put(78, new PokemonMetadata(78, "Shellder", 40, 65, 40));
        metadataMap.put(79, new PokemonMetadata(79, "Cloyster", 70, 95, 85));
        metadataMap.put(80, new PokemonMetadata(80, "Gastly", 35, 30, 30));
        metadataMap.put(81, new PokemonMetadata(81, "Haunter", 50, 45, 40));
        metadataMap.put(82, new PokemonMetadata(82, "Gengar", 65, 60, 60));
        metadataMap.put(83, new PokemonMetadata(83, "Onix", 35, 45, 160));
        metadataMap.put(84, new PokemonMetadata(84, "Drowzee", 48, 45, 42));
        metadataMap.put(85, new PokemonMetadata(85, "Hypno", 73, 73, 70));
        metadataMap.put(86, new PokemonMetadata(86, "Krabby", 105, 90, 25));
        metadataMap.put(87, new PokemonMetadata(87, "Kingler", 130, 115, 50));
        metadataMap.put(88, new PokemonMetadata(88, "Exeggcute", 40, 80, 35));
        metadataMap.put(89, new PokemonMetadata(89, "Exeggutor", 60, 100, 60));
        metadataMap.put(90, new PokemonMetadata(90, "Cubone", 50, 95, 50));
        metadataMap.put(91, new PokemonMetadata(91, "Marowak", 70, 110, 60));
        metadataMap.put(92, new PokemonMetadata(92, "Lickitung", 60, 55, 75));
        metadataMap.put(93, new PokemonMetadata(93, "Koffing", 60, 65, 60));
        metadataMap.put(94, new PokemonMetadata(94, "Weezing", 95, 90, 85));
        metadataMap.put(95, new PokemonMetadata(95, "Rhyhorn", 80, 95, 40));
        metadataMap.put(96, new PokemonMetadata(96, "Rhydon", 105, 130, 55));
        metadataMap.put(97, new PokemonMetadata(97, "Chansey", 5, 5, 70));
        metadataMap.put(98, new PokemonMetadata(98, "Tangela", 65, 55, 115));
        metadataMap.put(99, new PokemonMetadata(99, "Kangaskhan", 95, 80, 85));
        metadataMap.put(100, new PokemonMetadata(100, "Horsea", 40, 30, 35));
        metadataMap.put(101, new PokemonMetadata(101, "Seadra", 65, 95, 55));
        metadataMap.put(102, new PokemonMetadata(102, "Goldeen", 67, 60, 35));
        metadataMap.put(103, new PokemonMetadata(103, "Seaking", 92, 65, 60));
        metadataMap.put(104, new PokemonMetadata(104, "Staryu", 45, 40, 30));
        metadataMap.put(105, new PokemonMetadata(105, "Starmie", 75, 85, 60));
        metadataMap.put(106, new PokemonMetadata(106, "Mr. Mime", 45, 65, 65));
        metadataMap.put(107, new PokemonMetadata(107, "Scyther", 110, 80, 70));
        metadataMap.put(108, new PokemonMetadata(108, "Jynx", 50, 35, 95));
        metadataMap.put(109, new PokemonMetadata(109, "Electabuzz", 83, 57, 50));
        metadataMap.put(110, new PokemonMetadata(110, "Magmar", 95, 57, 85));
        metadataMap.put(111, new PokemonMetadata(111, "Pinsir", 125, 100, 55));
        metadataMap.put(112, new PokemonMetadata(112, "Tauros", 100, 95, 70));
        metadataMap.put(113, new PokemonMetadata(113, "Magikarp", 10, 55, 80));
        metadataMap.put(114, new PokemonMetadata(114, "Gyarados", 125, 60, 100));
        metadataMap.put(115, new PokemonMetadata(115, "Lapras", 85, 75, 80));
        metadataMap.put(116, new PokemonMetadata(116, "Ditto", 48, 48, 48));
        metadataMap.put(117, new PokemonMetadata(117, "Eevee", 55, 50, 55));
        metadataMap.put(118, new PokemonMetadata(118, "Vaporeon", 130, 65, 60));
        metadataMap.put(119, new PokemonMetadata(119, "Jolteon", 65, 110, 60));
        metadataMap.put(120, new PokemonMetadata(120, "Flareon", 130, 65, 60));
        metadataMap.put(121, new PokemonMetadata(121, "Porygon", 60, 60, 70));
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (index < 0 || index >= metadataMap.size()) {
            throw new PokedexException("Index out of range");
        }
        return metadataMap.get(index);
    }

}
