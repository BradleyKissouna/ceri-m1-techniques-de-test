package fr.univavignon.pokedex.api;

/**
 * Pokemon metadata POJO.
 * 
 * This class encapsulates the basic metadata for a Pokemon including its
 * index, name, and stats for attack, defense, and stamina.
 * 
 * @author fv
 */
public class PokemonMetadata {

    /** Pokemon index. **/
    private final int index;

    /** Pokemon name. **/
    private final String name;

    /** Pokemon attack level. **/
    private final int attack;

    /** Pokemon defense level. **/
    private final int defense;

    /** Pokemon stamina level. **/
    private final int stamina;

    /**
     * Default constructor.
     * 
     * Initializes a new instance of PokemonMetadata with the specified
     * index, name, attack, defense, and stamina values.
     * 
     * @param index Pokemon index.
     * @param name Pokemon name.
     * @param attack Attack level.
     * @param defense Defense level.
     * @param stamina Stamina level.
     */
    public PokemonMetadata(final int index, final String name, final int attack, final int defense, final int stamina) {
        this.index = index;
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.stamina = stamina;
    }
    
    /**
     * Returns the index of the Pokemon.
     * 
     * @return Pokemon index.
     */
    public int getIndex() {
        return index;
    }
    
    /**
     * Returns the name of the Pokemon.
     * 
     * @return Pokemon name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the attack level of the Pokemon.
     * 
     * @return Pokemon attack level.
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Returns the defense level of the Pokemon.
     * 
     * @return Pokemon defense level.
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Returns the stamina level of the Pokemon.
     * 
     * @return Pokemon stamina level.
     */
    public int getStamina() {
        return stamina;
    }
}
