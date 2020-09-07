#include<iostream>
#include<vector>
using namespace std;
void display(vector<int> &arr,int vidx){
    if(vidx==arr.size()){
        return;
    }
    cout<<arr[vidx]<<endl;
    display(arr,vidx+1);
}
void disReverse(vector<int> &arr,int vidx){
    if(vidx==arr.size()){
        return;
    }
    disReverse(arr,vidx+1);
    cout<<arr[vidx]<<endl;
}
int max_(vector<int> &arr,int vidx){
    if(vidx==arr.size()-1){
        return arr[vidx];
    }
    int misa=max_(arr,vidx+1);
    if(misa>arr[vidx]){
        return misa;
    }
    else
    return arr[vidx];
}
bool find(vector<int> &arr,int data,int vidx){
    if(vidx==arr.size()-1){
        return false;
    }
    int fisa=find(arr,data,vidx+1);
    if(arr[vidx]==data){
        return true;
    }
    else 
    return fisa;
}
int main(int args,char**argv){
    vector<int> arr={2,3,5,7};
//display(arr,0);
//disReverse(arr,0);
//cout<<max_(arr,0);
cout<<(boolalpha)<<find(arr,15,0);
}