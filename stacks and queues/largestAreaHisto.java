import java.util.Scanner;
import java.util.Stack;
public class largestAreaHisto{
    public static void main(String[]args){
       int[]arr={6,2,5,4,5,1,6};
        System.out.println(solve(arr));
    }
   
  public static int solve(int[]arr){
      int[]rb=new int[arr.length];
      Stack<Integer>st=new Stack<>();
      st.push(arr.length-1);
      rb[arr.length-1]=arr.length;
      for(int i=arr.length-1;i>=0;i--){
          while(st.size()>0 && arr[i]<arr[st.peek()]){
              st.pop();
          }
          if(st.size()==0){
              rb[i]=arr.length;
          }else{
              rb[i]=st.peek();
          }
          st.push(i);
      }
      int[]lb=new int[arr.length];
     // Stack<Integer>st=new Stack<>();
      st.push(0);
      lb[0]=-1;
      for(int i=1;i<arr.length;i++){
          while(st.size()>0 && arr[i]<arr[st.peek()]){
              st.pop();
          }
          if(st.size()==0){
              lb[i]=-1;
          }else{
              lb[i]=st.peek();
          }
          st.push(i);
      }
      //area
      int maxArea=0;
      for(int i=0;i<arr.length;i++){
          int width=rb[i]-lb[i]-1;
          int area=arr[i]*width;
          if(area>maxArea){
              maxArea=area;
          }
      }
    return maxArea;  
  }
    }
    