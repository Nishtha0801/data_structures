#include<iostream>
#include<vector>
#include<list>
#include<unordered_map>
using namespace std;
bool ContainsNearbyDuplicates(vector<int> &nums,int k){
    unordered_map<int,list<int>>m; 
    for(int i=0;i<nums.size();i++){
        if(m.find(nums[i])!=m.end()){
            for(auto node: m[nums[i]]){
               
                 if(abs(i-node)<=k){
                      cout<<"hi";
                    return true;
                    
                 }               //check krna pdega 
             }
            m[nums[i]].push_back(i);
         }
       }
     return false;
}
int main(){
    int n,k;
    cin>>n;
    vector<int>nums;
    for(int i=0;i<n;i++){
        int num;
        cin>>num;                       //check krana pdega
        nums.push_back(num);
    }
    cin>>k;
    cout<<ContainsNearbyDuplicates(nums,k);
    return 0;
}
