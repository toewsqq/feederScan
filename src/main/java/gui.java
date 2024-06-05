import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class gui {
    public static void main(String[] args) {



        JFrame frame = new JFrame("Feeder scan Beta version");
        // Setting the width and height of framez
        frame.setSize(650, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        // adding panel to frame
        frame.add(panel);

        placeComponents(panel);

        // Setting the frame visibility to true
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);

        JLabel moLabel = new JLabel("MO");

        moLabel.setBounds(10, 20, 80, 25);
        panel.add(moLabel);

        JLabel part = new JLabel("PART");

        part.setBounds(10, 80, 80, 25);
        panel.add(part);

        JLabel status = new JLabel("Machine");

        status.setBounds(10, 180, 80, 25);
        panel.add(status);

        JLabel side = new JLabel("SIDE");

        side.setBounds(10, 250, 80, 25);
        panel.add(side);

        JLabel position = new JLabel("Position");

        position.setBounds(10, 320, 110, 25);
        panel.add(position);

        JTextField userTextPart = new JTextField(20);
        userTextPart.setBounds(100, 80, 165, 25);
        panel.add(userTextPart);

        JTextField userTextMachine = new JTextField(20);
        userTextMachine.setBounds(100, 180, 165, 55);
        userTextMachine.setFont(new Font("Arial", Font.PLAIN, 28));
        panel.add(userTextMachine);

        JTextField userTextSide = new JTextField(20);
        userTextSide.setBounds(100, 250, 65, 55);
        userTextSide.setFont(new Font("Arial", Font.PLAIN, 28));
        panel.add(userTextSide);

        JTextField userTextPosition = new JTextField(20);
        userTextPosition.setBounds(100, 320, 65, 55);
        userTextPosition.setFont(new Font("Arial", Font.PLAIN, 28));
        panel.add(userTextPosition);

        JTextField userText5 = new JTextField(20);
        userText5.setBounds(100, 20, 80, 25);
        panel.add(userText5);

        JButton unlockButton = new JButton("RESET");
        unlockButton.setBounds(100, 45, 80, 25);
        panel.add(unlockButton);
        //setBounds(10, 80, 80, 25);

        JButton bButton = new JButton("B");
        bButton.setBounds(195, 30, 55, 35);
        panel.add(bButton);

        JButton tButton = new JButton("T");
        tButton.setBounds(250, 30, 55, 35);
        panel.add(tButton);

        userTextPart.setEnabled(false);
        userTextMachine.setVisible(false);
        userTextSide.setVisible(false);
        userTextPosition.setVisible(false);
        userTextPart.setVisible(false);
        //JButton button = new JButton("Show");
        userTextPart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = userTextPart.getText();
                String[] inputText = input.split("-");
                input = inputText[0];
                String[] array = new Result().result(input,userText5.getText());
               // BomEditor bomResult = new BomResult().bomEditor(bomName);
                String machine = array[0];
                String side = array[1];
                String position = array[2];
                userTextMachine.setText(machine);
                userTextSide.setText(side);
                userTextPosition.setText(position);
                userTextPart.setText("");

            }
        });



        // Clear Button ActionListener
        userText5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userText5.setEnabled(false);
                userText5.setDisabledTextColor(Color.BLUE);
                userTextPart.setVisible(true);
                userTextPart.setEnabled(true);
                userTextMachine.setVisible(true);
                userTextSide.setVisible(true);
                userTextPosition.setVisible(true);
                userTextPart.requestFocus();
            }
        });


        // Unlock Button ActionListener
        unlockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userText5.setEnabled(true); // Enable the text field
                userText5.setText("");
                userTextPart.setEnabled(false);
                userTextMachine.setVisible(false);
                userTextSide.setVisible(false);
                userTextPosition.setVisible(false);
                userText5.requestFocus();
            }
        });


        bButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userText5.setText(changeLastCharToB(userText5.getText()));
                userTextPart.requestFocus();
            }
        });
        tButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userText5.setText(changeLastCharToT(userText5.getText()));
                userTextPart.requestFocus();
            }
        });

    }

    //metodes
    public static String changeLastCharToB(String s) {
        if (s == null || s.length() == 0) {
            return s;  // If the string is null or empty, return it as is
        }
        char lastChar = s.charAt(s.length() - 1);
        if (Character.isDigit(lastChar)) {
            return s + 'B';
        }
        else if (lastChar == 'T'){
            return s.substring(0, s.length() - 1) + 'B';
        }
        return s;
    }

    public static String changeLastCharToT(String s) {
        if (s == null || s.length() == 0) {
            return s;  // If the string is null or empty, return it as is
        }
        char lastChar = s.charAt(s.length() - 1);
        if (Character.isDigit(lastChar)) {
            return s + 'T';
        }
        else if (lastChar == 'B'){
            return s.substring(0, s.length() - 1) + 'T';
        }
        return s;
        //return s .substring(0, s.length() - 1) + 'B';
    }
}





