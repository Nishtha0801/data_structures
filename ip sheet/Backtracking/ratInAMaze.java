public class ratInAMaze{
   public static void floodfill(int sr,int sc,int[][]maze,boolean[][]visited,String psf){
    if(sr== maze.length -1 && sc==maze[0].length-1){
     System.out.println(psf);
     return;
    }
    if(isThisAnInvalidSpot(sr,sc,maze)==true || visited[sr][sc]==true){
       return;
    }
    //dltr
    visited[sr][sc]=true;
    floodfill(sr+1,sc,maze,visited,psf+"D");
    floodfill(sr,sc-1,maze,visited,psf+"L");      //will give one path only to finad all the possible paths,use line 16
    floodfill(sr-1,sc,maze,visited,psf+"T");
    floodfill(sr,sc+1,maze,visited,psf+"R");
    //visited[sr][sc]=false;
   }
   public static boolean isThisAnInvalidSpot(int sr,int sc,int[][]maze){
      if(sc>maze[0].length-1 || sr>maze.length-1){
         return true;
      }else if(sc<0 || sr<0){
         return true;
      }else if(maze[sr][sc]==0){
         return true;
      }
      else{
         return false;
      }
   }
   public static void main(String[] args){
      int[][] maze={{1,0,1,1},{1,1,1,1},{1,0,1,1},{1,1,0,1}};
   boolean[][]visited=new boolean[maze.length][maze[0].length];
      floodfill(0,0,maze,visited," ");
   }
}