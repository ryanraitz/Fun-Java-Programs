//Program to accept a text file of Super Keys and produce an output file with the corresponding candidate keys based on the superkeys input

import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.IOException; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.Files; 
import java.nio.file.Paths; 
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.List;
import java.io.FileWriter;



public class GetCandidateKey 
{


public static ArrayList<String> compareKeys(int count,ArrayList<String> sk)
{

if(count == -1)
{
return sk;
}

for(int i=0;i<sk.size()-1;i++)
{
for(int j=i+1;j<=sk.size()-1;j++)
{
String x = sk.get(i);
String y = sk.get(j);

   if(isSubsequence(x,y)) //eliminate sk[i+1]
   {
      sk.remove(j);
      count=1;
   }
   else if(isSubsequence(y,x)) //eliminate sk[i]
   {
     sk.remove(i);
     count=1;
   }
   else
   {
      count = -1;
   }
}
}
return compareKeys(count,sk);
}

public static void printToFile(ArrayList<String> list) throws IOException
{
FileWriter writer = new FileWriter("output4.txt"); 
for(String str: list) 
{
  writer.write(str);
  writer.write("\n");
}
writer.close();
}

public static boolean isSubsequence(String s, String t) 
{
    if(s.length()==0)
        return true;
 
    int i=0;
    int j=0;    
    while(i<s.length() && j<t.length())
    {
        if(s.charAt(i)==t.charAt(j))
        {
            i++;
        }
 
        j++;
 
        if(i==s.length())
            return true;
    }
 
    return false;
}


   public static void main(String[] args) throws Exception 
   {  
   List<String> lines = Collections.emptyList(); 
   try { 
   lines = Files.readAllLines(Paths.get("superkeys2.txt"), StandardCharsets.UTF_8); 
   } catch (IOException e) { 
   // TODO Auto-generated catch block 
   e.printStackTrace(); 
   } 
   BufferedReader bufReader = new BufferedReader(new FileReader("superkeys2.txt")); 
   ArrayList<String> list = new ArrayList<>();
   String str = bufReader.readLine(); 
   while (str != null) 
   { 
   list.add(str); 
   str = bufReader.readLine(); 
   } 
   bufReader.close(); 
   printToFile(compareKeys(0,list)); 
   } 
   }

