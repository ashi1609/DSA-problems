

package ques2b_ashi_sahu;

import static java.lang.Integer.min;

public class Add {
    public static String add(String n, String m) 
    {
        Sclass a=new Sclass();
        Sclass b=new Sclass();
        Sclass sum=new Sclass();
        
        
        String[] na = n.split("");
        String[] nb = m.split("");
        
        int[] Ainput = new int[na.length];
        int[] Binput = new int[nb.length]; 
        
        for(int i=0;i<na.length;i++)
        {
            Ainput[i]=Integer.parseInt(na[i]);
            a.push(Ainput[i]);
        }
        
        for(int i=0;i<nb.length;i++)
        {
            Binput[i]=Integer.parseInt(nb[i]);
            b.push(Binput[i]);
        }
        
        Sclass carry=new Sclass();
        for(int i=0;i<min(na.length,nb.length);i++)
            {
                sum.push(carry.top()+a.top()+b.top());
                carry.pop();
                String r=String.valueOf(sum.top());
                if(r.length()==2) 
                {
                    String c[]=r.split("");
                    sum.pop();
                    sum.push(Integer.parseInt(c[1]));  
                    carry.push(Integer.parseInt(c[0]));
                }
                a.pop();
                b.pop();
            }
        if(na.length!=nb.length)
        {
            if(a.head==null)
            {
                while(b.head!=null)
                {
                    sum.push(b.top()+carry.top());
                    carry.pop();
                    String r=String.valueOf(sum.top());
                    if(r.length()==2) 
                    {
                       String c[]=r.split("");
                       sum.pop();
                       sum.push(Integer.parseInt(c[1]));  
                        carry.push(Integer.parseInt(c[0]));
                    }
                    b.pop();
                } 
            }
            if(b.head==null)
            {
                while(a.head!=null)
                {
                    sum.push(a.top()+carry.top());
                carry.pop();
                String r=String.valueOf(sum.top());
                if(r.length()==2) 
                {
                    String c[]=r.split("");
                    sum.pop();
                    sum.push(Integer.parseInt(c[1]));  
                    carry.push(Integer.parseInt(c[0]));
                }
                a.pop();
                }
                
            }
        }
        if(carry.head!=null)
        {
            sum.push(carry.top());
            carry.pop();
        }
       
        return sum.traverse();
    }
}
