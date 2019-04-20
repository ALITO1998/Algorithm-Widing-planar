/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testalgo;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alial
 */
public class numtable {

    public static int num_table(ArrayList<String> V,HashMap<String,String[]> T){
        if (T == null){
            return V.size();
        }
        ArrayList<String> visited =new ArrayList<String>();
        int n = 0;
        for (String s : V){
            if(numtable.in(s, visited)){
                n+=1;
                visited.add(s);
                numtable.dfs_visit(s,T,visited);
            }else{
                continue;
            }
        }
        return n;
    }
    
    public static void dfs_visit(String u,HashMap<String,String[]> T,ArrayList<String> visited){
        for (String v : T.get(u)){
            if(in(v,visited)){
                visited.add(v);
                dfs_visit(v, T, visited);
            }
        }
    
    
    }
    
    public static boolean in (String s,ArrayList<String> V){
        for (int i = 0; i < V.size(); i++) {
            if( s ==V.get(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<String> V =new ArrayList<String>();
        V.add("a");
        V.add("b");
        V.add("c");
        V.add("x");
        V.add("y");
        V.add("z");
        HashMap<String, String[]> T=new HashMap<String, String[]>();
        String[] a ={"b","c"};
        T.put("a",a);
        String[] b ={"a"};
        T.put("b", b);
        String[] c ={"a"};
        T.put("c", c);
        String[] x ={"y","z"};
        T.put("x", x);
        String[] y ={"x"};
        T.put("y", y);
        String[] z ={"x"};
        T.put("z", z);
        
        int n = numtable.num_table(V,T);
        System.out.println(n);
    }
}
