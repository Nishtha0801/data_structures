#include<iostream>
#include<vector>
#include<stack>
using namespace std;
vector<int> dailyTemp(vector<int>&T){
    vector<int> ans;
    int n=T.size();
    for(int i=0;i<n;i++){
        ans.push_back(0);
    }
    stack<int>s;
    int i=0;
    while(i<n){
        while(!s.empty() && T[i]>T[s.top()]){
            int x=s.top();
            s.pop();
            ans[x]=i-x;
       }
       s.push(i);
       i++;
    }
    return ans;
}