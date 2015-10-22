package sloth.adventure;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SlothAdventureGUI extends JFrame {

    public SlothAdventureGUI() {
        initUI();
    }

    private void initUI() {

        setTitle("Sloth Adventure");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    //Create Swing components
    final JTextArea textArea = new JTextArea();

    final QuestionPanel questionPanel = new QuestionPanel();

    final JTextField input = new JTextField();
    final JButton button = new JButton("Next");
    final Container pane = getContentPane();

    public void createLayout(Question currQuestion, Participant p) throws IOException {

        BorderLayout g1 = new BorderLayout();
        pane.setLayout(g1);
        
        JTextArea text=new JTextArea(currQuestion.getQuestion());
        questionPanel.add(text);
        text.setEditable(false);
        //Add Swing components to the content pane
        final Container c = getContentPane();

        //this is where the questions will be displayed
        c.add(questionPanel, BorderLayout.NORTH);

        c.add(input, BorderLayout.CENTER);

        c.add(button, BorderLayout.SOUTH);

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                //finds the appropriate participant and 
                System.out.println(input.getText());

                dispose();
            }

        });


    }

}
