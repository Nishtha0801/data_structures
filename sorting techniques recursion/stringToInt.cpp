#include<iostream>
#include<cstring>
using namespace std;
int stringToInt(char*a,int n){
    if(n==0){
        return 0;
    }
    int digit=a[n-1]-'0';
    int small_ans= stringToInt(a,n-1);
    return small_ans*10 + digit;
}
int main(){
    char a[]="1234";
    int len=strlen(a);
    cout<<stringToInt(a,len)<<endl;
}