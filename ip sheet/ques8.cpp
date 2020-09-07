#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int chocolate_problem(vector<int> &arr,int m){
    sort(arr.begin(),arr.end());
    int min_diff=(int)1e8;
    int curr_diff=0;
    int j=m-1;
    for(int i=0;i<arr.size();i++){
        
        if(j<arr.size())
         curr_diff=arr[j]-arr[i];
        if(curr_diff<min_diff){
          min_diff=curr_diff;
        }
        j++;
    }

  return min_diff;
}
int  main(){
    int n;
    cin>>n;
    int m;
    cin>>m;
    vector<int>arr(n,0);
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    cout<<chocolate_problem(arr,m)<<endl;
}

