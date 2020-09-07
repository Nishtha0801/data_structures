#include<iostream>
#include<stack>
using namespace std;
void transfer(stack<int> &s1,stack<int>&s2,int n){
    for(int i=0;i<n;i++){
      s2.push(s1.top());
      s1.pop();
    }
}
void reverseStack(stack<int> &s1){
    //helper stack
    stack<int>s2;
    int n=s1.size();
    for(int i=0;i<n;i++){
        //pick the element at top and insert it at the bottom
        int x=s1.top();
        s1.pop();
        // transfer n-i-1 elemnts from stack s1 into s2
        transfer(s1,s2,n-i-1);
        // insert the element x in S1
        s1.push(x);
        //transfer n-i-1 elements from S2 ro S1
        transfer(s2,s1,n-i-1);
    }
}
int main(){
    stack<int>s;
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    reverseStack(s);
    while(!s.empty()){
        cout<<s.top()<<" ";
        s.pop();
    }
    return 0;
}