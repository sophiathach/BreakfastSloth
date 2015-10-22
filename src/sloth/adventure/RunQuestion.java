package sloth.adventure;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class RunQuestion implements Runnable{
    
    Question x;
    Participant p;
    RunQuestion(Question x, Participant p){
        
    this.x=x;
    this.p=p;
    }
    @Override
    public void run() {
        SlothAdventureGUI n=new SlothAdventureGUI();
        try {
            n.createLayout(x,p);
        } catch (IOException ex) {
            Logger.getLogger(RunQuestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        n.setVisible(true);
        
    }
}