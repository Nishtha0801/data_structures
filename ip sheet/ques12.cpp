#include<iostream>
#include<vector>
using namespace std;
vector<vector<int>> rotate(vector<vector<int>> &matrix,int n){
    for(int r=0;r<matrix.size();r++){
        for(int c=r+1;c<matrix[0].size();c++){
            int temp=matrix[r][c];
            matrix[r][c]=matrix[c][r];
            matrix[c][r]=temp;
        }
    }
    
}
int main(){
    int T;
    cin>>T;
    for(int i=0;i<T;i++){
        int n;
        cin>>n;
        vector<vector<int>>matrix;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cin>>matrix[i][j];
            }
        }

    }
}