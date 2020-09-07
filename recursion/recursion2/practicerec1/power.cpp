#include<iostream>
using namespace std;
int main(int args,char**argv)
{
    int n,p;
    cout<<"no";
    cin>>n;
    cout<<"power";
    cin>>p;
    int temp=1;
    for(int i=1;i<=p;i++)
    {
    int k;
    k=temp*n;
    temp=k;
    }
cout<<temp;

}