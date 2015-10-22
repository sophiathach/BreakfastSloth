package sloth.adventure;
import java.util.Hashtable;

public class Participant {
    private String name;
    private String gender;
    private Hashtable<String, Integer> stats = new Hashtable<String, Integer>();
    /**
     * Holds player information,including a Hashtable of stats 
     * and the player's name.
     */
    public Participant(){
        //zero out values in the table
        //maybe not needed, but just to be safe
        stats.put("WIS", 0);
        stats.put("INT", 0);
        stats.put("DEX", 0);
        stats.put("CON", 0);
        stats.put("STR", 0);
        stats.put("CHA", 0);
        stats.put("SNEAK", 0);
    }
    /**
     * Replaces stored name with new input.
     * @param name The player's name
     */
    public void setName(String name){this.name=name;}
    /**
     * @return player's name
     */
    public String getName(){return name;}
    /**
     * Adds a stat to the Hashtable containing stats.
     * @param stat name of stat to be added
     * @param value value of stat to be added
     */
    public void setStat(String stat, int value){stats.put(stat, value);}
    /**
     * Gets the value of a stat from the table.
     * @param stat name of stat to return
     * @return value corresponding with the Hashtable entry for given stat.
     */
    public int getStat(String stat){return stats.get(stat);}
    
    /**
     * Stores the player's gender for logging.
     * Replaces stored gender with new input.
     * @param gender The player's gender
     */
    public void setGender(String gender){this.gender=gender;}
    /**
     * Returns the current player's specified gender
     * @return player's gender
     */
    public String getGender(){return gender;}
}
