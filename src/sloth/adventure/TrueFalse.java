package sloth.adventure;

import java.io.IOException;

public class TrueFalse extends Question{
    String[] possibleAnswers = new String[2];
     /**
     * Creates a True/False question.
     * Derives from the Question class.
     * @param statName name of the stat this question relates to
     */
    public TrueFalse(String statName){super(statName);}
    
    /**
     * Gets the question relevant to the current stat. 
     * @return a string containing the question and answers to be selected from.
     * @throws java.io.IOException
     */
    
        /**
     * Grabs the stat name and value from the possible answers in a multiple choice question
     */
    public void setStatValue(){
        int indexVal = 0;
        int x;
        String[] strArr;
        if(!userAnswer.equals("t")){
            indexVal = 1;
        }
        
        //look for ( in possibleAnswer[indexVal]
        //split it and set the stat name and value based on that
        for(x = 0; x < possibleAnswers[indexVal].length();x++){
            //look for (
            if (possibleAnswers[indexVal].charAt(x) == '('){
                strArr = possibleAnswers[indexVal].substring(x+1, possibleAnswers[indexVal].length()-1).split(",");
                this.statName = strArr[0];
                this.statValue = Integer.parseInt(strArr[1]);
                break;
            }
            else{
                //did not have a value to change, so just set this to -999 to indicate that this question did not modify a value
                this.statValue = -999;
            }
        }
        
        
    }
    
    
    @Override
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
           
           //found stat, get question from line
           //also addes on the two possible answers since this is a T/F question
            currentQuestion = strArr[2] + "\n\t" + strArr[3] + "\n\t"+ strArr[4];
            
            //stores answers for using later to determine the stat values(if any)
            possibleAnswers[0] = strArr[3];
            possibleAnswers[1] = strArr[4];
            return currentQuestion;
       }
       
       else{
           return "Stat not found in file.";
       }
    }
     /**
     * Checks user input, makes sure it falls within valid range of input.
     * @return true if input is valid, false if input is invalid(falls outside applicable range of values)
     */ 
    @Override
    public boolean validateAnswer(){
        String userAnswer=getAnswer();
        userAnswer=userAnswer.toLowerCase();
        if(userAnswer.equals("true")||userAnswer.equals("false")||userAnswer.equals("t")||userAnswer.equals("f")){
            setStatValue();
            return true;
        }
        else
            return false;
    }
}
