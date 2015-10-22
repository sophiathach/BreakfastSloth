package sloth.adventure;

public class ShortAnswer extends Question{
     /**
     * Creates a short answer question.
     * Derives from the Question class.
     * @param statName name of the stat this question relates to
     */
   public ShortAnswer(String statName){super(statName);}
   
    /**
     * Checks user input, makes sure it falls within valid range of input.
     * @return true if input is valid, false if input is invalid(falls outside applicable range of values)
     */ 
   @Override
    public boolean validateAnswer(){
        String userAnswer=getAnswer();
        if(!userAnswer.equals(""))
            return true;
        else
            return false;
    }
}
