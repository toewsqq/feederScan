import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class gui {
    public static void main(String[] args) {
        // Path to the file
        //ArrayList result = new Result().createList();


//        String currentWorkingDir = System.getProperty("user.dir");
//        String export = currentWorkingDir + File.separator + "a.txt";
        //String s = "C:\\Users\\Janis\\Desktop\\BomEditor\\BomEditor\\b.exe";

//        try {
//
//            ProcessBuilder processBuilder = new ProcessBuilder(s);
//            processBuilder.directory(new File("C:\\Users\\Janis\\Desktop\\BomEditor\\BomEditor"));
//            processBuilder.redirectErrorStream(true); // Redirects error stream to the output stream
//            Process process = processBuilder.start(); // Start the process
//
//            // Read the output from the command
//            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
//
//            String output;
//            while ((output = stdInput.readLine()) != null) {
//                System.out.println(output);
//            }
//
//            int exitVal = process.waitFor(); // Wait for the process to complete
//            if (exitVal != 0) {
//                // Check for any exit status other than 0, indicating an abnormal termination
//                System.out.println("Process exited with error code " + exitVal);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//            Thread.currentThread().interrupt(); // Set the interrupt flag of the thread
//        }


//        String s = "C:\\Users\\Janis\\Desktop\\BomEditor\\b.exe";
//        Thread.sleep(1000);
//        ProcessBuilder processBuilder = new ProcessBuilder(s);
//
//        // Start the process
//        processBuilder.start();
//        Runtime runtime = Runtime.getRuntime();
//        Process pr = runtime.exec(s);


        //Process pr = runtime.exec("C:\\Program Files\\Electronic Arts\\EA Desktop\\EA Desktop\\EALauncher.exe");
        //Process pr = runtime.exec("C:\\Users\\Janis\\Desktop\\distr\\BOMexport2.1");
        //Process pr = runtime.exec("notepad.exe ");
        // Process pr = runtime.exec("notepad.exe " + export);


        JFrame frame = new JFrame("Feeder scan Beta version");
        // Setting the width and height of framez
        frame.setSize(550, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Creating panel. This is same as a div tag in HTML
         * We can create several panels and add them to specific
         * positions in a JFrame. Inside panels we can add text
         * fields, buttons and other components.
         */
        JPanel panel = new JPanel();
        // adding panel to frame
        frame.add(panel);
        /* calling user defined method for adding components
         * to the panel.
         */
        placeComponents(panel);

        // Setting the frame visibility to true
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);


        JLabel jobNameLabel = new JLabel("PART");

        jobNameLabel.setBounds(10, 20, 80, 25);
        panel.add(jobNameLabel);

        JLabel status = new JLabel("Module");

        status.setBounds(10, 80, 80, 25);
        panel.add(status);

        JLabel operations = new JLabel("Position");

        operations.setBounds(10, 120, 80, 25);
        panel.add(operations);

        JLabel smdOperations = new JLabel("SIDE");

        smdOperations.setBounds(10, 160, 110, 25);
        panel.add(smdOperations);

        JTextField userText = new JTextField(20);
        userText.setBounds(130, 20, 165, 25);
        panel.add(userText);

        JTextField userText2 = new JTextField(20);
        userText2.setBounds(130, 80, 365, 25);
        panel.add(userText2);

        JTextField userText3 = new JTextField(20);
        userText3.setBounds(130, 120, 365, 25);
        panel.add(userText3);

        JTextField userText4 = new JTextField(20);
        userText4.setBounds(130, 160, 365, 25);
        panel.add(userText4);

        JButton button = new JButton("Show");
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = userText.getText();
                //BomEditor bomEditor = new BomEditor(bomName);
                //ArrayList result= new Result().createList();
                String[] inputText = input.split("-");
                input = inputText[0];
                String[] array = new Result().result(input);
               // BomEditor bomResult = new BomResult().bomEditor(bomName);
                String machine = array[0];
                String side = array[1];
                String position = array[2];
                //String smdOperations = "asdad";
                userText2.setText(machine);
                userText3.setText(side);
                userText4.setText(position);
                userText.setText("");

            }
        };

        button.addActionListener(actionListener);
        userText.addActionListener(actionListener);
        button.setBounds(300, 20, 80, 25);
        panel.add(button);
    }
}





