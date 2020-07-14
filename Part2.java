
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findGeneSimple(String dna, String startCodon, String stopCodon){
        //start codon is "ATG"
        //stop codon is "TAA"
        
        //convert to uppercase
        String upDna = dna.toUpperCase();
        
        String gene = "";
        int startIndex = upDna.indexOf("ATG");
        if (startIndex == -1) { // no ATG
        return "n/a";
    }
        int stopIndex = upDna.indexOf("TAA", startIndex + 3);  
        if (stopIndex == -1) { // no ATG
        return "n/a";
    }
        gene = dna.substring(startIndex , stopIndex + 3);
        
        if (gene.length() % 3 > 0){
            return "n/a";
        }
        
        return gene;
        
}
   public void simpleTest(String dna, String start, String stop){
        //String dna = "ATAATGAACCAACCTAACCGAG";
        //String dna = "TAATAA";
        System.out.println("DNA strand is: " + dna);
        
        String check = "ok";
        int geneCount = 0;
        //do this while there are still genes to be found
        while (check == "ok"){
        String gene = findGeneSimple(dna, start, stop);
        geneCount = geneCount + 1;
        System.out.println("Gene #" + geneCount + " is: " + gene);
        int newIndex = dna.indexOf(gene);
        int geneLength = gene.length();
        int dnaLength = dna.length();
        String newDna = dna.substring(newIndex + geneLength, dnaLength);
        check = checkToEnd(newDna);
        dna = newDna;
    }
    }
      
    public String checkToEnd(String dna){ //checks to see if there are additional genes
        String gene = "";
        String upDna = dna.toUpperCase();
        int startIndex = upDna.indexOf("ATG");
        if (startIndex == -1) { // no ATG
        return "stop";
    }
        int stopIndex = upDna.indexOf("TAA", startIndex + 3);  
        if (stopIndex == -1) { // no ATG
        return "stop";
    }
    
      gene = dna.substring(startIndex , stopIndex + 3);
      if ((gene.length()) % 3 > 0){
            return "stop";
        }
    
    return "ok";
    }
        
    public void multiTest(){
        String start = "ATG";
        String stop = "TAA";
        String dna1 = "ACAACCATGAAACAATAAGGAAAACCAACCAATGAAATTAAATTTAA";
        simpleTest(dna1, start, stop);
        String dna2 = "ACAACAACACAACAATAATGAACAACTAAGGAAACAATGAATACAGAATAAGCATAAGACAA";
        simpleTest(dna2, start, stop);
        String dna3 = "aaattaatgcacgaataacccatgaaacactaaccaatgcaacaataagaa";
        simpleTest(dna3, start, stop);
    }
    
    
}
