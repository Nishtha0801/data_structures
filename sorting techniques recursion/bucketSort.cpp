#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
class Student{
    public:
       int marks;
       string name;
};
//bucket sort to sort an array of students
void bucket_sort(Student s[],int n){
    // assuming marks are in the range of 0-100
    vector<Student>v[101];
    //O(n) time
    for(int i=0;i<n;i++){
        int m=s[i].marks;
        v[m].push_back(s[i]);
    }
    // iterate over the vector and print students
    for(int i=100;i>=0;i--){
        for(vector<Student> :: iterator it=v[i].begin();it!=v[i].end();it++){
        cout<<(*it).marks<<" "<<(*it).name<<endl;
        }
    }
}
int main(){
    Student s[10000];
    int n;
    cin>>n;
    for(int i=0;i<n;i++){
        cin>>s[i].marks>>s[i].name;
    }
    bucket_sort(s,n);
}