import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonClickListenerEx1 implements ActionListener {

    private JLabel label;
    
    public ButtonClickListenerEx1(JLabel label) {
        this.label = label; //save the label to modify
    }


    public void actionPerformed(ActionEvent e) {
        if (label.getText().equals("Hello")) {
            label.setText("Goodbye"); //flip text back and forth
        }else{
            label.setText("Hello");
        }
    }
}