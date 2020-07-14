public class FindGeneSimpleTest {
    public String findGeneSimple(String dna){
        //convert to uppercase
        String upDna = dna.toUpperCase();
        
        String gene = "";
        
        //checks to make sure there is a gene
        int startIndex = upDna.indexOf("ATG");
        if (startIndex == -1) { // no ATG
        return "n/a";
    }
        String stopCodon = findStopCodon(upDna, startIndex);
        int stopIndex = upDna.indexOf(stopCodon, startIndex + 3);  
        if (stopIndex == -1) { // no end codon
        return "n/a";
    }
        gene = dna.substring(startIndex , stopIndex + 3);
        
        int currIndex = startIndex + 3;
        //checks to make sure the gene is divisible by 3
        while (gene.length() % 3 > 0){ //only does loop if gene not yet found
            stopCodon = findStopCodon(upDna, currIndex);
            currIndex = upDna.indexOf(stopCodon,currIndex + 1);
            gene = dna.substring(startIndex, currIndex + 3);
            if (currIndex == -1){
                return "n/a";
            }
        }
        
        return gene;
        
}
   public void simpleTest(String dna){
        //String dna = "ATAATGAACCAACCTAACCGAG";
        //String dna = "TAATAA";
        System.out.println("DNA strand is: " + dna);
        
     String check = "ok";
    int geneCount = 0;
   // do this while there are still genes to be found
     while (check == "ok"){
        String gene = findGeneSimple(dna);
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
       String upDna = dna.toUpperCase();   
        String gene = "";
        //checks to make sure there is a gene
        int startIndex = upDna.indexOf("ATG");
        if (startIndex == -1) { // no ATG
        return "stop";
    }
        String stopCodon = findStopCodon(upDna, startIndex);
        int stopIndex = upDna.indexOf(stopCodon, startIndex + 3);  
        if (stopIndex == -1) { // no end codon
        return "stop";
    }
    return "ok";
}
        
    public String findStopCodon(String upDna, int startIndex){
        int TAA = upDna.indexOf("TAA", startIndex + 3);
        int TAG = upDna.indexOf("TAG", startIndex + 3);
        int TGA = upDna.indexOf("TGA", startIndex + 3);
        int newTAA = checkIndex(TAA, TAG, TGA);
        int newTAG = checkIndex(TAG, TAA, TGA);
        int newTGA = checkIndex(TGA, TAA, TAG);
      
        //compare 3 variables
        
        if (newTAA < newTAG && newTAA < newTGA){
            System.out.println(TAA);
            System.out.println("TAA");
            return "TAA";
        }
        if (newTAG < newTGA && newTAG < newTAA){
            System.out.println(TAG);
            System.out.println("TAG");
            return "TAG";
        }
        if (newTGA < newTAA && newTGA < newTAG){
        System.out.println(TGA);
        System.out.println("TGA");
        return "TGA";
        }
        System.out.println("no stop codon found");
        return "no stop codon found";    
    }
    
    public int checkIndex(int index1, int index2, int index3){
    if(index1 == -1){
        index1 = index1 + index2 + index3;
    }
    return index1;
    }
    
    public void multiTest(){
       //String dna1 = "ACAACCATGAAACAATAAGGAAAACCAACCAATGAAATTAAATTTAA";
       //simpleTest(dna1);
       //String dna2 = "ACAACAACACAACAATAATGAACAACTAAGGAAACAATGAATACAGAATAAGCATAAGACAA";
       //simpleTest(dna2);
       ////String dna3 = "aaattaatgcacgaataacccatgaaacactaaccaatgcaacaataagaa";
       //simpleTest(dna3);
       String dna4 = "aaTGAAgaTAAaagATAACTAaATGaacTAA";
       simpleTest(dna4);
       String dna5 = "aTGAaaTAGTAATGAactaa";
       simpleTest(dna5);
    }
}

