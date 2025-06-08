#include<iostream>
using namespace std;
int main(){
    double maisonry_price=67.89;
    bool Int_light=true;
    bool Ext_light=false;
    bool light_switch;
    char initails[4]="LAM";
    char sole_initial='M';
    int A=6;
    int B=6;
    int C=double(9)/2;
    int D=9.0/2;
    cout<<C<<endl<<D<<endl;

    cout<<++A<<endl<<B++<<endl<<B<<endl;
    cout<<maisonry_price<<endl<<initails<<endl<<sole_initial<<endl;
    if ((Int_light==true)&&(Ext_light==true))
    {
        light_switch=false;
        cout<<"The light switch is off! Please turn off one of the lights or turn on one of them to turn it back on."<<endl;
    }
    else if ((Int_light==false)&&(Ext_light==false))
    {
       light_switch=false;
        cout<<"The light switch is off! Please turn off one of the lights or turn on one of them to turn it back on."<<endl;
    }
    else
    {
         light_switch=true;
                cout<<"The light switch is on! Please turn on the other light or turn off the active one to turn it off."<<endl;
    }
    
    
    
    
    
    
    
    

}