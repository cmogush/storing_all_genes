
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public boolean twoOccurrences(String stringa, String stringb){
    //return true if stringa appears twice in string b
    int indexFirst = stringb.indexOf(stringa);
    int lengthStringA = stringa.length();
    int lengthStringB = stringb.length();
    String subB = stringb.substring(indexFirst + lengthStringA, lengthStringB);
    int indexSecond = subB.indexOf(stringa);
    System.out.println(subB);
    System.out.println(indexSecond);
        if (indexSecond == -1){
            return false;
        }
        return true;
    }
    
    public void testCase(){
    String stringa = "a";
    String stringb = "banana";
    if(twoOccurrences(stringa, stringb)){
    System.out.println(stringa + " occurs at least twice in the string: " + stringb);
    }
    else{
    System.out.println(stringa + " does not occur twice in the string: " + stringb);
    }
    }
}
