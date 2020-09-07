import java .util.Scanner;
public class recursion1{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[]args){
        int n=scn.nextInt();
        printDecreasing(n);

    }
    public static void printDecreasing(int n){
        if(n==0){
            return ;
        }
        System.out.println(n);
        printDecreasing(n-1);
    }
}