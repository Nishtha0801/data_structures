#include<iostream>
#include<algorithm>
using namespace std;
void counting_sort(int *arr,int n){
    //largest in the array
    int largest=-1;
    for(int i=0;i<n;i++){
        largest=max(largest,arr[i]);
    }
    //create a frequency array
    int *freq=new int[largest +1]{0};
    for(int i=0;i<n;i++){
        freq[arr[i]]++;
    }
   // put elements back into array by reading freq
   int j=0;
   for(int i=0; i<largest+1;i++){
       while(freq[i]>0){
           arr[j]=i;
           freq[i]--;
           j++;
       }
   }
}
int main(){
    int arr[]={1,2,1,3,3,4,5,1};
    int n= sizeof(arr)/sizeof(int);
    counting_sort(arr,n);
    for(int i=0;i<n;i++){
        cout<<arr[i]<<" ";
    }
}