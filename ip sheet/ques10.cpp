#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int trap_water(vector<int> &arr){
    int n=arr.size();
    vector<int> left(n,0);
    vector<int> right(n,0);
    int water=0;
    int prev=0;
    for(int i=0;i<n;i++){
        left[i]=max(prev,arr[i]);
        prev=left[i];
    }
    prev=0;
    for(int i=n-1;i>=0;i--){
        right[i]=max(prev,arr[i]);
        prev=right[i];
    }
    
    for(int i=0;i<n;i++){
        water+=min(left[i],right[i])-arr[i];
    }
    return water;
}
int main(){
    int n;
    cin>>n;
    vector<int>arr(n,0);
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    cout<<trap_water(arr)<<endl;
}