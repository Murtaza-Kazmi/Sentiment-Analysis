/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentimentanalysis;

/**
 *
 * @author Murtaza Kazmi
 */
/* NOTE : While running the program you would have to change I guess all 
 * file locations. I have set the required inputs to "filenames" only. 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.lang.Object;

//remember taking Stdlibrary

public class SentimentAnalysis{
  
  public static void main(String[] args){
    
    int selection = -1;
    Scanner scan1 = new Scanner(System.in);
    while(selection < 1 || selection > 5){
      StdOut.println("What would you like to do?");
      StdOut.println("1: Get the score of a word");
      StdOut.println("2: Get the overall score of words in a file (one word per line)");
      StdOut.println("3: Find the highest/lowest scoring words in a file");
      StdOut.println("4: Sort words from a file into positive.txt and negative.txt");
      StdOut.println("5: Exit the program");
      StdOut.println("Enter a number 1-5:");
      if(scan1.hasNextInt())
        selection = scan1.nextInt();
    }
    switch(selection){
      case 1:
        StdOut.println("Enter Word Name:");
        String n1 =  StdIn.readString();
        WordScore(n1);
        break;
      case 2:
        StdOut.println("Enter File Name:");
        String b = StdIn.readString();
        OverallScore(b);
        break;
      case 3:
        HighLow();
        break;
      case 4:
        FileCreator();
        break;
      case 5:
        StdOut.println("Program Exitted");
        break;
    }
    
  }
    //nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
  public static void WordScore(String word){
    String reviewText = "";
    int curnum = 0;
    int score =0;
    //StdOut.println(s);
    File file = new File("C:\\Users\\HP\\Desktop\\ITP\\Ass4\\moviereviews.txt");
    Scanner filaa = null;
    try
    {
      filaa = new Scanner(file);
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
      System.exit(1);
    }
    int count = 0;
    while(filaa.hasNextLine())
    {
      curnum = filaa.nextInt();
      reviewText = filaa.nextLine();
      //count++;
      if(reviewText.contains(word))
      {
        score = score + curnum;
        count++;
      }      
      
    }
    StdOut.println(word + " appears " + count+ " times");
    StdOut.println("The average score for reviews containing the word " + word + " is " + (score*1.0/count));
  }
  //nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
  public static void OverallScore(String a)
  {
    String b = a;
    a = "\\" + a;
    File file2 = new File("C:\\Users\\HP\\Desktop\\ITP\\Ass4"+a);
    String enteredword="";
    Scanner scanner2 = null;
    int curnum = 0;
    String reviewText = "";
    int score = 0;
    int count = 0;
    double d = 0;
    double av = 1.0;
    int c = 0;
    try
    {
      scanner2 = new Scanner(file2);
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
      System.exit(1);
    }
    File file = new File("C:\\Users\\HP\\Desktop\\ITP\\Ass4\\moviereviews.txt");
    Scanner filaa = null;
    try
    {
      filaa = new Scanner(file);
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
      System.exit(1);
    }
    while(scanner2.hasNextLine())
    {
      enteredword = scanner2.nextLine();
      while(filaa.hasNextLine())
      {
        curnum = filaa.nextInt();
        reviewText = filaa.nextLine();
        if(reviewText.contains(enteredword))
        {
          score = score + curnum;
          count++;
        }
      }
      if(!filaa.hasNextLine())
      {
      filaa = null;
      try
    {
      filaa = new Scanner(file);
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
      System.exit(1);
    }
      }
      if(count>0)
      {
      av += (score*1.0/count);
      score = 0; count = 0;
      c++;
      }     
    }
    d = av/c;
    StdOut.println("The average score of words in " + b + " is " +  d);
    if(d < 1.99)
    {StdOut.println("The overall sentiment of "+ b + " is negative");}
    else if(d > 2.1)
    {StdOut.println("The overall sentiment of " +b + " is positive");}
    else{StdOut.println("The overall sentiment of " +b + " is neutral");}
  }
    //nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
  public static void HighLow()
  {
    StdOut.println("Enter File Name:");
    String b = StdIn.readString();
    String a = "\\" + b;
    File file2 = new File("C:\\Users\\HP\\Desktop\\ITP\\Ass4"+a);
    String enteredword="";
    Scanner scanner2 = null;
    int curnum = 0;
    String reviewText = "";
    int score = 0;
    int count = 0;
    double d = 0;
    double av = 1.0;
    int c = 0;
    try
    {
      scanner2 = new Scanner(file2);
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
      System.exit(1);
    }
    File file = new File("C:\\Users\\HP\\Desktop\\ITP\\Ass4\\moviereviews.txt");
    Scanner filaa = null;
    try
    {
      filaa = new Scanner(file);
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
      System.exit(1);
    }
    double min = -99999;
    double max = 99999;
    String more= "";
    String less = "";
    while(scanner2.hasNextLine())
    {
      enteredword = scanner2.nextLine();
      
      while(filaa.hasNextLine())
      {
        curnum = filaa.nextInt();
        reviewText = filaa.nextLine();
        if(reviewText.contains(enteredword))
        {
          score += curnum;
          count++;
        }
      }
      if(!filaa.hasNextLine())
      {
      filaa = null;
      try
    {
      filaa = new Scanner(file);
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
      System.exit(1);
    }
      }
      if(((score*1.0)/count)> min)
      {
        min= ((score*1.0)/count);
        more = enteredword;
        
      }
      if(((score*1.0)/count)< max)
      {
        max = ((score*1.0)/count);
        less = enteredword;
      }
      score = 0;
      count = 0;
     
    }
  StdOut.println("The most positive word, with a score of " + min  + " is " + more);
  StdOut.println("The most negative word, with a score of " + max + " is " + less);
  }
  private static Formatter x;
  private static Formatter y;
  //nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
  public static void FileCreator()
  {
    StdOut.println("Input file's name:");
    String a = StdIn.readString();
    try{
      x = new Formatter("Positive.txt");    
    }
    catch(Exception e){
      StdOut.println("File Not Created Error");
    }
    try{
      y = new Formatter("Negative.txt");    
    }
    catch(Exception e){
      StdOut.println("File Not Created Error");
    }
    File file2 = new File("C:\\Users\\HP\\Desktop\\ITP\\Ass4\\"+a);
    Scanner scanner2 = null;
    try
    {
      scanner2 = new Scanner(file2);
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
      System.exit(1);
    }
    File file = new File("C:\\Users\\HP\\Desktop\\ITP\\Ass4\\moviereviews.txt");
    Scanner filaa = null;
    try
    {
      filaa = new Scanner(file);
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
      System.exit(1);
    }
    double min = -99999;
    double max = 99999;
    String enteredword = "";
    String reviewText= "";
    String more= "";
    String less = "";
    int score= 0;
    int count = 0;
    int curnum=0;
    while(scanner2.hasNextLine())
    {
      enteredword = scanner2.nextLine();
      
      while(filaa.hasNextLine())
      {
        curnum = filaa.nextInt();
        reviewText = filaa.nextLine();
        if(reviewText.contains(enteredword))
        {
          score += curnum;
          count++;
        }
      }
      if(!filaa.hasNextLine())
      {
      filaa = null;
      try
    {
      filaa = new Scanner(file);
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
      System.exit(1);
    }
      }
      if(((score*1.0)/count)> 2.1)
      {
       x.format("%s%n", enteredword);
      }
      if(((score*1.0/count)< 1.9))
      {
       y.format("%s%n", enteredword);
      }
      score = 0;
      count = 0;
     
    }
    x.close();
    y.close();
  }
  
 
}
