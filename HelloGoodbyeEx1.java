import javax.swing.*;
import java.awt.*;

public class HelloGoodbyeEx1 {

    public static void main(String args[]) {
        JFrame f = new JFrame();
        f.setTitle("Hello/Goodbye Ex1");

        JLabel label = new JLabel("Hello");
        JButton button = new JButton("Click me!");

        //add event listener for the button
        button.addActionListener(new ButtonClickListenerEx1(label));
        
        f.add(button, BorderLayout.SOUTH);
        f.add(label, BorderLayout.NORTH);

        f.pack();
        f.setVisible(true);
        
    }

}