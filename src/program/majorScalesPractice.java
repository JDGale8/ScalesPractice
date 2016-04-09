// this is a program that will return a random scale with each call
package program;

import java.util.Random;

public class majorScalesPractice{
      
    public static String[] simpleMScales = {"A","B","C","D","E","F","G"};
    public static String[] fullMScales = {"Ab","A","Bb","B","C","C#","D","Eb","E","F","F#","G"};

    public static String scale;
    public static boolean cont;
    
    public static void main(String args[]){
      String s = getSimpleMScale();
      print(s+"");
    }       
   
    public static String getSimpleMScale(){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(7); 
        
        scale = simpleMScales[randomInt];
        return scale;                        
    }
    
    public static String getFullMScale(){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(12); 
      
        scale = fullMScales[randomInt];
        return scale;                        
    }
    
    // just because I like print more than the java form
    private static void print(String message){ 
        System.out.println(message);        
    }
}


