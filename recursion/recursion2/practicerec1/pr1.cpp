#include<iostream>
using namespace std;
void printDec(int n){
    if(n==0){
        return;
    }
    cout<<n<<endl;
    printDec(n-1);
}
void printInc(int n){
    if(n==0){
        return;
    }
    printInc(n-1);
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
int factorial(int n){
    if(n==0){
        return 1;
    }
    int fnm1=factorial(n-1);
    int fn=n*fnm1;
    return fn;
}
int power(int x,int n){
    if(n==0){
        return 1;
    }
    int xpnm1=power(x,(n-1));
    int xpn=x*xpnm1;
    return xpn;
}
void toh(String src,String dest,String helper,int n){
    if(n==0){
        return;
    }
    toh(src,helper,dest,n-1);
    cout<<"move"<<n<<"th disc from"<<src<<"to"<<dest<<endl;
    toh(helper,dest,src,n-1);
}
int main(int args,char**argv){
    //printDec(5);
   // printInc(5);
   //pdi(3);
 //  cout<<factorial(5)<<endl;
 //cout<<power(5,2)<<endl;
 toh("A","B","C",3)
}