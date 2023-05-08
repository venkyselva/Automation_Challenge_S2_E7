
import java.util.*;

import javax.swing.JOptionPane;
 
class Node {
    public int data;
    public List<Node> children;
    public Node(int val) { data = val; children = new ArrayList<Node>(); }
   
}
 
public class Main {
	 public static String val1="";
    public static String dfs(Node root, Map<String, Integer> f) {
        // Base condition
        if (root == null) return "";
        String s = "(" + Integer.toString(root.data);
        // Dfs call for all children
        for (Node child : root.children) {
            s += dfs(child, f);
        }
        s += ')';
        f.put(s, f.getOrDefault(s, 0) + 1);
        return s;
    }
 
    public static int duplicateSubtreeNaryTree(Node root) {
        Map<String, Integer> f = new HashMap<>();
        dfs(root, f);
        int ans = 0;
        for (Map.Entry<String, Integer> entry : f.entrySet()) {
        	System.out.println("Value"+entry.getValue());
        	System.out.println("Key"+entry.getKey());
        	
        	
            if (entry.getValue() > 1) 
            	{
            	if(!val1.contains(entry.getKey()))
            	{
            	val1 = val1+" "+entry.getKey();
            	}
            	ans++;
            	}
        }
        return ans;
    }
 
    public static void main(String[] args) 
    {
    	 String value = "1 N 2 2 3 N 4 N 4 4 3 N N N N N";
    	 String value1 = "1 N 2 3 N 4 5 6 N N N";
         
         value = value.replace(" ", "");
         
         int valstr = Integer.parseInt(String.valueOf(value.charAt(0))); 
         Node root = new Node(valstr);
         int N_interation = 0;
         int length = value.length();
         int tempvalue = 0;
         for(int a=0; a<length; a++)
         {
      	   char strchar = value.charAt(a);
      	   
      	   if(a!=0)
      	   {
      		   int bb = a-1;
      		   char strchar1 = value.charAt(bb);
      		   System.out.println("trset value char"+strchar1);
      	   if(strchar == 'N' && strchar1!='N')
      	   {
      		   N_interation = N_interation+1;
      	   }
      	   else
      	   {
      		   if(strchar!='N')
      		   {
      		   tempvalue = Integer.parseInt(String.valueOf(strchar)); 
      		   }
      	   }
      	   }
      	   
      	   if(strchar!='N')
      	   {
      	   if(N_interation==1)
      	   {
      		   root.children.add(new Node(tempvalue));
      	   }
      	   else if(N_interation ==2 )
      	   {
      		   root.children.get(0).children.add(new Node(tempvalue));
      		   
      	   }
      	   else if(N_interation ==3)
      	   {
      		   root.children.get(1).children.add(new Node(tempvalue));
      	   }
      	   else if(N_interation ==3)
      	   {
      		   root.children.get(2).children.add(new Node(tempvalue));
      	   }
      	   }
         }
         
	        System.out.println(duplicateSubtreeNaryTree(root));
	        
	        int valresult = duplicateSubtreeNaryTree(root);
	        String valueprint;
	        String strkey;
	        if(val1=="")
	        {
	        	valueprint = "Output: "+"0";
	        	strkey = "No Duplicate subtree found";
	        }
	        else
	        {
	         valueprint = "Output: "+valresult;
	         strkey = "Duplicate Subtree: "+ val1;
	        }
	        System.out.println(valueprint);
	        System.out.println(strkey);
	        
	        JOptionPane.showMessageDialog(null, valueprint+"\n"+ strkey );

	    }

    }
