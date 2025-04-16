package April;

import java.util.ArrayList;
import java.util.List;

public class Restore_IP_Address {
    public List<String> restoreIpAddresses(String s){
      List<String> result=new ArrayList<>();
      backtrack(s,0,new ArrayList<>(),result);
      return result;
    }

    public void backtrack(String s,int start,List<String> path,List<String> result){
        if(path.size()==4){
            if(start==s.length()){
                result.add(String.join(".", path));
            }
            return;
        }

        for(int len=1;len<=3;len++){
            if(start+len>s.length()){
                break;
            }
            String part=s.substring(start,start+len);
            if(part.startsWith("0") && part.length()>1 || Integer.parseInt(part)>255 ){
                continue;
            }

            path.add(part); // Choose
            backtrack(s, start + len, path, result); // Explore
            path.remove(path.size() - 1); // Un-choose
        }
    }

    public static void main(String[] args) {
        Restore_IP_Address solver = new Restore_IP_Address();
        String s = "25525511135";
        List<String> result = solver.restoreIpAddresses(s);
        System.out.println(result);

        s = "0000";
        System.out.println(solver.restoreIpAddresses(s));

        s = "101023";
        System.out.println(solver.restoreIpAddresses(s));
    }
}
