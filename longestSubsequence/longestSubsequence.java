medmfffffmmmmm/////l//This program was written by Ryan Raitz on November 29 2018

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;

//Class to find the longest increasing subsequence
//of a text file containing comma seperated integers
public class longestSubsequence
{
       int[][] Graph;
       static int[] prev;
       static ArrayList<Integer> subsequence;
   
   //Main method
   public static void main(String[] args)
   {
      BufferedReader br = null;
		
		try {
         ArrayList<String> temp;
			br = new BufferedReader(new FileReader("algoInput.txt"));
			
			while ((br.readLine()) != null) 
         {
				String str = br.readLine();
            DAG(fileToArrayList(str));
			}
         
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
      
	}
	
	// Method to read and parse string file data into an arraylist and 
   //convert the strings to integer values
	public static ArrayList<Integer> fileToArrayList(String s) 
   {
		ArrayList<String> arr = new ArrayList<String>();
      ArrayList<Integer> conv = new ArrayList<Integer>();
		
		if (s != null) 
      {
			String[] temp = s.split(",");
			for (int i = 0; i < temp.length; i++) 
         {
				if (!(temp[i] == null) || !(temp[i].length() == 0)) 
            {
					arr.add(temp[i].trim());
				}
			}
		}
		
		for(int i=0;i<arr.size();i++)
      {
         String x = arr.get(i);
         int y = Integer.parseInt(x);
         conv.add(y);
      }
      
      return conv;   
	} 
         
   //Method to compute the Directed Acyclic Graph of the input 
   //and initialize the 2D graph array      
   public static void DAG(ArrayList<Integer> input)
   {
      prev = new int[input.size()];
      int[][] Graph = new int[0][0];
   
      for(int i=1;i<input.size();i++)
      {
         for(int j=i;j<input.size();j++)
         {
            if(input.get(i) < input.get(j))
            {
               Graph[i][j]=1;
            }
         }
      }
      
      int len = longestPath(Graph);
      System.out.println(len);
      
      int position = max(prev);
      
      subsequence.add(input.get(position+1));
      subsequence.add(input.get(position));
      do
      {
         position = prev[position];
         subsequence.add(input.get(position));
      }while(prev[position]!=0);
      
      for(int i=0;i<=subsequence.size();i++)
      {
         System.out.println(subsequence.get(i));
      }
   }
   
   //Method to extract the maximum from the list and
   //update the prev array with its value
   public static int maxFromPrevTo(int j, int[][] Graph, ArrayList<Integer> List)
   {
      int maximum = 0;
      
      for(int i=0;i < Graph.length;i++)
      {
         if(maximum < List.get(i) && Graph[i][j] == 1)
         {
            maximum = List.get(i);
            prev[j] = i;
         }
      }
      return maximum;
   }
   
   public static int max(int[] list)
   {
      int maximum = 0;
      
      for(int i=0;i<list.length;i++)
      {
         if(maximum < list[i])
         {
            maximum=list[i];
         }
      }
      return maximum;
   }
   
   //Method to initialize the prev and list 
   //array and apply the max function on it
   public static int longestPath(int[][] Graph)
   {
      int length = Graph.length;
      ArrayList<Integer> list = new ArrayList<Integer>();
      
      for(int i=0;i<Graph.length;i++)
      {
         prev[i] = 0;
         list.set(i, 0);
      }
      
      for(int j=0;j<list.size();j++)
      {
         list.set(j, 1+maxFromPrevTo(j, Graph, list));
      }
      
      int[] arr = convertArrayList(list);
      
      return max(arr);
   }
   
   //Method to convert an ArrayList to an array
   public static int[] convertArrayList(List<Integer> list)
   {
    int[] x = new int[list.size()];
    for (int i=0; i < x.length; i++)
    {
        x[i] = list.get(i).intValue();
    }
    return x;
   }
}   
   
   
         
   
   
         
      