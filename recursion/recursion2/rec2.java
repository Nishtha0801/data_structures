public class rec2{
    public static void main(String[]args){
int[] arr={ 5,9,23,9,2,9,-1,9};
//display(arr,0);
//displayR(arr,0);
//System.out.print(max(arr,0));
//System.out.println(find(arr,55,0));
//System.out.println(firstIndex(arr,99,0));
//System.out.println(lastIndex(arr,9,0));

bubbleSort(arr,0,arr.length-1);

for(int i=0;i<arr.length;i++){
    System.out.print(arr[i]+" ");
}
System.out.print(" ");


    }
    public static void display(int[]arr,int vidx){
        if(vidx==arr.length){
            return;
        }
        System.out.println(arr[vidx]);
        display(arr,vidx+1);
    }
    public static void displayR(int[]arr,int vidx){
        if(vidx==arr.length){
            return;
        }
        displayR(arr,vidx+1);
        System.out.println(arr[vidx]);

    }
    public static int max(int[]arr,int vidx){
        if(vidx==arr.length-1)
        {
        return arr[vidx];
        }
        int misa=max(arr,vidx+1);
        if(misa>arr[vidx]){
            return misa;
        }
        else return arr[vidx];
    }
    public static boolean find(int[]arr,int data,int vidx){
    if(vidx==arr.length){
        return false;
    }
    if(arr[vidx]==data){
        return true;
    }
    else{
    boolean fisa=find(arr,data,vidx+1);
    return fisa;
    }
}
public static int firstIndex(int[]arr,int data ,int vidx){
    if(vidx==arr.length){
        return -1;
    }
if(arr[vidx]==data){
    return vidx;
}
else {
    int fiisa=firstIndex(arr,data,vidx+1);
    return fiisa;
}
}
public static int lastIndex(int[]arr,int data,int vidx){
    if(vidx==arr.length){
        return -1;
    }
    int liisa=lastIndex(arr,data,vidx+1);
    if(liisa!=-1){
        return liisa;
    }
    else 
        if(arr[vidx]==data){
        return vidx;
        
    }
    else return -1;
}

    


public static void bubbleSort(int[]arr,int si,int li){
    if(li==0){
        return;
    }
    if(si==li){
        bubbleSort(arr,0,li-1);
        return;
    }
    if(arr[si]>arr[si+1]){
        int temp=arr[si];
        arr[si]=arr[si+1];
        arr[si+1]=temp;
    }
    bubbleSort(arr,si+1,li);
}
}