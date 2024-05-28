import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//ICS6400-V22305-16

public class Result {
    public ArrayList createList(String name) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter the value to match: ");
//        String userInput = scanner.nextLine().trim();
//        String[] inputText = userInput.split("-");
//        userInput = inputText[0];
        String currentWorkingDir = System.getProperty("user.dir");
        String fileForEdit = currentWorkingDir + File.separator + name + ".txt";
        String machine = "Aimex 2";
        ArrayList<FeederScaner> feederScanerArrayList = new ArrayList<>();
        // Initialize BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader(fileForEdit))) {
            String line;
            // Read lines from the file until the end is reached
            while ((line = br.readLine()) != null) {
                // Print each line to the console
                String[] text = line.split(",");

                if (text.length > 6) {
                    FeederScaner feederScaner = new FeederScaner(machine, text[6], text[1], text[2], line);
                    feederScanerArrayList.add(feederScaner);
                    //System.out.println(line);


                }

                if (text.length > 1) {
                    if (text[1].trim().equals("\"AIMEXIII\"")) {
                        machine = "Aimex 3";
                    }

                }


            }
        } catch (IOException e) {
            // Handle potential IOException
            e.printStackTrace();
        }
        //System.out.println(feederScanerArrayList);

        return feederScanerArrayList;

    }
    public String[] result(String userInput, String name) {
        ArrayList<FeederScaner> feederScanerArrayList = new ArrayList(createList(name));
        String [] values = new String[3];
        for (FeederScaner feederScaner : feederScanerArrayList) {
            // System.out.println(feederScaner.getPart()); String substring = "welcome";
            String substring = userInput;
            //FeederScaner feederScaner = new FeederScaner(machine, text[6], text[1], text[2], line);
            if (feederScaner.getLine().contains(substring)) {
                values[0] = feederScaner.getMachine();
                values[1] = feederScaner.getSide();
                values[2] = feederScaner.getSlot();

//                System.out.println("part : " + substring + "\n"
//                        + "machine =  " + feederScaner.getMachine() + "\n"
//                        + "side = " + feederScaner.getSide() + "\n"
//                        + "slot = " + feederScaner.getSlot() + "\n");
//                System.out.println(feederScaner.getLine());

            }
        }
        return values;
    }

}
