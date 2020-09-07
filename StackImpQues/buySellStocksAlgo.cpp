#include<iostream>
#include<vector>
#include<stack>
#include<algorithm>
using namespace std;
int maxProfit(vector<int> &prices){
    stack<int>s;
    int maxprof=0;
    int n=prices.size();
    if(n==0){
        return 0;
    }
    s.push(prices[0]);
    int i=1;
    while(i<n){
        if(prices[i]<s.top()){
            s.push(prices[i]);
        }
        else{
            int p=prices[i]-s.top();
            maxprof=max(maxprof,p);
        }
        i++;
    }
    return maxprof;
  
}