package sloth.adventure;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public abstract class Question {
   protected String currentQuestion;
   protected String userAnswer;
   protected String statName;
   protected int statValue;
   protected BufferedReader inputFile;
   
   /**
    * Base class for question types. Abstract.
    * @param statName name of the stat this question refers to
    */
   public Question(String statName){
       this.statName=statName;
       try{
       inputFile = new BufferedReader(new FileReader("Questions.txt"));
       }
       catch(IOException err){}
   }
   
    /**
     * Checks user input, makes sure it falls within valid range of input.
     * @return true if input is valid, false if input is invalid(falls outside applicable range of values)
     */
   abstract public boolean validateAnswer();
   /**
    * @return name of stat this question refers to.
    */
   public String getStatName(){return statName;}
   
   /**
    * Sets the stat name
    * @param statName
    */
   public void setStatName(String statName){this.statName = statName;}
   
   /**
    * Reads from file containing questions, chooses correct section of text based
    * on stat this question deals with.
    * @return a string of the question to display to the user
    * @throws java.io.IOException
    */
   public String getQuestion() throws IOException{
       //go through file looking for stat
       //return question
       
       String currLine;
       String[] strArr;
       int x;
       
       currLine = inputFile.readLine();
       strArr = currLine.split(":");
       if(strArr.length > 0){
           //loop through file looking for stat
            while(!strArr[1].equals(this.statName)){
                strArr = currLine.split(":");
                currLine = inputFile.readLine();
            }
           
           inputFile.close();
           //found stat, get question from line
            currentQuestion = strArr[2];
            return currentQuestion;
       }
       
       else{
           inputFile.close();
           return "Stat not found in file.";
       }
   }
   
   /**
    * Gets user input, sets it as this question's answer.
     * @param ans
    */
   public void setAnswer(String ans){this.userAnswer=ans;}//Need UI to implement
   

   
   /**
    * @return stored answer to this question.
    */
   public String getAnswer(){return userAnswer;}
   /**
    * @return the current value of the stat this question deals with.
    */
   public int getStatValue(){return statValue;}
   
}
