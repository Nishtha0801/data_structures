#include<iostream>
#include<algorithm>
using namespace std;
int profit(int n,int c,int* wt,int* prices){
    if(n==0 || c==0){   //n=no of elemnts and c==capacity
        return 0;
    }
    //rec case
    int ans=0;
    int inc,exc;
    inc=exc=-(1e8);
    if(wt[n-1]<=c){
        inc=prices[n-1]+profit(n-1,c-wt[n-1],wt,prices);
    }
    exc=0+ profit(n-1,c,wt,prices);
    ans=max(inc,exc);
    return ans;
}
int main(){
    int wt[]={1,2,3,5};
    int prices[]={40,20,30,100};
    int n=4;
    int c=7;
    cout<<profit(n,c,wt,prices);
}