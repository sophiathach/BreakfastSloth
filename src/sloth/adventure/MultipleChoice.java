package sloth.adventure;

import java.io.IOException;

public class MultipleChoice extends Question{
    private String[] possibleAnswers = new String[4];
    /**
     * Creates a multiple choice question.
     * Derives from the Question class.
     * @param statName name of the stat this question relates to
     */
    public MultipleChoice(String statName){super(statName);}
    
    /**
     * Gets the question relevant to the current stat. 
     * @return a string containing the question and answers to be selected from.
     * @throws java.io.IOException
     */
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
           //also addes on the four possible answers since this is a multiple choice question
            currentQuestion = strArr[2] + "\n\t" + strArr[3] + "\n\t" + strArr[4]+ "\n\t" + strArr[5] + "\n\t"+ strArr[6];
            
            //stores the multiple answers to get the values from later
            possibleAnswers[0] = strArr[3];
            possibleAnswers[1] = strArr[4];
            possibleAnswers[2] = strArr[5];
            possibleAnswers[3] = strArr[6];
            
            inputFile.close();
            return currentQuestion;
       }
       
       else{
           inputFile.close();
           return "Stat not found in file.";
       }
    }
    
     /**
     * Grabs the stat name and value from the possible answers in a multiple choice question
     */
    public void setStatValue(){
        int indexVal,x;
        String[] strArr;
        switch (userAnswer) {
            case "b":
                indexVal = 1;
                break;
            case "c":
                indexVal = 2;
                break;
            case "d":
                indexVal = 3;
                break;
            case "a":
            default:
                indexVal = 0;
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
            else{ //should not be the case ever
                //did not have a value to change, so just set this to -999 to indicate that this question did not modify a value
                this.statValue = -999;
            }
        } 
        
    }
    
    /**
     * Checks user input, makes sure it falls within valid range of input.
     * @return true if input is valid, false if input is invalid(falls outside applicable range of values)
     */
    @Override
    public boolean validateAnswer(){
        String userAnswer=getAnswer().toLowerCase();
        if(userAnswer.equals("a")||userAnswer.equals("b")||userAnswer.equals("c")||userAnswer.equals("d")){
            setStatValue();
            return true;
        }
        else
            return false;
    }
}
