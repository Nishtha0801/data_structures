#include<iostream>
#include<vector>
#include<queue>
using namespace std;
int main(){
    priority_queue<int>leftHeap;
    priority_queue<int,vector<int>,greater<int>>rightHeap;
    int d;
    cin>>d;
    leftHeap.push(d);
    float med=d;
    cout<<"median is"<<med<<" ";
    cin>>d;
    //input all the elements
    while (d!=-1)
    {
        if(leftHeap.size()>rightHeap.size()){
            if(d<med){
                rightHeap.push(leftHeap.top());
                leftHeap.pop();
                leftHeap.push(d);
            }
            else{
                rightHeap.push(d);
            }
            med=(leftHeap.top()+rightHeap.top())/2.0;
        }
        else if(leftHeap.size()==rightHeap.size()){
            if(d<med){
                leftHeap.push(d);
                med=leftHeap.top();
            }
            else{
                rightHeap.push(d);
                med=rightHeap.top();
            }
        }
        else{
            if(d<med){
                leftHeap.push(rightHeap.top());
                rightHeap.pop();
                rightHeap.push(d);
            }
            else{
                leftHeap.push(d);
            }
            med=(leftHeap.top()+rightHeap.top())/2.0;
        }
    
    cout<<"med"<<med<<endl;
    cin>>d;  
    }  
}