
package ha3_mt20051;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class HA3_Maze {
    static int R,C;
    static int row[]={-1,1,0,0};
    static int col[]={0,0,-1,1};
    
    static  ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    
    public static void add_edge(ArrayList<ArrayList<Integer>> adj, int x ,int y)
    {
        adj.get(x).add(y);
        adj.get(y).add(x);
    }
    public static void AdjList(int a[][])
    {
       
        //Create nodes in arraylist
        for(int i=0;i<=R*C-1;i++) adj.add(new ArrayList<Integer>());
        
        //create an adjacency list by connecting nodes who satisfy all conditions
        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                int s = i*C + j%C;
                for(int k=0;k<4;k++)
                {
                    int i1 = i + row[k];
                    int j1 = j + col[k];
                    
                    if(i1>=0 && j1>=0 && i1<R && j1<C && a[i][j]!=a[i1][j1])
                    {
                       int d = i1*C + j1%C;
                        add_edge(adj,s,d);
                    }
                }
            }
        } 
    }
    
    public static void sd(ArrayList<ArrayList<Integer>> adj ,int src ,int dest ,int v)
    {
        int p[]=new int[v];
        int d[]=new int[v];
        
        boolean e = BFS(adj,src,dest,p,d,v);
        if(e==false) 
        {
            System.out.println(-1);
            return;
        }
        
        LinkedList<Integer> path = new LinkedList<>(); 
        int c=dest;
        path.add(c);
        int count=0;
        while(p[c]!=-1) 
        {
            path.add(c);
            count++;
            c=p[c];
        }
       // System.out.println(d[dest]);
        System.out.println(count+1);
        
    }
    
    public static boolean BFS(ArrayList<ArrayList<Integer>> adj,int src,int dest,int p[],int d[],int v)
    {
        boolean visited[] = new boolean[v];
        Arrays.fill(p,-1);   
        Arrays.fill(d, -1);
        
        LinkedList<Integer> q = new LinkedList<>();
        
        //Mark source as visited
        visited[src]=true;
        d[src] = 0;
        q.add(src);
        
        //apply bfs until queue is empty
        while(!q.isEmpty())
        {
            int u = q.remove();
            for(int i=0;i<adj.get(u).size();i++)
            {
                int n = adj.get(u).get(i);
                if(visited[n]==false)
                {
                    visited[n]=true;
                    d[n]=d[u]+1;
                    p[n]=u;
                    q.add(n);
                    if(n==dest) return true;
                }
            }
        }
        return false;   
    }
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        R= sc.nextInt();
        C=sc.nextInt();
        int a[][] = new int[R][C];
        //String t[][]=new String[R][C];
        for(int i=0;i<R;i++)
        {
            String temp = sc.next();
            for(int j=0;j<C;j++) 
            {
                if(temp.charAt(j)=='1')
		a[i][j]=1;		
                else a[i][j]=0;		
            }
        }
        
        AdjList(a);
        /*for (int i = 0; i < adj.size(); i++) { 
            for (int j = 0; j < adj.get(i).size(); j++) { 
                System.out.print(adj.get(i).get(j) + " "); 
            } 
            System.out.println(); 
        } */
        int source = 0, fdest = R*C-1;
        sd(adj,source,fdest,R*C);   
    } 
}
