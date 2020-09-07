import java.util.Scanner;
public class pr1{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[]args){
//printDec(5);
//printIncre(5);
//pdi(3);
//System.out.print(factorial(5));
//System.out.println(power(5,2));
toh("A","B","C",3);
    }
    public static void printDec(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        printIncre(n-1);
    }
    public static void printIncre(int n){
        if(n==0){
            return;
        }
        printIncre(n-1);
        System.out.println(n);
    }
    public static void pdi(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        pdi(n-1);
        System.out.println(n);
        
    }
    public static int factorial(int n){
        if(n==0){
            return 1;
        }
        int fnm1 = factorial(n-1);
        int fn=n*fnm1;
    return fn;
    }
    public static int power(int x,int n){
        if(n==0){
            return 1;
        }
        int xpnm1=power(x,(n-1));
        int xpn=x*xpnm1;
        return xpn;
    }
    public static void toh(String src,String dest,String helper,int n){
        if(n==0){
            return;
        }
        //faith 1 - move n-1 discs from src to helper
        toh(src,helper,dest,n-1);
        System.out.println("move"+n+" th disc from"+ src+"to"+dest);
        // faith 2- move n-1 discs from helper to destination
        toh(helper,dest,src,n-1);
    }
}