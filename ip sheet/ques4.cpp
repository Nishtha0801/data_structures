#include<iostream>
#include<vector>
using namespace std;

int equilli_index(vector<int> &a,int n){
    int i;
    int j;
    int ss,es;
    
    for(int i=0;i<n;++i){
         ss=0; 
        for(int j=0;j<i;j++){
            ss+=a[j];
        }
            es=0;
            for(int j=i+1;j<n;j++){
                es+=a[j];
            
        }
        if(ss==es){
            return i+1;
        }
    }
    return -1;
    
}
int main() {
    int T,n;
        cin>>T;
    while(T-->0){
        cin>>n;
    
    vector<int>a(n,0);
    for(int i=0;i<n;i++){
        cin>>a[i];
    }
    cout<<equilli_index(a,n)<<endl;
	
        }
}