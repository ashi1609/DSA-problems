
package ques2b_ashi_sahu;

public class Sclass 
{
    public static class Snode
    {
        int data;
        Snode next;    
        
        Snode()
        {
            this.data=0;
            this.next=null;
        }
        
        Snode(int data)
        {
            this.data=data;
            this.next=null;
        }
        
        Snode (int data,Snode next)
        {
            this.data=data;
            this.next=next;
        }
        
        int getData()
        {
            return this.data;
        }
        
        void setData(int data)
        {
            this.data=data;
        }
        
        Snode getLink()
        {
            return this.next;
        }
        
        void setLink(Snode next)
        {
            this.next=next;
        }
    }
    
    public Snode head;
    
    public void push(int data)
    {
        Snode p1=new Snode(data);
        if(head==null) head=p1;
        else
        {
           p1.next=head;
           head=p1;
        }
    }
    
    public void pop()
    {
        if(head==null) System.out.print("");
        else
        {
            Snode p1=head;
            head=head.next;
        }
    }
    
    public int top()
    {
        if(head==null) return 0;
        else return head.data;
    }
    
    public String traverse()
    {
        String a = new String("");
        Snode p1=head;
        if(head==null) 
        {
            return a;
        }
        else
        {
            while(p1!=null)
            {
                String d=String.valueOf(p1.getData());
                a=a+d;
                //System.out.print(p1.getData()+"");
                p1=p1.next;
                
            }
            return a;
        }
    }
    
}
