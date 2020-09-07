#include<iostream>
#include<queue>
using namespace std;
int main(){
    queue<char>q;
    int freq[27]={0};
    // running a stream until a "."
    char ch;
    cin>>ch;
    while(ch!='.'){
        //insert in q and f table
        q.push(ch);
        freq[ch-'a']++;
      while(!q.empty()){
          int idx=q.front()-'a';
          if(freq[idx]>1){
              q.pop();
          }
          else{
              cout<<q.front()<<endl;
              break;
          }
      }
      // q is empty
      if(q.empty()){
          cout<<"-1"<<endl;
      }
      cin>>ch;
    }
  return 0;
}