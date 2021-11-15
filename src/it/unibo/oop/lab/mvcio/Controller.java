package it.unibo.oop.lab.mvcio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;


/**
 * 
 */
public class Controller {

    private static final String PATH = System.getProperty("user.home")
            + System.getProperty("file.separator") + "output.txt";
    private File file = new File(PATH);
    /*
     * This class must implement a simple controller responsible of I/O access. It
     * considers a single file at a time, and it is able to serialize objects in it.
     * 
     * Implement this class with:
     */
    /**
     *  @param f A method for setting a File as current file
     */
    public void setCurrFile(final File f) {
        this.file = f;
    }
     /**
      *  @return A method for getting the current File
     */
    public File getCurrFile() {
        return this.file;
    }
     /**
      *  @return A method for getting the path (in form of String) of the current File
     */
    public String getCurrFilePath() {
        return getCurrFile().getPath();
    }
     /**
      *  @param s A method that gets a String as input and saves its content on the current
     * file. This method may throw an IOException.
     */
    public void writeOnFile(final String s) {
        try (PrintStream ps = new PrintStream(file)) {
            ps.print(s);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.toString());
            e.printStackTrace();
        }
    }
     /* 5) By default, the current file is "output.txt" inside the user home folder.
     * A String representing the local user home folder can be accessed using
     * System.getProperty("user.home"). The separator symbol (/ on *nix, \ on
     * Windows) can be obtained as String through the method
     * System.getProperty("file.separator"). The combined use of those methods leads
     * to a software that runs correctly on every platform.
     */
}
