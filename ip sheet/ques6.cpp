#include <iostream>
using namespace std;
int zig_zag(int a[],int n){
    bool flag=true;
    for(int i=0;i<=n-2;i++){
        if(flag){
            if(a[i]>a[i+1]){
                swap(a[i],a[i+1]);
            }
        }
        else
            if(a[i]<a[i+1])
            swap(a[i],a[i+1]);
            
    flag=!flag;        
    }
}
int main(){
    int T,n;
    cin>>T;
    while(T-->0){
        cin>>n;
        
         int a[100];
        for(int i=0;i<n;i++){
            cin>>a[i];
        }
      
    zig_zag(a,n);
    for(int i=0;i<n;i++){
        cout<<a[i]<<" ";
    }
    cout<<endl;
    }
}