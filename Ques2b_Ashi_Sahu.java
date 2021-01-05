
package ques2b_ashi_sahu;

import java.util.Scanner;
import static ques2b_ashi_sahu.Add.add;


public class Ques2b_Ashi_Sahu {

    
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        String op1=sc.nextLine();
        String op2=op1;
        
        int n=Integer.parseInt(op1);
        for(int j=n;j>0;j--)
        {
            for (int i=j-2;i>0;i--)
            {
                op2=add(op1,op2);
            }
            op1=op2;
        }
        
        System.out.println(op2);
    }
    
}
