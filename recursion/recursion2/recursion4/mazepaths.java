import java.util.Scanner;
import java.util.ArrayList;
public class mazepaths{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[]args){ 
//pmp(0,0,2,2," ");
//pmpdiagonalmoves(0,0,2,2," ");
//pmpmultimoves(0,0,3,3," ");
int[][]maze={{1,0,1,1},{1,1,1,1},{1,0,1,1},{1,1,0,1}};
boolean [][] visited=new boolean[maze.length][maze[0].length];
floodfill1(0,0,maze,visited," ");
    }
    public static void pmp(int sr,int sc,int dr,int dc,String psf){
        if(sr==dr && sc==dc){
            System.out.println(psf);
            return;
        }
// horizontal calls
if(sc+1<=dc){
    pmp(sr,sc+1,dr,dc,psf+"H");
}
// vertical calls
if(sr+1<=dr){
    pmp(sr+1,sc,dr,dc,psf+"V");
}
    }
     public static void pmpdiagonalmoves(int sr,int sc,int dr,int dc,String psf){
        if(sr==dr && sc==dc){
            System.out.println(psf);
            return;
        }
// horizontal calls
if(sc+1<=dc){
    pmpdiagonalmoves(sr,sc+1,dr,dc,psf+"H");
}
// vertical calls
if(sr+1<=dr){
    pmpdiagonalmoves(sr+1,sc,dr,dc,psf+"V");
}
// diagonal calls
if(sc+1<=dc && sr+1<=dr){
pmpdiagonalmoves(sr+1,sc+1,dr,dc,psf+"D");
    }
    }
    public static void pmpmultimoves(int sr,int sc, int dr,int dc,String psf){
        if(sr==dr && sc==dc){
            System.out.println(psf);
            return;
        }
        // horizontal calls
        for(int ma=1; ma<=dc-sc; ma++){
            pmpmultimoves(sr,sc+ma,dr,dc,psf+"H"+ma);
        }
        // vertical calls
        for(int ma=1;ma<=dr-sr; ma++){
            pmpmultimoves(sr+ma,sc,dr,dc,psf+"V"+ma);
        }
        // diagonal calls
        for(int ma=1; ma<=dr-sr && ma<=dc-sc ; ma++){
            pmpdiagonalmoves(sr+ma,sc+ma,dr,dc,psf+"D"+ma);
        }
    }
    public static void floodfill1(int sr,int sc, int[][]maze,boolean[][]visited,String psf){
        if(sr==maze.length-1 && sc== maze[0].length-1){
            System.out.println(psf);
            return;
        }
if(IsThisAnInvalidSpot(sr,sc,maze)==true || visited[sr][sc]==true){
return;
}
//dltr
visited[sr][sc]=true;
floodfill1(sr+1,sc,maze,visited,psf+"D");
floodfill1(sr,sc-1,maze,visited,psf+"L");
floodfill1(sr-1,sc,maze,visited,psf+"T");
floodfill1(sr,sc+1,maze,visited,psf+"R");
   }
   public static boolean IsThisAnInvalidSpot(int sr,int sc,int[][]maze){
       if(sc>maze[0].length-1 || sr>maze.length-1){
           return true;
       }else if(sc<0 || sr<0){
           return true;
       } else if(maze[sr][sc]==0){
           return true;
       } else {
           return false;
       }
   }
}