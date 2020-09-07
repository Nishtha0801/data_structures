import java.util.Scanner;

public class pandc{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[]args){
permutations(new boolean[4],2,0," ");
    }
    public static void permutations(boolean[]boxes,int tq,int qpsf,String asf){
        if(qpsf==tq){
            System.out.println(asf);
            return;
        }
        for(int b=0;b<boxes.length; b++){
            if(boxes[b]=false){
            boxes[b]=true;
            permutations(boxes,tq,qpsf+1,asf+"q"+(qpsf+1)+"b"+ b);
            
            boxes[b]=false;
            }
        }
    }
}