#include<iostream>
#include<algorithm>
#include<unordered_map>
using namespace std;
int longestSubArray0sum(int arr[],int n){
    unordered_map<int,int> m;
    int pre=0;   //for making prefix array
    int len=0;
    for(int i=0;i<n;i++){
        pre+=arr[i];
        if(pre==0){
            len=max(len,i+1);
        }
        if(m.find(pre)!=m.end()){
            len=max(len,i-m[pre]);
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
    cout<<longestSubArray0sum(arr,n)<<endl;
}
