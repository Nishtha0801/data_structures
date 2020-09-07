#include<iostream>
#include<vector>
#include<unordered_map>
using namespace std;
int maxSubArrayLen(vector<int> &nums,int k){
    vector<int> prefixSum;
    unordered_map<int,int>pos;
    int sum=0;
    prefixSum.push_back(0);
    for(int i=0;i<nums.size();i++){
        sum+=nums[i];
        prefixSum.push_back(sum);            //not on leetcode
    }
    for(int i=0;i<prefixSum.size();i++){
        pos[prefixSum[i]]=i;
    }
    int ans=0;
    for(int i=0;i<prefixSum.size();i++){
        if(pos.find(k+prefixSum[i])!=pos.end()){
            int index=pos[k+prefixSum[i]];
            if(index-i>ans){
                ans=index-1;
            }
        }
    }
    return ans;
}