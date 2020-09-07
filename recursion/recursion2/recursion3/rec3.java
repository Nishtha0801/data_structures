import java.util.Scanner;
import java.util.ArrayList;
public class rec3{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[]args){ 
//System.out.println(gss("abc"));
//System.out.println(gsswithASCII("ab"));
//printSS("abc"," ");
String str=scn.nextLine();
//System.out.println(removeHi(str));
//System.out.println(removeDuplicates(str));
System.out.println(removeHiExceptHit(str));
    }
    public static ArrayList<String> gss(String str){
        if(str.length()==0){
            ArrayList<String> br=new ArrayList<String>();
            br.add(" ");
            return br;
        }
        char ch=str.charAt(0);
        String ros=str.substring(1);
        ArrayList<String> rr=gss(ros);
        ArrayList<String> mr=new ArrayList<String>();
        for(String rstr: rr){
            mr.add(rstr);
            mr.add(ch+rstr);
        }
        return mr;
    }
     public static ArrayList<String> gsswithASCII(String str){
        if(str.length()==0){
            ArrayList<String> br=new ArrayList<String>();
            br.add(" ");
            return br;
        }
        char ch=str.charAt(0);
        String ros=str.substring(1);
        ArrayList<String> rr=gsswithASCII(ros);
        ArrayList<String> mr=new ArrayList<String>();
        for(String rstr: rr){
            mr.add(rstr);
            mr.add(ch+rstr);
            mr.add((int)ch + str);
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
        printSS(roq,asf);
        printSS(roq,asf+ch); 
    }
    public static String removeHi(String ques){
        if(ques.length()==0){
            return " ";
        }
        if(ques.length()>1 && ques.substring(0,2).equals ("hi"))
        return removeHi(ques.substring(2));
        else {
            char ch=ques.charAt(0);
            return ch+ removeHi(ques.substring(1));
        }
    }
    public static String removeDuplicates(String ques){
        if(ques.length()==0){
            return " ";
        }
        char ch=ques.charAt(0);
        String recAns=removeDuplicates(ques.substring(1));
        if(ch==recAns.charAt(0))
        return recAns;
        else 
        return ch+recAns;
    }
    public static String removeHiExceptHit(String ques){
        if(ques.length()==0){
            return " ";
        }
        if(ques.length()>1 && ques.substring(0,2).equals("hi"))
        if(ques.length()>2 && ques.substring(0,3).equals("hit"))
        return "hit"+removeHiExceptHit(ques.substring(3));
        else
        return removeHiExceptHit(ques.substring(2));
        else{
            char ch=ques.charAt(0);
            return ch+removeHiExceptHit(ques.substring(1));
        }
    }
}