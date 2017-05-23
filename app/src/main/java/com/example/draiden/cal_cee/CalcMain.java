package com.example.draiden.cal_cee;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CalcMain extends Activity {

    double a, b;
    String temp="",displaystring;
    private enum Operator{Add,Subtract,Multiply,Divide,Modulo,Equal}
    Operator ActiveOperator;
    boolean isFirstEntry=true, lastEntryisNumber=false, isFirstFullStop=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_main);
        DisplaytoString();
    }

    void DisplaytoString()
    {
        TextView d = (TextView)findViewById(R.id.display);
        if (isFirstEntry)
        {
            d.setText(temp);
        }
        else
        {
            displaystring=a+" "+DisplayOperator(ActiveOperator)+" "+temp;
            d.setText(displaystring);
        }
    }


    double Add(double a, double b) {return a + b;}

    double Subtract(double a, double b){return a-b;}

    double Multiply(double a, double b){return a*b;}

    double Divide(double a, double b) {
        if (b == 0) {
            Toast.makeText(this, "Can't divide by zero!!", Toast.LENGTH_SHORT).show();
            return a;
        }
        else
            return a/b;
    }

    double Modulo(double a, double b){return a%b;}

    void ExecuteOperator(Operator AO)
    {
        switch (AO)
        {
            case Add:
                a=Add(a,b);
                break;
            case Subtract:
                a=Subtract(a,b);
                break;
            case Multiply:
                a=Multiply(a,b);
                break;
            case Divide:
                a=Divide(a,b);
                break;
            case Modulo:
                a=Modulo(a,b);
                break;
            case Equal:
                break;
            default:
                break;
        }
    }

    char DisplayOperator(Operator AO)
    {
        switch (AO)
        {
            case Add:
                return '+';
            case Subtract:
                return '-';
            case Multiply:
                return 'X';
            case Divide:
                return '/';
            case Modulo:
                return '%';
            case Equal:
                return ' ';
            default:
                return ' ';
        }
    }

    void OperatorButtonProcess(Operator AO)
    {
        if (isFirstEntry)
        {
            if (lastEntryisNumber)
                ifFirstEntry(AO);
        }
        else {
            if (lastEntryisNumber)
                Execute(AO);
            else
            {
                if (!AO.equals(Operator.Equal))
                {
                    ActiveOperator=AO;
                    lastEntryisNumber=false;
                    DisplaytoString();
                }
            }
        }
    }

    void Execute(Operator AO)
    {
        b=Double.parseDouble(temp);
        lastEntryisNumber=false;
        isFirstFullStop=true;
        ExecuteOperator(ActiveOperator);
        temp="";
        ActiveOperator=AO;
        DisplaytoString();
    }

    /*void ExecuteEqual()
    {
        b=Double.parseDouble(temp);
        ExecuteOperator(ActiveOperator);
        temp="";
        TextView d = (TextView)findViewById(R.id.display);
        displaystring=String.valueOf(a);
        d.setText(displaystring);

    }*/

    void ifFirstEntry(Operator AO)
    {
        isFirstEntry=false;
        a=Double.parseDouble(temp);
        temp="";
        lastEntryisNumber=false;
        isFirstFullStop=true;
        ActiveOperator=AO;
        DisplaytoString();
    }

    public void clickC(View v)
    {
        temp="";
        DisplaytoString();
    }

    public void clickAC(View v)
    {
        temp="";
        a=0;
        b=0;
        isFirstEntry=true;
        DisplaytoString();
    }

    public void clickModulo(View v)
    {
        OperatorButtonProcess(Operator.Modulo);
    }

    public void clickDivide(View v)
    {
        OperatorButtonProcess(Operator.Divide);
    }

    public void clickMultiply(View v)
    {
        OperatorButtonProcess(Operator.Multiply);
    }

    public void clickSubtract(View v)
    {
        OperatorButtonProcess(Operator.Subtract);
    }

    public void clickAdd(View v)
    {
        OperatorButtonProcess(Operator.Add);
    }

    public void clickEqual(View v)
    {
        OperatorButtonProcess(Operator.Equal);
    }

    public void clickNine(View v)
    {
        temp+='9';
        lastEntryisNumber=true;
        DisplaytoString();
    }

    public void clickEight(View v)
    {
        temp+='8';
        lastEntryisNumber=true;
        DisplaytoString();
    }

    public void clickSeven(View v)
    {
        temp+='7';
        lastEntryisNumber=true;
        DisplaytoString();
    }

    public void clickSix(View v)
    {
        temp+='6';
        lastEntryisNumber=true;
        DisplaytoString();
    }

    public void clickFive(View v)
    {
        temp+='5';
        lastEntryisNumber=true;
        DisplaytoString();
    }

    public void clickFour(View v)
    {
        temp+='4';
        lastEntryisNumber=true;
        DisplaytoString();
    }

    public void clickThree(View v)
    {
        temp+='3';
        lastEntryisNumber=true;
        DisplaytoString();
    }

    public void clickTwo(View v)
    {
        temp+='2';
        lastEntryisNumber=true;
        DisplaytoString();
    }

    public void clickOne(View v)
    {
        temp+='1';
        lastEntryisNumber=true;
        DisplaytoString();
    }

    public void clickZero(View v)
    {
        temp+='0';
        lastEntryisNumber=true;
        DisplaytoString();
    }

    public void clickFullStop(View v)
    {
        if (isFirstFullStop)
        {
            if (temp.equals(""))
            {
                temp="0.";
                isFirstFullStop=false;
                DisplaytoString();
            }
            else
            {
                temp+='.';
                isFirstFullStop=false;
                DisplaytoString();
            }
        }
    }
}