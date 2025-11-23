import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EnigmaFrame extends JFrame {
    
    private JComboBox<Integer> inner;       // components
    private JComboBox<Integer> middle;      // components
    private JComboBox<Integer> outer;       // components
    private JTextField start;               // components
    private JTextArea inputArea;            // components
    private JTextArea outputArea;           // components
    private JButton encryptButton;          // components
    private JButton decryptButton;          // components
    
    public EnigmaFrame() {
        setTitle("Enigma Machine");         // title
        setSize(1920, 1080);                // size
        setLayout(new BorderLayout());      // border
        
        add(createSettings(), BorderLayout.NORTH);      // attatching "panels"
        add(createTextPanel(), BorderLayout.CENTER);    // attatching "panels"
        add(createButtonPanel(), BorderLayout.SOUTH);   // attatching "panels"
    }
    
    private JPanel createSettings() {       // assembling settings' "panel"
        JPanel panel = new JPanel();
        
        panel.add(new JLabel("Inner"));
        inner = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        panel.add(inner);
        
        panel.add(new JLabel("Middle"));
        middle = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        middle.setSelectedIndex(1);
        panel.add(middle);
        
        panel.add(new JLabel("Outer"));
        outer = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        outer.setSelectedIndex(2);
        panel.add(outer);
        
        panel.add(new JLabel("Start"));
        start = new JTextField("###", 5);
        panel.add(start);
        
        return panel;
    }
    
    private JPanel createTextPanel() {  // assembling text's "panel"
        JPanel panel = new JPanel(new GridLayout(1, 2));
        
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(new JLabel("Input"), BorderLayout.NORTH);
        inputArea = new JTextArea();
        inputPanel.add(new JScrollPane(inputArea), BorderLayout.CENTER);
        
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.add(new JLabel("Output"), BorderLayout.NORTH);
        outputArea = new JTextArea();
        outputPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);
        
        panel.add(inputPanel);
        panel.add(outputPanel);
        
        return panel;
    }
    
    private JPanel createButtonPanel() {    // button panel
        JPanel panel = new JPanel();
        
        encryptButton = new JButton("Encrypt");
        encryptButton.addActionListener(new ActionListener() {  // action listener
            public void actionPerformed(ActionEvent e) {
                process(true);
            }
        });
        
        decryptButton = new JButton("Decrypt");
        decryptButton.addActionListener(new ActionListener() {  // action listener
            public void actionPerformed(ActionEvent e) {
                process(false);
            }
        });
        
        panel.add(encryptButton);
        panel.add(decryptButton);
        
        return panel;
    }
    
    private void process(boolean encrypt) {     // process text
        int innerRotor = (Integer) inner.getSelectedItem();     // casting to int
        int middleRotor = (Integer) middle.getSelectedItem();   // casting to int
        int outerRotor = (Integer) outer.getSelectedItem();     // casting to int
        String startPosition = start.getText();
        String input = inputArea.getText();
        
        Enigma enigma = new Enigma(innerRotor, middleRotor, outerRotor, startPosition);
        String output = encrypt ? enigma.encrypt(input) : enigma.decrypt(input);
        outputArea.setText(output);
    }
}