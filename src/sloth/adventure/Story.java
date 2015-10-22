package sloth.adventure;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class Story {
  private Hashtable<String, Integer> requiredStat = new Hashtable();
  private Participant player;
  private String scenarioText; //added in because java is not pass-by-reference
  
  
  /**
   * Handles story generation, and manages questions
   * @param player player object to be used
   * @throws java.io.FileNotFoundException
   */
  public Story(Participant player) throws FileNotFoundException, IOException{
      this.player=player;
  }
  /**
   * Populates the requiredStat table from the "pass_conditions.txt" text file.
   * This is in a separate function to keep the constructor simple
   * @throws FileNotFoundException 
   */
  public void populateRequiredStats() throws FileNotFoundException, IOException{
      BufferedReader statsFile = new BufferedReader(new FileReader("pass_conditions.txt"));
      String currLine = statsFile.readLine();
      String[] strArr;
      
      while(currLine != null){
          strArr = currLine.split("=");
          requiredStat.put(strArr[0], Integer.parseInt(strArr[1]));
          currLine = statsFile.readLine();
      }
  }
  
  //test funciton to make sure requiredStats is populated
  public String viewRequiredStats(){
      return requiredStat.toString();
  }
  
  /**
   * Compares player's stored stat with the required stat
   * @param statName name of stat to compare
   * @return true if player stat is greater or equal to required, false if less.
   */
  public boolean compareStat(String statName){
      if(player.getStat(statName)>=requiredStat.get(statName))
          return true;
      else
          return false;
  }
  
  /**
   * Returns a string on the scenario's text to display the outcome of the stat check
   * @return a string of the text to display
   */
  public String getScenarioText(){return scenarioText;}
  
  /**
   * Gets the intro scenario text from the file
   * @param statName
   * @return a string of the intro text
   * @throws FileNotFoundException
   * @throws IOException 
   */
  public String introScenario(String statName) throws FileNotFoundException, IOException{
    BufferedReader introFile = new BufferedReader(new FileReader("intro_scenario.txt"));
    String currLine = introFile.readLine();
    String[] strArr;
    String builtString = "";
    int x;
    
    //scan file for statName
    while(currLine != null){
        strArr = currLine.split(":");
        if (strArr[0].equals(statName)){
            //found statName, build string to display to user
            for(x = 1 ; x < strArr.length ; x++){
                if (x != strArr.length-1)
                    builtString = builtString + strArr[x] + "\n";
                else{
                    builtString = builtString + strArr[x];
                    return builtString;
                }
            }
        }
        else
            //didn't find statName, continue to next
            currLine = introFile.readLine();
    }
    
    return "Stat not found in intro scenarios file.";
  }
  /**
   * Checks the stat to determine pass/fail for scenario and sets the string 'scenarioText' to the matching text
   * @param statName name of stat to pull scenario info from.
   * @return true/false depending on whether the check passed/failed
   * @throws java.io.FileNotFoundException
   */
  public boolean scenarioCheck(String statName) throws FileNotFoundException, IOException{
    BufferedReader scenarioFile;
    String currLine; 
    String[] strArr;
    int x;
    boolean passFail;
    
    if(compareStat(statName)){
        scenarioFile = new BufferedReader(new FileReader("win_scenario.txt"));
        passFail = true;
    }
    else{
        scenarioFile = new BufferedReader(new FileReader("fail_scenario.txt"));
        passFail = false;
    }
    
    currLine = scenarioFile.readLine();
        
    while(currLine != null){
        strArr = currLine.split(":");
        if(strArr[0].equals(statName)){
            for(x = 1 ; x < strArr.length ; x++){
                if (x != strArr.length-1)
                    scenarioText = scenarioText + strArr[x] + "\n";
                else{
                    scenarioText = scenarioText + strArr[x];
                }
            }
            break;
        }
        else{
            currLine = scenarioFile.readLine();
        }
    }
        
   return passFail; 
  }
}
