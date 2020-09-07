#include<iostream>
using namespace std;
int main(int args,char**argv){
    int n;
    int count=0;
    cout<<"enter n=";
    cin>>n;
    while(n!=0){
        count++;
        n=n/10;
    }
    cout<<count<<endl;
}