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

        moLabel.setBounds(45, 20, 80, 25);
        moLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(moLabel);

        JLabel part = new JLabel("PART");

        part.setBounds(45, 80, 80, 25);
        part.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(part);

        JLabel machine = new JLabel("Machine");

        machine.setBounds(45, 180, 120, 45);
        machine.setFont(new Font("Arial", Font.BOLD, 28));
        panel.add(machine);

        JLabel side = new JLabel("SIDE");

        side.setBounds(45, 250, 80, 45);
        side.setFont(new Font("Arial", Font.BOLD, 28));
        panel.add(side);

        JLabel position = new JLabel("Position");

        position.setBounds(45, 320, 110, 45);
        position.setFont(new Font("Arial", Font.BOLD, 28));
        panel.add(position);

        JTextField userTextPart = new JTextField(20);
        userTextPart.setBounds(100, 80, 165, 25);
        panel.add(userTextPart);

        JTextField userTextMachineAimexII = new JTextField(20);
        userTextMachineAimexII.setBounds(200, 180, 165, 65);
        userTextMachineAimexII.setFont(new Font("Arial", Font.BOLD, 38));
        userTextMachineAimexII.setEditable(false);
        userTextMachineAimexII.setBackground(Color.white);
        panel.add(userTextMachineAimexII);

        JTextField userTextSideAimexII = new JTextField(20);
        userTextSideAimexII.setBounds(200, 250, 65, 65);
        userTextSideAimexII.setFont(new Font("Arial", Font.BOLD, 38));
        userTextSideAimexII.setEditable(false);
        userTextSideAimexII.setBackground(Color.white);
        panel.add(userTextSideAimexII);

        JTextField userTextPositionAimexII = new JTextField(20);
        userTextPositionAimexII.setBounds(200, 320, 65, 65);
        userTextPositionAimexII.setFont(new Font("Arial", Font.BOLD, 38));
        userTextPositionAimexII.setEditable(false);
        userTextPositionAimexII.setBackground(Color.white);
        panel.add(userTextPositionAimexII);

        JTextField userTextMachineAimexIII = new JTextField(20);
        userTextMachineAimexIII.setBounds(400, 180, 165, 65);
        userTextMachineAimexIII.setFont(new Font("Arial", Font.BOLD, 38));
        userTextMachineAimexIII.setEditable(false);
        userTextMachineAimexIII.setBackground(Color.white);
        panel.add(userTextMachineAimexIII);

        JTextField userTextSideAimexIII = new JTextField(20);
        userTextSideAimexIII.setBounds(400, 250, 65, 65);
        userTextSideAimexIII.setFont(new Font("Arial", Font.BOLD, 38));
        userTextSideAimexIII.setEditable(false);
        userTextSideAimexIII.setBackground(Color.white);
        panel.add(userTextSideAimexIII);

        JTextField userTextPositionAimexIII = new JTextField(20);
        userTextPositionAimexIII.setBounds(400, 320, 65, 65);
        userTextPositionAimexIII.setFont(new Font("Arial", Font.BOLD, 38));
        userTextPositionAimexIII.setEditable(false);
        userTextPositionAimexIII.setBackground(Color.white);
        panel.add(userTextPositionAimexIII);

        JTextField userText5 = new JTextField(20);
        userText5.setBounds(100, 20, 80, 25);
        panel.add(userText5);

        JButton resetButton = new JButton("RESET");
        resetButton.setBounds(100, 45, 80, 25);
        panel.add(resetButton);
        //setBounds(10, 80, 80, 25);

        JButton bButton = new JButton("B");
        bButton.setBounds(195, 30, 55, 35);
        panel.add(bButton);

        JButton tButton = new JButton("T");
        tButton.setBounds(250, 30, 55, 35);
        panel.add(tButton);

        userTextPart.setEnabled(false);
        userTextMachineAimexII.setVisible(false);
        userTextSideAimexII.setVisible(false);
        userTextPositionAimexII.setVisible(false);
        userTextMachineAimexIII.setVisible(false);
        userTextSideAimexIII.setVisible(false);
        userTextPositionAimexIII.setVisible(false);
        userTextPart.setVisible(false);
        bButton.setEnabled(false);
        tButton.setEnabled(false);

        //JButton button = new JButton("Show");
        userTextPart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = userTextPart.getText();
                String[] inputText = input.split("-");
                input = inputText[0];
                String[] array = new Result().result(input,userText5.getText());
                String side = array[1];
                String position = array[2];
                String machine = array[0];
                if(machine == "Aimex 2") {
                    userTextMachineAimexII.setText(machine);
                    userTextSideAimexII.setText(side);
                    userTextPositionAimexII.setText(position);
                    userTextPart.setText("");
                    userTextMachineAimexIII.setText("");
                    userTextSideAimexIII.setText("");
                    userTextPositionAimexIII.setText("");
                }
                else if(machine == "Aimex 3"){
                        userTextMachineAimexIII.setText(machine);
                        userTextSideAimexIII.setText(side);
                        userTextPositionAimexIII.setText(position);
                        userTextPart.setText("");
                        userTextMachineAimexII.setText("");
                        userTextSideAimexII.setText("");
                        userTextPositionAimexII.setText("");

                }
                else{
                    userTextMachineAimexII.setText("");
                    userTextSideAimexII.setText("");
                    userTextPositionAimexII.setText("");
                    userTextMachineAimexIII.setText("");
                    userTextSideAimexIII.setText("");
                    userTextPositionAimexIII.setText("");
                }


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
                userTextMachineAimexII.setVisible(true);
                userTextSideAimexII.setVisible(true);
                userTextPositionAimexII.setVisible(true);
                userTextMachineAimexIII.setVisible(true);
                userTextSideAimexIII.setVisible(true);
                userTextPositionAimexIII.setVisible(true);
                bButton.setEnabled(true);
                tButton.setEnabled(true);
                userTextPart.requestFocus();
            }
        });


        // Unlock Button ActionListener
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userText5.setEnabled(true); // Enable the text field
                userText5.setText("");
                userTextPart.setEnabled(false);
                userTextMachineAimexII.setVisible(false);
                userTextSideAimexII.setVisible(false);
                userTextPositionAimexII.setVisible(false);
                bButton.setEnabled(false);
                tButton.setEnabled(false);
                userTextMachineAimexIII.setVisible(false);
                userTextSideAimexIII.setVisible(false);
                userTextPositionAimexIII.setVisible(false);
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





