#include<iostream>
#include<algorithm>
#include<unordered_map>
using namespace std;
int longestSubArraysumK(int arr[],int n,int k){
    unordered_map<int,int> m;
    int pre=0;   //for making prefix array
    int len=0;
    for(int i=0;i<n;i++){
        pre+=arr[i];
        if(pre==k){
            len=max(len,i+1);
        }
        if(m.find(pre-k)!=m.end()){
            len=max(len,i-m[pre-k]);
        }
        else{
            m[pre]=i;
        }
    }
    return len;

}
int main(){
    int n;
    cin>>n;
    int arr[100];
    for(int i=0;i<n;i++){
     cin>>arr[i];
    }
    cout<<longestSubArraysumK(arr,n,3);
}