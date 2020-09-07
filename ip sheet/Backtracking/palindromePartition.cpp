#include<iostream>
#include<vector>
using namespace std;
bool checkPalin(string str){
    if(str.length()==1){
        return true;
    }
    int len=str.length()-1;
    for(int i=0;i<str.length();i++){
        if(str[i]!=str[len]){
            return false;
        }
      len--;
    }
    return true;
}
vector<vector<string>> addString(string &s,int index){
    int len=s.length();
    string str;
    
    vector<vector<string>>myans;

    for(int i=index;i<len;i++){
        str+=s[i];
        if(checkPalin(str)){
            if(i+1<len){
              vector<vector<string>>recAns= addString(s,i+1);
              for(int i=0;i<recAns.size();i++) {
                  vector<string>temp=recAns[i];
                  temp.push_back(str);
                  myans.push_back(temp);
              }
            }
            else if(i+1 == len){
                vector<vector<string>>baseAns;
                vector<string>base;
                base.push_back(str);
                baseAns.push_back(base);
                return baseAns;
            }
        }
    }
    return myans;
}

int main(){
    //cout<<checkPalin("acca");
    string s="geeks";
    vector<vector<string>>v;

    v = addString(s,0);
    cout<<v.size()<<endl;

     for(int i=0;i<v.size();i++){
        for(int j=v[i].size()-1;j>=0;j--){
            cout<<v[i][j]<<" ";
        }
        cout<<endl;
    }
    
    
   
    
}