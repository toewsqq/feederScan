import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;


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

        JLabel jobNameLabel = new JLabel("PART");

        jobNameLabel.setBounds(10, 80, 80, 25);
        panel.add(jobNameLabel);

        JLabel status = new JLabel("Module");

        status.setBounds(10, 180, 80, 25);
        panel.add(status);

        JLabel side = new JLabel("SIDE");

        side.setBounds(10, 250, 80, 25);
        panel.add(side);

        JLabel position = new JLabel("Position");

        position.setBounds(10, 320, 110, 25);
        panel.add(position);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 80, 165, 25);
        panel.add(userText);

        JTextField userText2 = new JTextField(20);
        userText2.setBounds(100, 180, 165, 55);
        userText2.setFont(new Font("Arial", Font.PLAIN, 28));
        panel.add(userText2);

        JTextField userText3 = new JTextField(20);
        userText3.setBounds(100, 250, 65, 55);
        userText3.setFont(new Font("Arial", Font.PLAIN, 28));
        panel.add(userText3);

        JTextField userText4 = new JTextField(20);
        userText4.setBounds(100, 320, 65, 55);
        userText4.setFont(new Font("Arial", Font.PLAIN, 28));
        panel.add(userText4);

        JTextField userText5 = new JTextField(20);
        userText5.setBounds(100, 20, 365, 25);
        panel.add(userText5);

        //JButton button = new JButton("Show");
        userText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = userText.getText();
                String[] inputText = input.split("-");
                input = inputText[0];
                String[] array = new Result().result(input,userText5.getText());
               // BomEditor bomResult = new BomResult().bomEditor(bomName);
                String machine = array[0];
                String side = array[1];
                String position = array[2];
                userText2.setText(machine);
                userText3.setText(side);
                userText4.setText(position);
                userText.setText("");

            }
        });



        // Clear Button ActionListener
        userText5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userText5.setEnabled(false);
                userText.requestFocus();
            }
        });

        // Unlock Button
        JButton unlockButton = new JButton("Unlock");
        unlockButton.setBounds(500, 20, 80, 25);
        panel.add(unlockButton);
        //setBounds(10, 80, 80, 25);

        JButton bButton = new JButton("B");
        bButton.setBounds(300, 80, 55, 35);
        panel.add(bButton);

        JButton tButton = new JButton("T");
        tButton.setBounds(400, 80, 55, 35);
        panel.add(tButton);
        // Unlock Button ActionListener
        unlockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userText5.setEnabled(true); // Enable the text field
                userText5.setText("");
            }
        });



        bButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userText5.setText(changeLastCharToB(userText5.getText()));
            }
        });
        tButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userText5.setText(changeLastCharToT(userText5.getText()));
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





