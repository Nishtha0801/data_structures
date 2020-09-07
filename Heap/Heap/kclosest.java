class Solution{
    public int[][] kclosest(int[][] points,int k){
        PriorityQueue<int[]>maxHeap=new PriorityQueue<>((a,b)->(b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1]));
        for(int []point:points){
            maxHeap.add(point);
            if(maxHeap.size()>k){
                maxHeap.remove();
            }
        }
        int [][]ans=new int[k][2];
        while(k-- -> 0){
            ans[k]=maxHeap.remove();
        }
    }
}