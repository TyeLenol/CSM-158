#include <iostream>
#include <cmath>
using namespace std;
int main(){
int num=0;
int factorial=1;
int i=1;
cout<<"Input the number you want to find the factorial of: "<<endl;
cin>>num;
for (int i = 1; i <=num; i++)
{
    factorial=factorial*i;
}
cout<<"The factorial of "<<num<<" is "<<factorial<<"."<<endl;

}