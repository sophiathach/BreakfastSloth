
package sloth.adventure;


public class Numerical extends Question{
    /**
     * Creates a numerical question.
     * Derives from the Question class.
     * @param statName name of the stat this question relates to
     */
    public Numerical(String statName){super(statName);}
    /**
     * Checks user input, makes sure it falls within valid range of input.
     * @return true if input is valid, false if input is invalid(falls outside applicable range of values)
     */
    @Override
    public boolean validateAnswer(){
        String userAnswer=getAnswer();
        //convert string to int. If that throws an error, return false, answer was not an integer. 
        //If conversion successful, compare int to valid range, return based on comparison.
        try{
        if(Integer.parseInt(userAnswer)<=5&&Integer.parseInt(userAnswer)>=0)
            return true;
        else
            return false;
        }catch(java.lang.NumberFormatException e){
            return false;
        }
    }
}
