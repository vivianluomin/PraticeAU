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
                res.add(start);
                for(String ss:DFS(s.substring(start.length()),dict,map)){
                    res.add(start+(ss .equals("")? "":" ")+ss);
                }
            }
        }

        map.put(s,res);
        return res;

    }

}
