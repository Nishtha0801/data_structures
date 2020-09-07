#include<iostream>
#include<cstring>
#include<stack>

using namespace std;
string decodeString(string s){
  string ans=" ";
  string temp=" ";
  stack<pair<string,int>> st;
  int i=0;
  while(i< s.length()){
      if(isdigit(s[i])){
      int num=0;
      while(isdigit(s[i])){
          int tempnum=s[i]-'0';
          num=num*10+ tempnum;
          i++;
      }
      st.push(make_pair(temp,num));
      temp=" ";
      }
      else if(isalpha(s[i])){
          temp+=s[i];
      }
      else if(s[i]==']'){
          pair<string,int>p=st.top();
          st.pop();
          string cur=p.first;
          for(int i=0;i<p.second;i++){
              cur+=temp;
          }
          if(s.empty()){
              ans+=cur;
              temp=" ";
          }
          else{
              temp=cur;
          }
      }
      i++;
  }
  ans+=temp;
  return ans;
}
int main(){
    cout<<decodeString("3[a2[c]]xy");
}