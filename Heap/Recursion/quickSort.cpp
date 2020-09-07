#include<iostream>
#include<algorithm>
using namespace std;
int partition(int *a,int s,int e){
    //Inpalce
    int i=s-1;
    int j=s;
    int pivot=a[e];
    for(;j<=e-1;){
        if(a[j]<=pivot){
          //merge smaller elements in region 1
          i=i+1;
          swap(a[i],a[j]);
        }
        //expand te larger region
        j=j+1;
    }
    //place the pivot element in correct index
    swap(a[i+1],a[e]);
    return i+1;
}
void quickSort(int*arr,int s,int e){
    //base case
    if(s>=e){
        return;
    }
    // recursive case
    int p= partition(arr,s,e);
    quickSort(arr,s,p-1);
    quickSort(arr,p+1,e);
}
int main(){
    int arr[]={1,5,2,6,3,0};
    int n=sizeof(arr)/sizeof(int);      
    quickSort(arr,0,n-1);
    for(int i=0;i<=n-1;i++){
        cout<<arr[i]<<" ";
    }
}