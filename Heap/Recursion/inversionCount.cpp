#include<iostream>
using namespace std;
//inversion count
int merge(int *a,int s,int e){
     int mid=(s+e)/2;
    int i=s;
    int j=mid+1;
    int k=s;
    
    int temp[10000];
    int count=0;
    while(i<=mid && j<=e){
        if(a[i]<=a[j]){
            temp[k]=a[i];
            k++;
            i++;
        }
        else{
            temp[k++]=a[j++];
            count+=mid-i+1;
        }
    }
    // fill the array, if some of the elements are left
    while(i<=mid){
        temp[k++]=a[i++];
    }
    while(j<=e){
        temp[k++]=a[j++];
    }
    //copy all elements back to array
    for(int i=s;i<=e;i++){
        a[i]=temp[i];
    }
    return count;
}
int inversion_count(int *a,int s,int e){
    if(s>=e)
    return 0;
    //merge sort
    int mid=(s+e)/2;
    int x=inversion_count(a,s,mid);
    int y=inversion_count(a,mid+1,e);
    int z=merge(a,s,e);
    
    return x+y+z;
}
int main(){
    int arr[]={1,5,2,6,3,0};
    int n=sizeof(arr)/sizeof(int);
    
    cout<<inversion_count(arr,0,n-1)<<endl;
}