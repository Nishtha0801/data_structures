import java.util.Scanner;
import java.util.ArrayList;
public class rec4{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[]args){ 
        //pbp(0,10," ");
        //pbpWithCounter(0,10," ");
        //pbpproactive(0,10," ");
        //pbpWith16Opening(0,10," ");
        //int[] ladders=new int[16];
        //ladders[2]=13;
        //ladders[3]=11;
        //ladders[5]=7;
        //pbpWith16OpeningWithLadders(0,15,ladders," ");
        int[]snl=new int[21];
        snl[3]=17;
        snl[7]=11;
        snl[13]=5;
        snl[19]=2;
        int[] moves1={2,5,3,4,6,3,4,3,5,1,2,3};
        int[] moves2={2,5,3,4,6,3,4,3,5,1,1,6,5,2,3,5};
        pbpWith16OpeningWithSnl(0,20,snl,moves1,0);
    }
    public static void pbp(int src,int dest,String psf){
        if(src==dest){
            System.out.println(psf);
            return;
        }
        if(src>dest){
            return;
        }
        for(int dice=1;dice<=6;dice++){
            int inter=src+dice;
            pbp(inter,dest,psf+dice);
        }
    }
    public static void pbpWithCounter(int src,int dest,String psf){
        if(src==dest){
            int counter=0;
            counter++;
            System.out.println(counter+ " "+psf);
            return;
        }
        if(src>dest){
            return;
        }
        for(int dice=1;dice<=6;dice++){
            int inter=src+dice;
            pbp(inter,dest,psf+dice);
        }
    }
    public static void pbpproactive(int src,int dest,String psf){
        if(src==dest){
            System.out.println(psf);
            return;
        }
        
        
        
        for(int dice=1;dice<=6;dice++){
            int inter=src+dice;
            if(inter<=dest){
            pbp(inter,dest,psf+dice);
            }
        }
   
    }
    public static void pbpWith16Opening(int src,int dest,String psf){
        if(src==dest){
            System.out.println(psf);
            return;
        }
        if(src>dest){
            return;
        }
        if(src==0){
            pbpWith16Opening(1,dest,psf+1);
            pbpWith16Opening(1,dest,psf+6);
        }
        
        else{
        for(int dice=1;dice<=6;dice++){
            int inter=src+dice;
            pbpWith16Opening(inter,dest,psf+dice);
        }
        }
    }
     public static void pbpWith16OpeningWithLadders(int src,int dest,int[] ladders,String psf){
        if(src==dest){
            System.out.println(psf);
            return;
        }
        if(src>dest){
            return;
        }
        if(src==0){
            pbpWith16OpeningWithLadders(1,dest,ladders,psf+1);
            pbpWith16OpeningWithLadders(1,dest,ladders,psf+6);
        }
        else if(ladders[src]!=0){
            pbpWith16OpeningWithLadders(ladders[src],dest,ladders,psf+"["+src+"->"+ladders[src]+"]");
        }
        else{
        for(int dice=1;dice<=6;dice++){
            int inter=src+dice;
            pbpWith16OpeningWithLadders(inter,dest,ladders,psf+dice);
        }
        }
    }
    public static void pbpWith16OpeningWithSnl(int src,int dest,int[]snl,int[]moves,int mvidx){
if(src==dest){
    System.out.println(win);
    return;
}
if(mvidx==moves.length){
    System.out.println(src);
    return;
}
if (src==0){
    if(moves[mvidx]==1) || moves[mvidx]==6){
        pbpWith16OpeningWithSnl(1,dest,snl,moves,mvidx+1);
    }
    else{
        pbpWith16OpeningWithSnl(src,dest,snl,moves,mvidx+1);
    }
}
    else{
        if(snl[src]!=0){
            pbpWith16OpeningWithSnl(snl[src],dest,snl,moves,mvidx);
        }
        else{
            if(src+moves[mvidx]<=dest){
                pbpWith16OpeningWithSnl(src+moves[mvidx],dest,snl,moves,mvidx+1);
            }
            else{
                pbpWith16OpeningWithSnl(src,dest,snl,moves,mvidx+1);
            }
        }
    }
}

    
}