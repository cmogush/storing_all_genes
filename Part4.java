import edu.duke.*;

public class Part4 {
    public void youtubeCheck(){
    URLResource youtube = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
    for (String word : youtube.words()){
        String lowercase = word.toLowerCase();
        int pos = lowercase.indexOf("youtube");
        if (pos != -1){
            int startPoint = word.lastIndexOf("\"", pos);
            int endPoint = word.indexOf("\"", pos + 1);
            String url = word.substring(startPoint + 1, endPoint);
            System.out.println(url);
        }
     }
}

}
