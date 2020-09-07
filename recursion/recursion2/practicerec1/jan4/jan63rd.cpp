#include<iostream>
#include<vector>
#define vi vector<int>
#define vii vector<vi>
#define vb vector<bool>
#define vbb vector<vb>
using namespace std;
int queenCombi(int box,int lqpl,int tnq,int qpsf,string ans){        //combination widout repetition
    if(qpsf==tnq){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=lqpl;i<box;i++){
        count+=queenCombi(box,i+1,tnq,qpsf+1,ans+"b"+to_string(i)+"q"+to_string(qpsf));
        
    }
    return count;
}
int queenpermu(vector<bool> &box,int lqpl,int tnq,int qpsf,string ans){
    if(qpsf==tnq){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=0;i<box.size();i++){
        if(!box[i]){
        box[i]=true;
count+=queenpermu(box,0,tnq,qpsf+1,ans+"b"+to_string(i)+"q"+to_string(qpsf));
      box[i]=false;
    }
    }
    return count;
}
queenCombiSubse(vector<bool> &box,int lqpl,int qpsf,int tnq,string ans){
    if(qpsf==tnq || lqpl==box.size()){
        if(qpsf==tnq){
            cout<<ans<<endl;
            return 1;
        }
        return 0;
    }
    int count=0;
    count+=queenCombiSubse(box,lqpl+1,qpsf,tnq,ans);
    count+=queenCombiSubse(box,lqpl+1,qpsf+1,tnq,ans+"b"+ to_string(lqpl)+"q"+to_string(qpsf));
    return count;
}
 int queenPermuSubse(vector<bool> &box,int lqpl,int qpsf,int tnq,string ans){
     if(qpsf==tnq || lqpl==box.size()){
        if(qpsf==tnq){
            cout<<ans<<endl;
            return 1;
        }
        return 0;
    }
    int count=0;
    if(!box[lqpl]){
        box[lqpl]=true;
        count+=queenPermuSubse(box,0,qpsf+1,tnq,ans+"b"+to_string(lqpl)+"q"+to_string(qpsf));
        box[lqpl]=false;
    }
    count+=queenPermuSubse(box,lqpl+1,qpsf,tnq,ans);
    return count;
}
int queen2DCombi(vector<vector<bool>> &board,int lqpl,int qpsf,int tnq,string ans){
    if(qpsf==tnq){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=lqpl;i<board.size()*board[0].size();i++){
        int x=i/board[0].size();
        int y=i%board[0].size();
        count+=queen2DCombi(board,i+1,qpsf+1,tnq,ans+"("+to_string(x)+","+to_string(y)+")");
    }
    return count;
}
int queen2DPermu(vector<vector<bool>> &board,int qpsf,int tnq,string ans){
    if(qpsf==tnq){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=0;i<board.size()*board[0].size();i++){
         int x=i/board[0].size();
        int y=i%board[0].size();
        if(!board[x][y]){
        board[x][y]=true;
        
       
        count+=queen2DPermu(board,qpsf+1,tnq,ans+"("+to_string(x)+","+to_string(y)+")");
        board[x][y]=false;
        }
    }
    return count;
}
// 7th jan 20    combination n queen
bool isValidSpot(vector<vector<bool>> &board,int x,int y){
    if(x<0|| y<0 || x>=board.size() || y>=board[0].size()){
        return false;
    }
    return true;
}
bool isQueenSafe(vector<vector<bool>> &board,int x,int y){
    int dir[4][2]={{0,-1},{-1,-1},{-1,0},{-1,1}};
    for(int i=0;i<4;i++){
        for(int rad=1;rad<=max(board.size(),board[0].size());rad++){    // or for(int rad=1;rad<=max(board.size(),board[0].size();rad++))
            int r=x+rad*dir[i][0];
            int c=y+rad*dir[i][1];
            if((isValidSpot(board,r,c)) && (board[r][c])){
                return false;
            }
        }
    }
    return true;

}
int nqueenCombi(vector<vector<bool>> &board,int idx,int qpsf,int tnq,string ans){
    if(qpsf==tnq){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=idx;i<board.size()*board[0].size();i++){
         int x=i/board[0].size();
        int y=i%board[0].size();
        if(isQueenSafe(board,x,y)){
            board[x][y]=true;
            count+=nqueenCombi(board,i+1,qpsf+1,tnq,ans+"("+to_string(x)+","+to_string(y)+")");
            board[x][y]=false;
        }
    }
    return count;
}
// permutation nqueen
bool isQueenSafeToPlace(vector<vector<bool>> &board,int x,int y){
    int dir[8][2]={{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
    for(int i=0;i<8;i++){
        for(int rad=1;rad<=max(board.size(),board[0].size());rad++){    // or for(int rad=1;rad<=max(board.size(),board[0].size();rad++))
            int r=x+rad*dir[i][0];
            int c=y+rad*dir[i][1];
            if((isValidSpot(board,r,c)) && (board[r][c])){
                return false;
            }
        }
    }
    return true;

}
int nqueenPermu(vector<vector<bool>> &board,int idx,int qpsf,int tnq,string ans){
    if(qpsf==tnq){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=0;i<board.size()*board[0].size();i++){
         int x=i/board[0].size();
        int y=i%board[0].size();
        if(isQueenSafeToPlace(board,x,y) && !board[x][y]){
            board[x][y]=true;
            count+=nqueenPermu(board,0,qpsf+1,tnq,ans+"("+to_string(x)+","+to_string(y)+")");
            board[x][y]=false;
        }
    }
    return count;
}
int nqueen (int r,int tnq,vb &col,vb &diag,vb &adiag,string ans){      //r=row
    int n=col.size();
    if(r==n || tnq==0){
        if(tnq==0){
            cout<<ans<<endl;
            return 1;
        }
        return 0;
    }
    int count=0;
    for(int c=0;c<n;c++){
        if(!col[c] && !diag[r+c] && !adiag[r-c+n-1]){
            col[c]=true;
            diag[r+c]=true;
            adiag[r-c+n-1]=true;
            count+=nqueen(r+1,tnq-1,col,diag,adiag,ans+"("+to_string(r)+","+to_string(c)+")");
            col[c]=false;
            diag[r+c]=false;
            adiag[r-c+n-1]=false;
        }
    }
    return count;
}
int nqueenBits(int n,int &col,int &diag,int &adiag,int r,int tnq,string ans){      //r=row
    
    if(r==n || tnq==0){
        if(tnq==0){
            cout<<ans<<endl;
            return 1;
        }
        return 0;
    }
    int count=0;
    for(int c=0;c<n;c++){
        int w=1<<c;
        int x=1<<(r+c);
        int y=1<<(r-c+n-1);
        if(!(col&w) && !(diag&x) && !(adiag&y)){
            col^=w;    //xor
            diag^=x;
            adiag^=y;
            count+=nqueenBits(n,col,diag,adiag,r+1,tnq-1,ans+"("+to_string(r)+","+to_string(c)+")");
            col^=w;    //xor
            diag^=x;
            adiag^=y;
        }
    }
    return count;
}
int main(int args,char**argv){
    //cout<<queenCombi(5,0,3,0," ")<<endl;
  //  vector<bool> box(5,false);
   // cout<<queenpermu(box,0,3,0," ")<<endl;
    //vector<vector<bool>>board(4,vector<bool>(4,false));
    //cout<<queen2DCombi(board,0,0,4," ")<<endl;
    //cout<<queen2DPermu(board,0,4," ")<<endl;
  //  cout<<nqueenCombi(board,0,0,4," ")<<endl;
  //  cout<<nqueenPermu(board,0,0,4," ")<<endl;
  //cout<<queenCombiSubse(box,0,0,3," ")<<endl;
 // cout<<queenPermuSubse(box,0,0,3," ")<<endl;
 int r=4;
 int c=4;
 //vb col(c,false);
 //vb diag(r+c-1,false);
 //vb adiag(r+c-1,false);
 //cout<<nqueen(0,4,col,diag,adiag," ")<<endl;
 int col=0;
 int diag=0;
 int adiag=0;
 cout<<nqueenBits(4,col,diag,adiag,0,4," ")<<endl;
}