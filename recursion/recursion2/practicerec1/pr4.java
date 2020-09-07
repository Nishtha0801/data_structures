public class pr4{
    public static void main(String[]args){
//pbp(0,10," ");
//pbpproactive(0,10," ");
//pbpWith16Opening(0,10," ");
//int[]ladders=new int[16];
//ladders[2]=13;
//ladders[3]=11;
//ladders[5]=7;
//pbpwithladders(0,15,ladders," ");
int[]snl=new int[21];
snl[3]=17;
snl[7]=11;
snl[13]=5;
snl[19]=2;
int[]moves1={2,5,3,4,6,3,4,3,5,1,2,3};
int[]moves2={2,5,3,4,6,3,4,3,5,1,1,6,5,2};
pbpWithSnl(0,20,snl,moves1,0);

    }
    static int counter=0;
    public static void pbp(int src,int dest,String psf){
        if(src==dest){
            counter++;
            System.out.println(counter+":"+psf);
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
    public static void  pbpproactive(int src,int dest,String psf){
        if (src==dest){
            counter++;
            System.out.println(counter+":"+psf);
            return;
        }
        for(int dice=1;dice<=6;dice++){
            int inter=src+dice;
            if(inter<=dest){
                pbpproactive(inter,dest,psf+dice);
            }
        }
    }
    public static void pbpWith16Opening(int src,int dest,String psf){
          if(src==dest){
            counter++;
            System.out.println(counter+":"+psf);
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
    public static void pbpwithladders(int src,int dest,int[]ladders,String psf){
        if(src==dest){
            counter++;
            System.out.println(counter+" :"+psf);
            return;
            }
            if(src>dest){
                return;
            }
            if(src==0){
                pbpwithladders(1,dest,ladders,psf+1);
                pbpwithladders(1,dest,ladders,psf+6);
            }
            else if(ladders[src]!=0){
                pbpwithladders(ladders[src],dest,ladders,psf+("["+src+"->"+ladders[src]+"]"));
            }
            else{
                for(int dice=1;dice<=6;dice++){
                    int inter=src+dice;
                    pbpwithladders(inter,dest,ladders,psf+dice);
                }
            }
        }
    public static void pbpWithSnl(int src,int dest,int[]snl,int[]moves,int mvidx){
        if(src==dest){
            System.out.println("win");
            return;
        }
        if(mvidx==moves.length){
            System.out.println(src);
            return;
        }
        if(src==0){
            if(moves[mvidx]==1 || moves[mvidx]==6){
                pbpWithSnl(1,dest,snl,moves,mvidx+1);
            }
            else {
                pbpWithSnl(src,dest,snl,moves,mvidx+1);
            }
        }
        else{
        if(snl[src]!=0){
            //moves ni bdhnge
            pbpWithSnl(snl[src],dest,snl,moves,mvidx);
        }
        else {
            if(src+moves[mvidx]<dest){
                pbpWithSnl(src+moves[mvidx],dest,snl,moves,mvidx+1);
            }
            else{
                pbpWithSnl(src,dest,snl,moves,mvidx+1);
            }
        }
    }
    }
}