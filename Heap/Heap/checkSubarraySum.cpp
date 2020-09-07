#include<iostream>
#include<vector>
#include<unordered_map>
using namespace std;
 
bool checkSubarraySum(vector<int> &nums,int k){
  unordered_map<int,int>m;
  int sum=0;
  int mod;
  m[0]=-1; //important point to remember
  for(int i=0;i<nums.size();i++){
      if(k!=0){
          sum+=nums[i];
          mod=sum%k;
          if(m.find(mod)==m.end()){
              m[mod]=i;
          }
          else if(i-m[mod]>1){
              return true;
          }
      }
      if(k==0 && nums[i]==0 && i<nums.size()-1 && nums[i+1]==0){
        return true;
      }
  }
  return false;
}

