#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int platform_needed(vector<int> &arr,vector<int> &dep,int n){
 sort(arr.begin(),arr.end());
 sort(dep.begin(),dep.end());
 int plt_needed=1;
 int ans=1;
 int i=1;
 int j=0;
 while(i<n && j<n){
        if(arr[i]<=dep[j]){
        plt_needed++;
        i++;
        }
        else if(arr[i]> dep[j]){
        plt_needed--;
        j++;
        }
        if(ans<plt_needed){
        ans=plt_needed;
        }
     }
  return ans;
}
int main(){
    int T;
    cin>>T;
    for(int i=0;i<T;i++){
        int n;
        cin>>n;
        vector<int>arr(n,0);
        for(int i=0;i<n;i++){
            cin>>arr[i];
        }
        vector<int>dep(n,0);
        for(int i=0;i<n;i++){
            cin>>dep[i];
        }
        cout<<platform_needed(arr,dep,n)<<endl;
    }
}
