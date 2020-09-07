import java.util.Scanner;
import java.util.ArrayList;
public class pr3{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[]args){
//System.out.println(gss("abc"));
//System.out.println(gsswascii("ab"));
//printSS("abc"," ");
//printSSWithAscii("ab"," ");
String str= scn.nextLine();
System.out.print(removeHi(str));
    }
    public static ArrayList<String> gss(String str){
        if(str.length()==0){
            ArrayList<String> br=new ArrayList<String>();
            br.add(" ");
            return br;
        }
        char ch=str.charAt(0);  
        String ros=str.substring(1);
        //faith-give result for a smaller string
        ArrayList<String> rr=gss(ros);
        ArrayList<String> mr=new ArrayList<String>();
        for(String rstr : rr){
            mr.add(rstr);
            mr.add(ch+rstr);
        }
        return mr;
    }
    public static ArrayList<String> gsswascii(String str){
        if(str.length()==0){
            ArrayList<String> br=new ArrayList<String>();
            br.add(" ");
            return br;
        }
        char ch=str.charAt(0);
        String ros=str.substring(1);
        ArrayList<String> rr=gsswascii(ros);
        ArrayList<String> mr=new ArrayList<String>();
        for(String rstr : rr ){
            mr.add(rstr);
            mr.add(ch+ rstr);
            mr.add((int)ch + rstr);

        }
        return mr;
    }
    public static void printSS(String ques,String asf){
        if(ques.length()==0){
            System.out.println(asf);
            return;
        }
        char ch=ques.charAt(0);
        String roq=ques.substring(1);
        // cahr ne ans m jaane se mna krdia
        printSS(roq,asf);
        // char ne ans m jaane k lie hn
        printSS(roq,asf+ch);
    }
    public static void printSSWithAscii(String ques,String asf){
         if(ques.length()==0){
             System.out.println(asf);
             return;
         }
         char ch=ques.charAt(0);
         String roq=ques.substring(1);
         printSSWithAscii(roq,asf);
         printSSWithAscii(roq,asf+ch);
         printSSWithAscii(roq,asf+(int)ch);
    }
    public static String removeHi(String ques){
        if(ques.length()==0){
            return " ";
        }
        if(ques.length()>1 && ques.substring(0,2).equals("hi"))
{
    return removeHi(ques.substring(2));
} 
else {
    char ch=ques.charAt(0);
    return ch+removeHi(ques.substring(1));
}
   }
}

