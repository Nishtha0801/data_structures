import java .util.Scanner;
public class dp1{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[]args){
       // int n=43;
        // to measure time in millisec
       // long start=System.currentTimeMillis();
    //System.out.println(fibonacci(40));
    // System.out.println(fibMemo(n,new int[n+1]));
   // System.out.println(fibTab(n));
  // System.out.println(fibSlider(n));
         // long end=System.currentTimeMillis();
          //System.out.print(end-start);
     // int n=10;
      // long start=System.currentTimeMillis();
      // System.out.println(cbp(0,n));
      //System.out.println(cbpMemo(0,n,new int[n+1]));
    // System.out.println(cbpTab(n));
    //System.out.println(cbpSlider(n));
      // long end=System.currentTimeMillis();
      // System.out.print(end-start);
     // int n=2;
        // long start=System.currentTimeMillis();
        // System.out.println(cmp(0,0,2,2));
         //System.out.println(cmpMemo(0,0,n,n,new int[n+1][n+1]));
        // System.out.println(cmpTab(2,2));
       // System.out.println(cmpSlider(n,n));
        // long end=System.currentTimeMillis();
          //System.out.print(end-start);
    // int[][]costs={
               //      {2,3,0,4},
                 //    {0,6,5,2},
                   //  {8,0,3,7},
                     //{2,0,4,2}
                     //};
          //  System.out.println(mcostPath(0,0,costs.length-1,costs[0].length-1,costs));
 //System.out.println(mcostPathMemo(0,0,costs.length-1,costs[0].length-1,costs,new int[costs.length][costs[0].length]));
 //mcpt(costs);
       int[][]mat={
                   {1,0,1,0,0,1},
                   {1,0,1,1,1,1},
                   {1,1,1,1,1,1},
                   {1,1,1,1,0,0},
                   {1,1,1,1,1,1},
                   {0,0,1,1,1,0}
                };
   // mssm(mat);
   mssmNormal(mat,0,0,new int[mat.length][mat[0].length]);
   System.out.println(omax);
    }

    public static int fibonacci(int n){
        if(n==0 || n==1){
            return n;
        }
        int fnm1=fibonacci(n-1);
        int fnm2=fibonacci(n-2);
        int fn=fnm1+fnm2;
        return fn;
    }
    public static int fibMemo(int n,int []qb){    //qb=question bank
    if(n==0 || n==1){
        return n;
    }
    if(qb[n]!=0){
        return qb[n];
    }
    int fnm1=fibMemo(n-1,qb);
    int fnm2=fibMemo(n-2,qb);
    int fn=fnm1+fnm2;
    qb[n]=fn;
    return fn;

    }
    public static int fibTab(int n){
        int[] f=new int[n+1];
        f[0]=0;
        f[1]=1;
        for(int x=2;x<=n;x++){
            f[x]=f[x-1]+f[x-2];
        }
        return f[n];
    }
    public static int cbp(int s,int d){      //cbp=count board path s=src; d=dest
    if(s>d){
        return 0;
    }
    if(s==d){
        return 1;    
    }
    int cstod=0; // count from src to destination
    for(int dice=1;dice<=6;dice++){
        int i=s+dice;
       int citod=cbp(i,d);
       cstod+=citod;
    }
return cstod;
    }
    public static int cbpMemo(int s,int d,int[]qb){      //cbp=count board path s=src; d=dest
    if(s>d){
        return 0;
    }
    if(s==d){
        return 1;    
    }
    if(qb[s]!=0){
        return qb[s];
    }
    int cstod=0; // count from src to destination
    for(int dice=1;dice<=6;dice++){
        int i=s+dice;
       int citod=cbp(i,d);
       cstod+=citod;
    }
    qb[s]=cstod;
return cstod;
    }
    public static int cbpTab(int d){
        int[] f=new int[d+1];
        f[d]=1;
        for(int x=d-1;x>=0;x--){
            for(int dice=1;dice<=6;dice++){
                if(x+dice<=d){
                    f[x]+=f[x+dice];
                }
            }
        }
        return f[0];
    }
    public static int cmp(int sr,int sc,int dr,int dc){      //count mazepath
     if(sr==dr && sc==dc){
         return 1;
     }
     if(sr>dr || sc>dc){
         return 0;
     }
     int cstod=0;
     int cihtod=cmp(sr,sc+1,dr,dc);
     int civtod=cmp(sr+1,sc,dr,dc);
     cstod=cihtod+civtod;
    
    return cstod;
    }
    public static int cmpMemo(int sr,int sc,int dr,int dc,int[][]qb){      //count mazepath
     if(sr==dr && sc==dc){
         return 1;
     }
     if(sr>dr || sc>dc){
         return 0;
     }
     if(qb[sr][sc]!=0){
         return qb[sr][sc];
     }
     int cstod=0;
     int cihtod=cmpMemo(sr,sc+1,dr,dc,qb);
     int civtod=cmpMemo(sr+1,sc,dr,dc,qb);
     cstod=cihtod+civtod;
    qb[sr][sc]=cstod;
    return cstod;
    }
    public static int cmpTab(int dr,int dc){
        int[][] f=new int[dr+1][dc+1];
       for(int r=dr;r>=0;r--){
           for(int c=dc;c>=0;c--){
               if(r==dr && c==dc){
                   //last cell
                   f[r][c]=1;
               }
               else if(r==dr){
                   //last row excluding last cell
                   f[r][c]=f[r][c+1];
               }
               else if(c==dc){
                   // last co;umn excluding last cell
                   f[r][c]=f[r+1][c];
               }
               else{
                   f[r][c]=f[r+1][c]+f[r][c+1];               }
           }
       } 
      return f[0][0]; 
    }
    public static int fibSlider(int n){
        int[] s=new int[2];
        s[0]=0;    //s0 coincides with f0
        s[1]=1;    //s1 coincides with f1
        for(int nos=1;nos<=n;nos++){
            int nf=s[0]+s[1];
            s[0]=s[1];
            s[1]=nf;
        }
        return s[0];
    }
    public static int cbpSlider(int d){
        int []s=new int[6];
        s[0]=1; //s[0]=f[d];
      //  s1,s2,s3,s4,s5 coinicides with f ka d+1;d+2...
      for(int nos=1;nos<=d;nos++){     //nos=no of slides
          int nv=s[0]+s[1]+s[2]+s[3]+s[4]+s[5];
          s[5]=s[4];
          s[4]=s[3];
          s[3]=s[2];
          s[2]=s[1];
          s[1]=s[0];
          s[0]=nv;
      }
      return s[0];
    }
    public static int cmpSlider(int dr,int dc){
        int []s=new int[dc+1];
            //representing the last row
           // Arrays.fill(s,1);                    //this line is not working
            for(int nors=1;nors<=dr;nors++){
                for(int c=s.length-2;c>=0;c--){    //why 2?=coz last cell m sbke 1 h,pehla cell apne aap slide 
                // hoajega,uske baad dse hme krana h;
                    int nv=s[c]+s[c+1];
                    s[c]=nv;
                }
            }
            return s[0];
    }
     public static int mcostPath(int sr,int sc,int dr,int dc,int[][]costs){
        if(sr==dr && sc==dc){
            return costs[sr][sc];
        }
        int mcstod=0;
        int mcihtod=Integer.MAX_VALUE;    //intermediate horizontal
        int mcivtod=Integer.MAX_VALUE;   //vertical
        if(sr<dr)
            mcivtod=mcostPath(sr+1,sc,dr,dc,costs);
        if(sc<dc)
            mcihtod=mcostPath(sr,sc+1,dr,dc,costs);
        
        mcstod=costs[sr][sc]+Math.min(mcivtod,mcihtod);
        return mcstod;
     }
    public static int mcostPathMemo(int sr,int sc,int dr,int dc,int[][]costs,int[][]qb){
        if(sr==dr && sc==dc)
        return costs[sr][sc];
        if(qb[sr][sc]!=0){
            return qb[sr][sc];
        }
        int mcstod=0;
        int mcihtod=Integer.MAX_VALUE;    //intermediate horizontal
        int mcivtod=Integer.MAX_VALUE;   //vertical
        if(sr<dr)
            mcivtod=mcostPath(sr+1,sc,dr,dc,costs);
        if(sc<dc)
            mcihtod=mcostPath(sr,sc+1,dr,dc,costs);
        
        mcstod=costs[sr][sc]+Math.min(mcivtod,mcihtod);
        qb[sr][sc]=mcstod;
        return mcstod;
    }
    public static void mcpt(int[][]costs){
        int[][]mcosts=new int[costs.length][costs[0].length];
      //  int[][]path=new String[costs.length-1][costs[0].length-1];
        int dr=costs.length-1;
        int dc=costs[0].length-1;
        for(int r=dr;r>=0;r--){
            for(int c=dc;c>=0;c--){
                int rp1=r+1;
                int cp1=c+1;
                if(r==dr && c==dc){
                    //last cell
                    mcosts[r][c]=costs[r][c];
          //          path[r][c]=".";
                }
                else if(r==dr){
                    mcosts[r][c]=costs[r][c]+mcosts[r][cp1];
            //        path[r][c]="H"+path[r][cp1];
                }
                else if(c==dc){
              mcosts[r][c]=costs[r][c]+mcosts[rp1][c];
              //path[r][c]="v"+path[rp1][c];

                }
                else{
                    if(mcosts[rp1][c]<mcosts[r][cp1]){
                        mcosts[r][c]=costs[r][c]+mcosts[rp1][c];
                //        path[r][c]="v"+path[rp1][c];
                    }
                    else{
                        mcosts[r][c]=costs[r][c]+mcosts[r][cp1];
                  //      path[r][c]="H"+path[r][cp1];
                    }
                }
            }
        }
        System.out.println(mcosts[0][0]);
    }
    public static void mssm(int[][]mat){   //max size sub matrix of 1s
    //TABULATION
     int[][]strg=new int[mat.length][mat[0].length];  //storage
     int dr=strg.length-1;
     int dc=strg[0].length-1;
     int omax=0;
     int orow=-1;
     int ocol=-1;
     for(int r=dr;r>=0;r--){
         for(int c=dc;c>=0;c--){
             int rp1=r+1;
             int cp1=c+1;
             if(r==dr && c==dc){
                 strg[r][c]=mat[r][c];
             }
             else if(r==dr){
                 strg[r][c]=mat[r][c];
             }
             else if(c==dc){
                 strg[r][c]=mat[r][c];
             }
             else{
                 if(mat[r][c]==0){
                     strg[r][c]=0;
                 }
                else{
                    strg[r][c]=1+Math.min(strg[rp1][cp1],Math.min(strg[rp1][c],strg[r][cp1]));
                }
                 
             }
             if(strg[r][c]>omax){
                 omax=strg[r][c];
                 orow=r;
                 ocol=c;
             }
         }
     }
     System.out.println(omax+"@["+orow+","+ocol+"]");
    }
    static int omax=0;
    static int orow=-1;
    static int ocol=-1;
    public static int mssmNormal(int[][]mat,int sr,int sc,int[][]qb){
        int dr=mat.length-1;
        int dc=mat[0].length-1;
        if(sr==dr && sc==dc){
            return mat[sr][sc];
        }
        if(mat[sr][sc]==0){
            return 0;
        }
        if(qb[sr][sc]!=0){
            return qb[sr][sc];
        }
        else{
            int msh=mssmNormal(mat,sr,sc+1,qb);   //horizontal
            int msv=mssmNormal(mat,sr+1,sc,qb);   //vertical
            int msd=mssmNormal(mat,sr+1,sc+1,qb);  //diagonal

            int res=1+Math.min(msv,Math.min(msh,msd));
            if(res>omax){
                omax=res;
                orow=sr;
                ocol=sc;
                
            }    //an error is coming(out of bound);
            qb[sr][sc]=res;
             return res;
        }
       
    }
    public static void goldMineT(int[][]mine){
        int[][]smime=new int[mine.length][mine[0].length];
        String[][]path=new String[mine.length][mine[0].length];
        int omax=0;
        int orow=-1;
        int ocol=-1;
        for(int c=mine[0].length-1;c>=0;c--){
            for(int r=0;r<mine.length;r++){
                int rp1=r+1;
                int rm1=r-1;
                int cp1=c+1;
                if(c==mine[0].length-1){
                    smine[r][c]=mine[r][c];
                    path[r][c]=r+"-"+c;
                }
                else if(r==0){
                    if(smine[r][cp1]>smine[rp1][cp1]){
                        smine[r][c]=mine[r][c]+smine[r][cp1];
                        path[r][c]=r+"-"+c+path[r][cp1];
                    }
                    else{
                         smine[r][c]=mine[r][c]+smine[rp1][cp1];
                        path[r][c]=r+"-"+c+path[rp1][cp1];
                    }
                }
                else if(r==mine.length-1){
                    if(smine[r][cp1]>smine[rm1][cp1]){
                smine[r][c]=mine[r][c]+smine[r][cp1];
                        path[r][c]=r+"-"+c+path[r][cp1];
            }
            else{
                smine[r][c]=mine[r][c]+smine[rm1][cp1];
                        path[r][c]=r+"-"+c+path[rm1][cp1];
            }
                }
                else{
                    if(smine[r][cp1]>smine[rp1][cp1] && smine[r][cp1]>smine[rm1][cp1])
                }
            }
        }
    }

}