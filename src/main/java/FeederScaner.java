import java.io.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.Iterator;

public class FeederScaner {


    //Scanner scanner = new Scanner(System.in);

    private String machine;
    private String part;
    private String side;
    private String slot;
    private String line;


    public FeederScaner() {
    }



    public FeederScaner(String machine, String part, String side, String slot, String line) {
        this.machine = machine;
        this.part = part;
        this.side = side;
        this.slot = slot;
        this.line = line;
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }
    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }
}



