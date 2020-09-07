#include<iostream>
#include<vector>
#include<unordered_map>
using namespace std;
bool containDuplicates(vector<int>&nums){
 unordered_map<int,bool>m;
 for(int i=0;i<nums.size();i++){
     if(m.find(nums[i])==m.end()){
         m[nums[i]]=true;
     }
     else{
         return true;
     }
 }
   return false;
}
int main(){
    int n;
    cin>>n;
    vector<int>nums;
    for(int i=0;i<n;i++){
        int num;
        cin>>num;
        nums.push_back(num);
    }
    cout<<containDuplicates(nums);
    return 0;
}