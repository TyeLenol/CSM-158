#include <iostream>
#include <cmath>
using namespace std;
int main(){
    int a,b,c,determiner,root1,root2=0;
    cout<<"Please input the numbers in the form ax^2+bx+c=0 : ";
    cin>>a,cin>>b,cin>>c;
    determiner=(b*b)-4*(a*c);
    if (determiner==0)
    {
        root1=((-b)+sqrt((b*b)-4*(a*c)))/2*a;
        cout<<"The quadratic equation has equal root "<<root1<<endl;
    }
    else if (determiner>0)
    {
        root1=((-b)+sqrt((b*b)-4*(a*c)))/2*a;
        root2=((-b)+sqrt((b*b)-4*(a*c)))/2*a;
        cout<<"The quadratic equation has real roots "<<root1<<" and "<<root2<<"."<<endl;
    }
    else
    {
        cout<<"The quadratic equation has imaginary roots."<<endl;
    return 0;
    }
    

}