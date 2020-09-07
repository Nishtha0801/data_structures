import java.util.Scanner;
import java.util.ArrayList;
public class generateParenthesis{
    public static void generate(ArrayList<String> ans,String brackets,int open,int close,int max){
        if(brackets.length() == 2*max+1){
            ans.add(brackets);
            return;
        }
        if(close<open){
            generate(ans,brackets+")",open,close+1,max);
        }
        if(open<max){
            generate(ans,brackets+"(",open+1,close,max);
        }
    }
    public static void main(String[]args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        ArrayList<String>ans=new ArrayList<>();
        generate(ans," ",0,0,n);
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }
    }
}