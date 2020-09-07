import java.util.ArrayList;
public class kPartitionsOfEqualSum{

    public static void solve(int[]arr,int vidx,int n,int k,int[] subsetSum,int sfsf,ArrayList<ArrayList<Integer>>ans){   
        //sfsf=subsets formed so far        
        if(vidx==arr.length){
            if(sfsf==k){
                boolean flag=true;
                for(int i=0;i<subsetSum.length-1;i++){
                    if(subsetSum[i]!=subsetSum[i+1]){
                        flag= false;
                        break;
                    }
                }
                
                if(flag){
                    for(ArrayList<Integer>partition : ans){
                        System.out.print(partition+ " ");
                    }
                    System.out.println();
                }
            }
            return;
        }
        for(int i=0;i<ans.size();i++){
            if(ans.get(i).size()>0){
                ans.get(i).add(arr[vidx]);
                subsetSum[i]+=arr[vidx];
                solve(arr,vidx+1,n,k,subsetSum,sfsf,ans);
                subsetSum[i]-=arr[vidx];
                 ans.get(i).remove(ans.get(i).size()-1);
            }else{
                ans.get(i).add(arr[vidx]);
                subsetSum[i]+=arr[vidx];
                solve(arr,vidx+1,n,k,subsetSum,sfsf+1,ans);
                 ans.get(i).remove(ans.get(i).size()-1);
                  subsetSum[i]-=arr[vidx];
                 break;
            }
        }
    }   
     public static void main(String[]args){
     int []arr={2, 1, 4, 5, 6};
      int sum=0;
     for(int i=0;i<arr.length;i++){
         sum+=arr[i];
     }
      int n=arr.length;
     int k=3;
     if(k==1){
         System.out.print("[");
         for(int i=0;i<arr.length;i++){
             System.out.print(arr[i]+ ",");
         }
         System.out.println("]");
         return;
         } 
         if(k>n || sum%k!=0){
             System.out.println("-1");
             return;
         }
    
     int []subsetSum=new int[k];
     ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
     for(int i=0;i<k;i++){
         ans.add(new ArrayList<>());
     }
    solve(arr,0,n,k,subsetSum,0,ans);
  
    }
}