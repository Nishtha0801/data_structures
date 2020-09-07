#include<iostream>
#include<vector>
using namespace std;
int permuinfi(vector<int> &arr,int tar,string ans){
    if(tar==0){
        cout<<ans<<endl;
        return 1;
    }
int count=0;
for(int i=0;i<arr.size();i++){
    if(tar-arr[i]>=0){
        count+=permuinfi(arr,tar-arr[i],ans+to_string(arr[i]));
    }

    
}
return count;
}
int combiinfi(vector<int> &arr,int tar,int idx,string ans){
    if(tar==0){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=idx;i<arr.size();i++){
        if(tar-arr[i]>=0){
            count+=combiinfi(arr,tar-arr[i],i,ans+to_string(arr[i]));
        }
    }
    return count;
}
int combWithoutRepetition(vector<int> &arr,int tar,int idx,string ans){
    if(tar==0){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=idx;i<arr.size();i++){          
        if(tar-arr[i]>=0){
            count+=combWithoutRepetition(arr,tar-arr[i],i+1,ans+to_string(arr[i]));
        }
    }
    return count;
}
int permuWithoutRepetition(vector<int> &arr,vector<bool> &vis,int tar,string ans){
    if(tar==0){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=0;i<arr.size();i++){
        if(tar-arr[i]>=0 && !vis[i]){
            vis[i]=true;
            count+=permuWithoutRepetition(arr,vis,tar-arr[i],ans+to_string(arr[i]));
            vis[i]=false;
        }
    }
    return count;
}
int combiInfiSubseq(vector<int> &arr,int idx,int tar,string ans){
    if(tar==0 || idx==arr.size()){
        if(tar==0){
        cout<<ans<<endl;
        return 1;
        }
        return 0;
    }
    int count=0;
    if(tar-arr[idx]>=0){
        count+=combiInfiSubseq(arr,idx+1,tar,ans);
        count+=combiInfiSubseq(arr,idx,tar-arr[idx],ans+to_string(arr[idx]));
    }
    return count;
}
int permuinfisubseq(vector<int> &arr,int idx,int tar,string ans){
    if(tar==0 || idx==arr.size()){
        if(tar==0){
            cout<<ans<<endl;
            return 1;
        }
        return 0;
    }
    int count=0;
    if(tar-arr[idx]>=0){
        count+=permuinfisubseq(arr,idx+1,tar,ans);
        count+=permuinfisubseq(arr,0,tar-arr[idx],ans+to_string(arr[idx])+" ");
    }
    return count;
}
int permuSingleSubseq(vector<int> &arr,vector<bool> &vis,int idx,int tar,string ans){
    if(tar==0 || idx==arr.size()){
        if(tar==0){
            cout<<ans<<endl;
            return 1;
        }
        return 0;
    }
    int count=0;
    if(tar-arr[idx]>=0 && !vis[idx]){
        vis[idx]=true;
        count+=permuSingleSubseq(arr,vis,0,tar-arr[idx],ans+ to_string(arr[idx])+" ");
        vis[idx]=false;
    }
    count+=permuSingleSubseq(arr,vis,idx+1,tar,ans);
    return count;
}
int combiSingleSubse(vector<int> &arr,int idx,int tar,string ans){
     if(tar==0 || idx==arr.size()){
        if(tar==0){
            cout<<ans<<endl;
            return 1;
        }
        return 0;
    }
    int count=0;
    if(tar-arr[idx]>=0){
        count+=combiSingleSubse(arr,idx+1,tar,ans);
        count+=combiSingleSubse(arr,idx+1,tar-arr[idx],ans+ to_string(arr[idx])+" ");
    }
    return count;
}
void subset(vector<int> &arr,int idx, string ans){
      cout<<ans<<endl;
    if(idx==arr.size()){
        
        return ;
    }
  
    
    for(int i=idx;i<arr.size();i++){
        subset(arr,i+1,ans+ to_string(arr[i])+" ");
    }
    
}
int queenCombi(int box,int idx,int qpsf,int tnq,string ans){
    if(qpsf==tnq){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=idx;i<box;i++){
count+=queenCombi(box,i+1,qpsf+1,tnq,ans+"b"+to_string(i)+"q"+to_string(qpsf));
    }
    return count;
}
int queenPermu(vector<bool> &box,int qpsf,int tnq,string ans){
    if(qpsf==tnq){
        cout<<ans<<endl;
        return 1;

    }
    int count=0;
    for(int i=0;i<box.size();i++){
        if(!box[i]){
            box[i]=true;
            count+=queenPermu(box,qpsf+1,tnq,ans+"b"+to_string(i)+"q"+to_string(qpsf));
            box[i]=false;
        }
    }
    
    return count;
}

int main(int args,char**argv){
    vector<int> arr={2,3,5,7};
    //cout<<permuinfi(arr,10," ")<<endl;
    //cout<<combiinfi(arr,10,0," ")<<endl;
   // cout<<combWithoutRepetition(arr,10,0," ")<<endl;
 //vector<bool> vis(arr.size(),false);
   //cout<<permuWithoutRepetition(arr,vis,10," ");
   //cout<<combiInfiSubseq(arr,0,10," ")<<endl;
   //cout<<permuinfisubseq(arr,0,10," ")<<endl;
 // vector<int> arr={1,2,3};
  //subset(arr,0," ");
 // cout<<queenCombi(5,0,0,3," ")<<endl;
 //vector<bool> box(5,false);
 //cout<<queenPermu(box,0,3," ")<<endl;
 //cout<<permuSingleSubseq(arr,vis,0,10," ")<<endl;
 cout<<combiSingleSubse(arr,0,10," ")<<endl;
}