package sloth.adventure;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


public class SlothAdventure {

    private static String statName;
    protected static Participant p=new Participant();

    public static void main(String[] args) throws FileNotFoundException, IOException, NullPointerException, InterruptedException, InvocationTargetException {
        BufferedReader inputFile;
        inputFile = new BufferedReader(new FileReader("Questions.txt"));

        String currLine;
        String[] strArr=new String[7];
        
        //13 lines in the file
        for(int i=0; i<13;i++) {
            
            currLine = inputFile.readLine();
            strArr = currLine.split(":");

            String qType = strArr[0];
            Question currQuestion;

            switch (qType) {
                case "SA":
                    currQuestion = new ShortAnswer(strArr[1]);
                    EventQueue.invokeLater(new RunQuestion(currQuestion,p));
                    
                    break;
                case "MC":
                    currQuestion = new MultipleChoice(strArr[1]);
                        EventQueue.invokeLater(new RunQuestion(currQuestion, p));
                    
                    break;
                case "NE":
                    currQuestion = new Numerical(strArr[1]);
                EventQueue.invokeLater(new RunQuestion(currQuestion,p));
                    break;
                case "TF":
                    currQuestion = new TrueFalse(strArr[1]);
                    EventQueue.invokeLater(new RunQuestion(currQuestion,p));
                    break;

            }

        }
        inputFile.close();
    }

}


//story

//intro

//compare

//display

