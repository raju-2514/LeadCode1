package August;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequence {
    public static List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> freq=new HashMap<>();
        for(int i=0;i<s.length()-9;i++){
            String dna=s.substring(i,i+10);
            freq.put(dna,freq.getOrDefault(dna,0)+1);
        }

        List<String> list=new ArrayList<>();
        for(Map.Entry<String,Integer> e:freq.entrySet()){
            if(e.getValue()>1){
                list.add(e.getKey());

            }
        }
        return list;
    }

    public static void main(String[] args) {
       String s="AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(findRepeatedDnaSequences(s));
    }
}
