#include<iostream>

using namespace std;
void printDecreasing(int n){
    if(n==0){
        return;
    }
    cout<<n<<endl;
    printDecreasing(n-1);
}
void printIncreasing(int n){
    if(n==0){
        return;
    }
    printIncreasing(n-1);
    cout<<n<<endl;
}
void pdi(int n){
    if(n==0){
        return;
    }
    cout<<n<<endl;
    pdi(n-1);
    cout<<n<<endl;
}
int fact(int n){
    if(n==0){
        return 1;
    }
    int fnm1=fact(n-1);
    int fn=n*fnm1;
    return fn;
}
int power(int x,int n){
    if(n==0){
        return 1;
    }
    int xpnm1=power(x,n-1);
    int xpn=x*xpnm1;
    return xpn;
}
void toh(String src, String dest, String help,int n){
    if(n==0){
        return;
    }
    // faith1=prirnts instructions, to move n-1 discs from source to helper
    toh(src,help,dest,n-1);
    cout<<"move"<<n<<"th disc from"<<src<<"to"<<dest<<endl;
    // faith 2= prints instructions,to move n-1 discs from helper to destination
    toh(help,dest,src,n-1);
}
int main(int args,char**argv){
   // printDecreasing(5);
   //printIncreasing(5);
   //pdi(3);
   //cout<<fact(5)<<endl;
   //cout<<power(3,4)<<endl;
   toh("a","b","c",3);
}