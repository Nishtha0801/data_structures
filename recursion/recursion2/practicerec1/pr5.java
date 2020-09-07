public class pr5{
public static void main(String[]args){
//pmp(0,0,2,2," ");
//pmphvd(0,0,2,2," ");
//pmpMultiMoves(0,0,3,3," ");
int[][]maze={{1,0,1,1},
            {1,1,1,1},
            {1,0,1,1},
            {1,1,0,1}};
            boolean[][]visited=new boolean[maze.length][maze[0].length];

        floodfill(0,0,maze,visited," ");
            
}
public static void pmp(int sr,int sc,int dr,int dc,String psf){     //hv moves are allowed
    if(sr==dr && sc==dc){
        System.out.println(psf);
        return;
    }
    // horizontal call
    if(sc+1<=dc){
    pmp(sr,sc+1,dr,dc,psf+"H");
    }
    //vertical call
    if(sr+1<=dr){
        pmp(sr+1,sc,dr,dc,psf+"V");
    }

}
public static void pmphvd(int sr,int sc,int dr,int dc,String psf){
    if(sr==dr && sc==dc){
        System.out.println(psf);
        return;
    }
    // horizontal call
    if(sc+1<=dc){
        pmphvd(sr,sc+1,dr,dc,psf+"H");
    }
    //vertical call
    if(sr+1<=dr){
        pmphvd(sr+1,sc,dr,dc,psf+"V");
    }
    //diagonal call
    if(sr+1<=dr && sc+1<=dc){
        pmphvd(sr+1,sc+1,dr,dc,psf+"D");
    }
}
public static void pmpMultiMoves(int sr,int sc,int dr,int dc,String psf){
    if(sr==dr && sc==dc){
        System.out.println(psf);
        return;
    }
    // horizontal calls
    //ma=minimum amplitude
    for(int ma=1;ma<=(dc-sc);ma++){
        pmpMultiMoves(sr,sc+ma,dr,dc,psf+"H"+ma);
    }
    for(int ma=1;ma<=(dr-sr);ma++){
        pmpMultiMoves(sr+ma,sc,dr,dc,psf+"V"+ma);
    }
    //diagonal calls
    for(int ma=1;ma<=(dr-sr) && ma<=(dc-sc) ; ma++){
        pmpMultiMoves(sr+1,sc+1,dr,dc,psf+"D"+ma);
    }
}
public static void floodfill(int sr,int sc,int[][]maze,boolean[][]visited,String psf){
    if(sc==maze[0].length-1 && sr==maze.length-1){
        System.out.println(psf);
        return;
    }
    if(isThisInvalidSpot(sr,sc,maze)==true || visited[sr][sc]==true){
        return;
    }
    //dltr
    visited[sr][sc]=true;
    floodfill(sr+1,sc,maze,visited,psf+"D");
    floodfill(sr,sc-1,maze,visited,psf+"L");
    floodfill(sr-1,sc,maze,visited,psf+"T");
    floodfill(sr,sc+1,maze,visited,psf+"R");

}
public static boolean isThisInvalidSpot(int sr,int sc,int[][]maze){
    if(sr>maze.length-1 || sc>maze[0].length-1){
        return true;
    }
    else if(sr<0 || sc<0){
        return true;
    }
    else if(maze[sr][sc]==0){
        return true;
    }
    else{
        return false;
    }
}
}