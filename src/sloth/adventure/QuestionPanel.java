package sloth.adventure;


import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;



/**
 *
 * @author Sophia
 */
public class QuestionPanel extends JPanel{
    public QuestionPanel(){
    Dimension size= getPreferredSize();
    size.height=250;
    
    setPreferredSize(size);
    setBorder(BorderFactory.createTitledBorder("Question"));
    

    }
}
