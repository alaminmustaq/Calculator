package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int count = 0, pointcount = 0;
    String operator = "",check_decimal,operator_count;
    double firstnum, secondnum;
    boolean limit;
    TextView maintextview;
    TextView secondtextview;

    Switch aSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        maintextview = findViewById(R.id.maintextview);
        secondtextview = findViewById(R.id.secondtextview);
    }

    void operate(String op)
    {
        if (count == 1) {

            if (maintextview.getText().toString().equals("")) {
                operator_count = op;
                secondtextview.setText("" + check_decimal(firstnum) +" "+operator);

            } else {
                if (operator_count == "x") {
                    operator_count = op;
                    operator=op;
                    secondnum = Double.parseDouble(maintextview.getText().toString());
                    firstnum = firstnum * secondnum;
                    secondtextview.setText("" + check_decimal(firstnum) + " "+operator);
                    maintextview.setText("");
                    count = 1;
                } else if (operator_count == "+") {
                    operator_count = op;
                    operator=op;
                    secondnum = Double.parseDouble(maintextview.getText().toString());
                    firstnum = firstnum + secondnum;
                    secondtextview.setText("" + check_decimal(firstnum) + " "+operator);
                    maintextview.setText("");
                    count = 1;
                } else if (operator_count == "-") {
                    operator_count = op;
                    operator=op;
                    secondnum = Double.parseDouble(maintextview.getText().toString());
                    firstnum = firstnum - secondnum;
                    secondtextview.setText("" + check_decimal(firstnum) + " "+operator);
                    maintextview.setText("");
                    count = 1;
                } else if (operator_count == "/") {
                    operator_count = op;
                    operator=op;
                    secondnum = Double.parseDouble(maintextview.getText().toString());
                    if (secondnum == 0) {
                        count = 3;
                        maintextview.setText("Cannot divide by zero");
                    } else {
                        firstnum = firstnum / secondnum;
                        secondtextview.setText("" + check_decimal(firstnum) + " "+operator);
                        maintextview.setText("");
                        count = 1;
                    }
                }
            }

        } else {
            String primaryvalue = maintextview.getText().toString();
            operator = op;
            firstnum = Double.parseDouble(primaryvalue);
            secondtextview.setText("" + check_decimal(firstnum) + " "+operator);
            operator_count = operator;
            maintextview.setText("");
            count = 1;
        }
    }

    String check_decimal(double d)
    {

        String c = Double.toString(d);
        if(c.contains("."))
        {
            check_decimal = c.substring(c.indexOf(".")+1,c.length());
            if(check_decimal.equals("0"))
            {
                check_decimal = c.substring(0,c.indexOf("."));

            }
            else
            {
                check_decimal = c;
            }
        }
        return check_decimal;
    }

    boolean limit_input()
    {
        if(maintextview.length() == 15)
        {
            Toast.makeText(this, "Maximum number limit is 15", Toast.LENGTH_SHORT).show();
            limit = true;
        }
        else
        {
            limit = false;
        }
        return limit;
    }

    public void result(View view) {
        if (count == 3) {
            maintextview.setText("0");
            secondtextview.setText("");
            operator = "";
            count = 0;
        }
        if(maintextview.getText().toString().equals(""))
        {

        }
        else if (operator.equals("+")) {
            pointcount = 0;
            if (count == 1) {
                secondnum = Double.parseDouble(maintextview.getText().toString());
                double result = firstnum + secondnum;
                secondtextview.setText("" + check_decimal(firstnum) + " "+operator+" "+ check_decimal(secondnum));
                maintextview.setText("" + check_decimal(result));
                count = 2;
            } else {
                firstnum = Double.parseDouble(maintextview.getText().toString());
                double result = firstnum + secondnum;
                secondtextview.setText("" + check_decimal(firstnum) +" "+ operator +" "+ check_decimal(secondnum));
                maintextview.setText("" + check_decimal(result));
            }
        } else if (operator.equals("-")) {
            pointcount = 0;
            if (count == 1) {
                secondnum = Double.parseDouble(maintextview.getText().toString());
                double result = firstnum - secondnum;
                secondtextview.setText("" + check_decimal(firstnum) + " "+operator +" "+ check_decimal(secondnum));
                maintextview.setText("" + check_decimal(result));
                count = 2;
            } else {
                firstnum = Double.parseDouble(maintextview.getText().toString());
                double result = firstnum - secondnum;
                secondtextview.setText("" + check_decimal(firstnum) + " "+operator+" " + check_decimal(secondnum));
                maintextview.setText("" + check_decimal(result));
            }
        } else if (operator.equals("x")) {
            pointcount = 0;
            if (count == 1) {
                secondnum = Double.parseDouble(maintextview.getText().toString());
                double result = firstnum * secondnum;
                secondtextview.setText("" + check_decimal(firstnum) + " "+operator+" " + check_decimal(secondnum));
                maintextview.setText("" + check_decimal(result));
                count = 2;
            } else {
                firstnum = Double.parseDouble(maintextview.getText().toString());
                double result = firstnum * secondnum;
                secondtextview.setText("" + check_decimal(firstnum) + " "+operator+" " + check_decimal(secondnum));
                maintextview.setText("" + check_decimal(result));
            }
        } else if (operator.equals("/")) {
            pointcount = 0;
            if (count == 1) {
                secondnum = Double.parseDouble(maintextview.getText().toString());
                if (secondnum != 0) {
                    double result = firstnum / secondnum;
                    secondtextview.setText("" + check_decimal(firstnum) + " "+operator+" " + check_decimal(secondnum));
                    maintextview.setText("" + check_decimal(result));
                    count = 2;

                } else {
                    maintextview.setText("Cannot divide by zero");
                    count = 3;
                }
            } else {
                firstnum = Double.parseDouble(maintextview.getText().toString());
                double result = firstnum / secondnum;
                secondtextview.setText("" + check_decimal(firstnum) + " "+operator+" " + check_decimal(secondnum));
                maintextview.setText("" + check_decimal(result));
            }
        }

    }

    public void btnsum(View view) {
        if (count != 3) {
            operator = "+";
            operate(operator);
            pointcount = 0;
        }
    }

    public void btnsub(View view) {
        if (count != 3) {
            operator = "-";
            operate(operator);
            pointcount = 0;
        }
    }

    public void btnmul(View view) {
        if (count != 3) {
            operator = "x";
            operate(operator);
            pointcount = 0;
        }
    }

    public void btndiv(View view) {
        if (count != 3) {
            operator = "/";
            operate(operator);
            pointcount = 0;
        }
    }

    public void btnbackspace(View view) {
        String primaryvalue = maintextview.getText().toString();
        if (!(primaryvalue.equals("0") || primaryvalue.equals(""))) {

            String Secondaryvalue = primaryvalue.substring(primaryvalue.length() - 1,primaryvalue.length());

            primaryvalue = primaryvalue.substring(0, primaryvalue.length() - 1);

            maintextview.setText("" + primaryvalue);
            if (primaryvalue.equals("")) {
                maintextview.setText("0");
            }
            if(Secondaryvalue.equals("."))
            {
                pointcount = 0;
            }
        }

    }

    public void btnpercent(View view) {
        if (count != 3 && count != 1) {

            String primaryvalue = maintextview.getText().toString();
            firstnum = Double.parseDouble(primaryvalue);
            firstnum = firstnum / 100;
            secondtextview.setText("" + primaryvalue + "%");

            maintextview.setText("" + check_decimal(firstnum));
        }
    }

    public void btnpoint(View view) {

        if (pointcount != 1 && count != 2 && count != 3) {
            if (count == 1 && maintextview.getText().toString().equals("")) {
                maintextview.setText("0");
            }
            String primaryvalue = maintextview.getText().toString();

            maintextview.setText("" + primaryvalue + ".");
            pointcount = 1;
        }
    }

    public void btnpm(View view) {
        if (count != 3 && count != 1) {
            String primaryvalue = maintextview.getText().toString();
            firstnum = Double.parseDouble(primaryvalue);

            maintextview.setText("" + check_decimal((firstnum * (-1))));
        }
    }

    public void clr(View view) {
        maintextview.setText("0");
        secondtextview.setText("");
        operator = "";
        count = 0;
        pointcount = 0;
    }
    public void number(String num)
    {
        if (count == 2 || count == 3) {

            maintextview.setText("0");
            secondtextview.setText("");
            operator = "";
            count = 0;
        }
        String primaryvalue = maintextview.getText().toString();
        if (primaryvalue.equals("0")) {
            maintextview.setText(num);
        } else {
            maintextview.setText("" + primaryvalue + num);
        }
    }
    public void btn0(View view) {
        if(!limit_input()) {
            number("0");
        }
    }

    public void btn1(View view) {
        if(!limit_input()) {
            number("1");
        }
    }

    public void btn2(View view) {
        if(!limit_input()) {
            number("2");
        }
    }

    public void btn3(View view) {
        if(!limit_input()) {
            number("3");
        }
    }

    public void btn4(View view) {
        if(!limit_input()) {
            number("4");
        }
    }

    public void btn5(View view) {
        if(!limit_input()) {
            number("5");
        }
    }

    public void btn6(View view) {
        if(!limit_input()) {
            number("6");
        }
    }

    public void btn7(View view) {
        if(!limit_input())
        {
            number("7");
        }
    }

    public void btn8(View view) {
        if(!limit_input()) {
            number("8");
        }
    }

    public void btn9(View view) {
        if (!limit_input()) {

            number("9");
        }
    }
}