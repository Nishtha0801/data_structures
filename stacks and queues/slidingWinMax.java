import java.util.Scanner;
import java.util.Stack;
public class slidingWinMax{
    public static void main(String[]args){
        int[]arr={2,9,3,8,1,7,12,6,14,4,32,0,7,19};
        int[]nge=solve(arr,4);
        display(nge);
    }
    public static void display(int[]arr){
        for(int ele: arr){
            System.out.print(ele+" ");
        }
        System.out.println();
    }
  public static int[]solve(int[]arr,int k){
      Stack<Integer>st=new Stack<>();
      int[]nge=new int[arr.length];
      st.push(arr.length-1);
      nge[arr.length-1]=arr.length;
      for(int i=arr.length-2;i>=0;i--){
          while(st.size()>0 && arr[i]>=arr[st.peek()]){
              st.pop();
          }
          if(st.size()==0){
              nge[i]=arr.length;
          }
          else
          {
              nge[i]=st.peek();
          }
          st.push(i);
      }
      for(int i=0;i<arr.length-k;i++){
          //enter the loop to find maximum of window statring at i
          int j=0;
          while(nge[j]<i+k){
              j=nge[j];
          }
          System.out.print(arr[j]);
      }
      return nge;
  }

}