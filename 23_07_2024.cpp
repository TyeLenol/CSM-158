#include <iostream>
#include <cmath>
using namespace std;
int main(){
int num,sum=0;
int i=0;
cout<<"Please enter the number you want to check: "<<endl;
cin>>num;
for ( i = 1; i <num; i++)
{
    if (num%i==0)
    {
        sum=sum+i;
    }
}
if (sum==num)
{
    cout<<"The number "<<num<<" is perfect!";
}
else if (sum<num)
{
    cout<<"The number "<<num<<" is abundant!";
}
else
{
    cout<<"The number "<<num<<" is deficient!";
}
return 0;
}