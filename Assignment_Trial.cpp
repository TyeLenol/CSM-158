#include <iostream>
using namespace std;
int main(){
    int TotalHours,RegularHours,Overtime,RegularPay,No_of_Children;
    TotalHours=RegularHours=Overtime=RegularPay=No_of_Children=0;
    float GrossPay,OvertimePay,IncomeTax,NHIL_Levy,DistrictTax,EduFund,Net_Pay;
    GrossPay=OvertimePay=IncomeTax=NHIL_Levy=DistrictTax=EduFund=Net_Pay=0;
    cout<<"Please input the total hours worked : "<<endl;
    cin>>TotalHours;
    if (TotalHours>40)
    {
        
        Overtime=TotalHours-40;
        RegularHours=TotalHours-Overtime;
        RegularPay=RegularHours*5;
        OvertimePay=Overtime*((3/2)*5);
        GrossPay=OvertimePay+RegularPay;

    }
    else if (TotalHours<=40)
    {
        GrossPay=TotalHours*5;
    }
    cout<<"Please input the number of children one has: "<<endl;
    cin>>No_of_Children;
    if (No_of_Children>3)
    {
        EduFund=0.50*(No_of_Children-3);
    }
    IncomeTax=0.15*GrossPay;
    NHIL_Levy=0.025*GrossPay;
    DistrictTax=0.01*GrossPay;
    Net_Pay=GrossPay-(IncomeTax+NHIL_Levy+DistrictTax+EduFund);
    cout<<"The following deductions are as follows: "<<endl<<"Income Tax is $"<<IncomeTax<<endl<<"NHIL Contribution is $"<<NHIL_Levy<<endl<<"District Tax is $"<<DistrictTax<<endl<<"Educational Fund is $"<<EduFund<<endl;
    cout<<"Your Net Pay is $"<<Net_Pay<<endl;
    cout<<"Congrats! You are not broke."<<endl;


    

    
}