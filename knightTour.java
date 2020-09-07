import java.util.Arrays;
public class knightTour{

 static int[] xMove={2,1,-1,-2,-2,-1,1,2};
 static int[] yMove={1,2,2,1,-1,-2,-2,-1};
 public static boolean knightTour(int[][] board,int sr,int sc,int steps){
     board[sr][sc]=steps;
     if(steps == 63){
         return true;
     }
     for(int d=0;d<xMove.length;d++){
         int r=sr+ xMove[d];
         int c=sc+ yMove[d];
         if(r>=0 && c>=0 && r<8 && c<8 && board[r][c]==-1){
             boolean res=knightTour(board,r,c,steps+1);
             if(res) return true;
         }
     }
     board[sr][sc]=-1;
     return false;
 }
 public static void knightTour(){
     int [][]board=new int[8][8];
     for(int[] a : board){
         Arrays.fill(a,-1);
     }
     knightTour(board,0,0,0);
     for(int[] a: board){
         for(int ele :a){
             System.out.print(ele + " ");
         }
         System.out.println();
     }
 }
 public static void main(String []args){
     knightTour();
 }
 

}