#include<iostream>
#include<vector>
using namespace std;
void display(vector <int> &arr,int vidx){
    if(vidx==arr.size()){
        return;
    }
    cout<<arr[vidx]<<endl;
     display(arr,vidx+1);
}
void displayR(vector<int> &arr,int vidx){
    if(vidx==arr.size()){
        return;
    }
displayR(arr,vidx+1);
cout<<arr[vidx]<<endl;
}
int max(vector<int> &arr,int vidx){
    if(vidx==arr.size()-1){
        return arr[vidx];
    }
    int misa=max(arr,vidx+1);
    if(misa>arr[vidx]){
        return misa;
    }
    else{
    return arr[vidx];
}
bool find(vector<int> &arr,int vidx ,int data){
    if(vidx=arr.size()){
        return 0;
    }
    if(arr[vidx]==data){
        return 1;
    }
    else{
     bool fisa=find(arr,vidx+1,data);
    return fisa;
    }
}


int main(int args,char**argv){
    vector<int> arr={2,3,4,5,6};
   // display(arr,0);
   //displayR(arr,0);
   //cout<<max(arr,0)<<endl;
  cout<<find(arr,0,2)<<endl;
   }