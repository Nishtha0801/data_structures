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
void printDecInc(int n){
    if(n==0){
        return;
    }
    cout<<n<<endl;
    printDecInc(n-1);
    cout<<n<<endl;
}
int factorial(int n){
    if(n==0 || n==1){
        return 1;
    }
    int fnm1=factorial(n-1);
    int fn=n*fnm1;
    return fn;
}
int power(int x,int n){    //x raised to the power n
    if(n==0){
        return 1;
    }
    int xnm1=power(x,(n-1));
    int xn=x*xnm1;
    return xn;
}
int main(int args,char**argv){
//printDec(5);
//printInc(5);
//printDecInc(3);
//cout<<factorial(6);
cout<<power(2,3);
}