import java.util.HashMap;
 import java.lang.*;
public class crypto{
    public static void main(String[]args){
        String s1="send";
        String s2="more";
        String s3="money";
       HashMap<Character,Integer> map= new HashMap<>();
       String unique=" ";
       for(int i=0;i<s1.length();i++){
           if(!map.containsKey(s1.charAt(i))){
               map.put(s1.charAt(i),-1);
               unique+=s1.charAt(i);
           }
       }
        for(int i=0;i<s2.length();i++){
           if(!map.containsKey(s2.charAt(i))){
               map.put(s2.charAt(i),-1);
               unique+=s2.charAt(i);
           }
       }
        for(int i=0;i<s3.length();i++){
           if(!map.containsKey(s3.charAt(i))){
               map.put(s3.charAt(i),-1);
               unique+=s3.charAt(i);
           }
       }
       boolean[] usedNumbers=new boolean[10]; // 0 to 9
       solution(unique,0,map,usedNumbers,s1,s2,s3);
    }
    public static int getNum(String s,HashMap<Character,Integer>map){
        String num="";
        for(int i=0;i<s.length();i++){
            num+=map.get(s.charAt(i));
        }
        
        return Integer.parseInt(num);
    }
    public static void solution(String unique,int idx,HashMap<Character,Integer>map,boolean[] usedNumbers,
    String s1,String s2,String s3){
        if(idx==unique.length()){
            int num1=getNum(s1,map);
            int num2=getNum(s2,map);
            int num3=getNum(s3,map);

            if(num1 +num2 == num3){
                for(int i=0;i<26;i++){
                    char ch=(char)('a'+i);
                    if(map.containsKey(ch)){
                        System.out.print(ch+"-"+map.get(ch));
                    }
                }
                System.out.println();
            }
            return;
        }
        char ch=unique.charAt(idx);
        for(int num=0;num<=9;num++){
            if(usedNumbers[num]==false){
                map.put(ch,num);
                usedNumbers[num]=true;
                solution(unique,idx+1,map,usedNumbers,s1,s2,s3);
                usedNumbers[num]=false;
                map.put(ch,-1);
            }
        }
    }
}