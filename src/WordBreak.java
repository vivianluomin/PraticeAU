import com.sun.deploy.util.SyncAccess;

import java.util.*;

public class WordBreak {

    public ArrayList<String> wordBreak(String s, Set<String> dict) {

        return DFS(s,dict,new HashMap<String, ArrayList<String>>());
    }


    public ArrayList<String> DFS(String s, Set<String> dict,
                                 HashMap<String,ArrayList<String>> map){

        if(map.containsKey(s)){
            return map.get(s);
        }

        ArrayList<String> res= new ArrayList<>();
        if(s.length() == 0){
            res.add("");
            return res;
        }

        for(String start:dict){
            if(s.startsWith(start)){
                for(String ss:DFS(s.substring(start.length()),dict,map)){
                    res.add(start+(ss .equals("")? "":" ")+ss);
                }
            }
        }

        map.put(s,res);
        return res;

    }


    public boolean wordBreak2(String s,Set<String> dict){

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 0;i<s.length();i++){
            if(dp[i]){
                for(int j = i;j<s.length();j++){
                    if(dict.contains(s.substring(i,j+1))){
                        dp[j+1] = true;
                    }
                }
            }
        }

        return dp[s.length()];
    }

    public boolean ifCanBreak(String s,Set<String> dict){
        if(s.length()==0||s.equals("")){
            return true;
        }
        boolean canbreak = false;
        for(String start : dict){
            if(s.startsWith(start)){
                canbreak = ifCanBreak(s.substring(start.length()),dict);
                if(canbreak){
                    return canbreak;
                }
            }
        }

        return canbreak;
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Set<String> dict = new LinkedHashSet<>();
        in.nextLine();
        for(int i = 0;i<n;i++){
            String ss = in.nextLine();
            dict.add(ss);
        }
        String s = in.nextLine();


//        ArrayList<String>res = new WordBreak().wordBreak(s,dict);
//        for(String ss:res){
//            System.out.println(ss);
//        }

        System.out.println(new WordBreak().wordBreak2(s,dict));
    }
}
