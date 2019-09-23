//This program was written by Ryan Raitz on October 31 2018
import java.io.*;
import java.util.*;

public class TopologicalSort
{
private int [] pre;
private int [] post;

private boolean [] visit;

private int time;

private ArrayList<Integer> de;
private ArrayList<String[]> graphInput;

//Depth first search method
public void dfs(ArrayList<String[]> S)
{
// Mark all the vertices as not visited 
for (int i = 0;i < visit.length; i++)
{
   visit[i]=false;
}
// Call the recursive Topological Sort starting 
//from all vertices one by one 
for(int j = 0;j < visit.length; j++)
{
   if(visit[j] == false)
   {
      test(S,j);
   }
}
}

public void test(ArrayList<String[]> S, int x)
{
// Mark the current node as visited
visit[x]=true;
preV(x,time);
// Recursion for all the vertices adjacent to this 
// vertex 
for(int i = 0;i < S.size(); i++)
{
   if(S.get(x)[i].equals("1") && visit[i] == false)
   {
      test(S,i);
   }
}
}

//Set clock for pre-visit
public void preV(int i, int time)
{
   pre[i]=this.time;
   this.time+=1;
}

//Set clock for post-visit and add
//to dead end list once post-visited 
public void postV(int i, int time)
{
   post[i]=this.time;
   this.time+=1;
   
   de.add(i);
}

//Method to read in file data
public void readFile(String x)
{
File f = new File(x);

Scanner test=null;
try
{
   test = new Scanner(f);
}
catch(FileNotFoundException e)
{
   e.printStackTrace();
}

graphInput = new ArrayList<>();
while(test.hasNextLine())
{
   String [] split = test.nextLine().split(",");
   graphInput.add(split);
}
}

//Method to input the file and perform
//functions on the data within
public void setup()
{
//initialize clock to 1
time = 1;

System.out.println("Filename: ");
Scanner s = new Scanner(System.in);
String fn;
fn = s.nextLine();
readFile(fn);

de = new ArrayList<>();

pre = new int[visit.length];
post = new int[visit.length];

visit = new boolean[graphInput.size()];
//perform depth first search on graph data
dfs(graphInput);
//print results
for(int i =0;i < pre.length; i++)
{
   System.out.println((i+1) + ":"+pre[i]+ ":"+post[i]);
}   
System.out.print("Topological Sort: ");
for(int j = pre.length-1;j >= 0;j--)
{
  System.out.print((de.get(j)+1)+" ");
}
System.out.println("/n");
}

//Main method
public static void main(String[]args)
{
   TopologicalSort run = new TopologicalSort();
   run.setup();
}
}
