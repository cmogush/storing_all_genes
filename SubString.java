import java.io.*;

public class SubString {
    public void printString(){
    String s = "dukeprogramming";
    String x = s.substring(4,7);
    int l = s.length();
    int i = s.indexOf("program");
    int startFrom = s.indexOf("g",9); //starts looking from index pos 9
    boolean startsWith = s.startsWith("duke"); //returns true or false
    boolean endsWith = s.endsWith("king"); //returns true or false
    int first = s.indexOf("g");
    int last = s.lastIndexOf("g");
    System.out.println(first);
    System.out.println(last);
}
}
