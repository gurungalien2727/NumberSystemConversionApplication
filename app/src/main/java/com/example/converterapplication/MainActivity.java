package com.example.converterapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.View;
import android.widget.Toast;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void onClick(View view) {

                EditText input = (EditText) findViewById(R.id.editText);
                Spinner from = (Spinner) findViewById(R.id.spinner1);
                Spinner to = (Spinner) findViewById(R.id.spinner2);
                TextView result = (TextView) findViewById(R.id.result);

                String f = String.valueOf(from.getSelectedItem());
                String t = String.valueOf(to.getSelectedItem());

                 if(input.getText().toString().equals("")){

                    Toast.makeText(getApplicationContext(),"Enter a number",Toast.LENGTH_LONG).show();
                    result.setText("");

                  }

                  else {

                    switch (f) {

                        case "Decimal":

                                 try {


                                   if (f.equals("Decimal") && t.equals("Decimal")) {

                                       int s = Integer.valueOf(input.getText().toString());
                                       String str = input.getText().toString();
                                       Integer.parseInt(str);
                                       result.setText(str);
                                   }

                                  else if (f.equals("Decimal") && t.equals("Binary")) {


                                    int s = Integer.valueOf(input.getText().toString());
                                    String r = Integer.toBinaryString(s);
                                    result.setText(String.valueOf(r));
                                  }

                                  else if (f.equals("Decimal") && t.equals("Octal")) {

                                    int s = Integer.valueOf(input.getText().toString());
                                    String r = Integer.toOctalString(s);
                                    result.setText(String.valueOf(r));

                                   }

                                   if (f.equals("Decimal") && t.equals("HexaDecimal")) {


                                    int s = Integer.valueOf(input.getText().toString());
                                    String r = Integer.toHexString(s);
                                    result.setText(String.valueOf(r));


                                   }
                                  }

                                  catch (Exception e) {

                                       Toast.makeText(getApplicationContext(), "Invalid Decimal Number", Toast.LENGTH_LONG).show();
                                       result.setText("");
                                 }

                                 break;





                        case "Binary":

                            try {


                                String str = input.getText().toString();
                                int len = str.length();

                                int i = 0;
                                while (i < str.length()) {

                                    if (str.charAt(i) == '0' || str.charAt(i) == '1') {

                                        i++;
                                    } else {
                                        throw new Exception();
                                    }

                                }


                                if (f.equals("Binary") && t.equals("Decimal")) {


                                        int s = Integer.valueOf(input.getText().toString());
                                        int num = s;
                                        int dec_value = 0;
                                        int base = 1;


                                        int temp = num;
                                        while (temp > 0) {
                                            int last_digit = temp % 10;
                                            temp = temp / 10;
                                            dec_value += last_digit * base;
                                            base = base * 2;
                                        }
                                        result.setText(String.valueOf(dec_value));

                                }


                                else if (f.equals("Binary") && t.equals("Binary")) {

                                    int s = Integer.valueOf(input.getText().toString());
                                    result.setText(String.valueOf(s));

                                }


                                else if (f.equals("Binary") && t.equals("Octal")) {

                                    int s = Integer.valueOf(input.getText().toString());
                                    int num = s;
                                    int dec_value = 0;
                                    int base = 1;

                                    int temp = num;
                                    while (temp > 0) {
                                        int last_digit = temp % 10;
                                        temp = temp / 10;
                                        dec_value += last_digit * base;
                                        base = base * 2;
                                    }
                                    String r = Integer.toOctalString(dec_value);
                                    result.setText(r);
                                }


                                else if (f.equals("Binary") && t.equals("HexaDecimal")) {

                                    int s = Integer.valueOf(input.getText().toString());
                                    int num = s;
                                    int dec_value = 0;
                                    int base = 1;

                                    int temp = num;
                                    while (temp > 0) {
                                        int last_digit = temp % 10;
                                        temp = temp / 10;
                                        dec_value += last_digit * base;
                                        base = base * 2;
                                    }
                                    String r = Integer.toHexString(dec_value);
                                    result.setText(r);
                                }
                            } catch (Exception e) {

                                Toast.makeText(getApplicationContext(), "Invalid Binary Number", Toast.LENGTH_SHORT).show();
                                result.setText("");
                            }

                            break;



                           case "Octal":


                            try {

                                String octal1 = input.getText().toString();

                                if (octal1 != null && !octal1.isEmpty()) {
                                    int number = Integer.parseInt(octal1);
                                    while (number > 0) {
                                        if (number % 10 <= 7) {
                                            number /= 10;
                                        } else {

                                            throw new Exception();
                                        }
                                    }
                                }


                                if (f.equals("Octal") && t.equals("Decimal")) {

                                        int oc = Integer.valueOf(input.getText().toString());
                                        int decimalNumber = 0, i = 0;

                                        while (oc != 0) {
                                            decimalNumber += (oc % 10) * Math.pow(8, i);
                                            ++i;
                                            oc /= 10;

                                        result.setText(String.valueOf(decimalNumber));

                                        }


                                }




                                else if (f.equals("Octal") && t.equals("Binary")) {

                                    int s = Integer.valueOf(input.getText().toString());
                                    int octal = s;
                                    int decimalNumber = 0, i = 0;

                                    while (octal != 0) {
                                        decimalNumber += (octal % 10) * Math.pow(8, i);
                                        ++i;
                                        octal /= 10;
                                    }

                                    String r = Integer.toBinaryString(decimalNumber);
                                    result.setText(String.valueOf(r));


                                } else if (f.equals("Octal") && t.equals("Octal")) {

                                    int s = Integer.valueOf(input.getText().toString());
                                    result.setText(String.valueOf(s));

                                }


                                else if (f.equals("Octal") && t.equals("HexaDecimal")) {

                                    int s = Integer.valueOf(input.getText().toString());
                                    int octal = s;
                                    int decimalNumber = 0, i = 0;

                                    while (octal != 0) {
                                        decimalNumber += (octal % 10) * Math.pow(8, i);
                                        ++i;
                                        octal /= 10;
                                    }

                                    String r = Integer.toHexString(decimalNumber);
                                    result.setText(String.valueOf(r));

                                }
                            }


                            catch (Exception e) {

                                Toast.makeText(getApplicationContext(), "Invalid Octal Number", Toast.LENGTH_SHORT).show();
                                result.setText("");
                            }

                            break;




                        case "HexaDecimal":

                            try{

                                String hexVal1 = input.getText().toString();

                                hexVal1=hexVal1.toUpperCase();

                                for (int i = 0; i < hexVal1.length(); i++) {

                                    char c = hexVal1.charAt(i);
                                    if (!(c >= '0' && c <= '9' || c >= 'A' && c <= 'F')) {

                                        throw new Exception();
                                    }

                                }




                                if (f.equals("HexaDecimal") && t.equals("Decimal")) {

                                    String hexVal = input.getText().toString();

                                    hexVal = hexVal.toUpperCase();
                                       int len = hexVal.length();

                                       int base = 1;

                                       int dec_val = 0;

                                       for (int i = len - 1; i >= 0; i--) {

                                           if (hexVal.charAt(i) >= '0' && hexVal.charAt(i) <= '9') {
                                               dec_val += (hexVal.charAt(i) - 48) * base;

                                               base = base * 16;
                                           } else if (hexVal.charAt(i) >= 'A' && hexVal.charAt(i) <= 'F') {
                                               dec_val += (hexVal.charAt(i) - 55) * base;
                                               base = base * 16;
                                           }


                                       result.setText(String.valueOf(dec_val));
                                   }


                               } else if (f.equals("HexaDecimal") && t.equals("Binary")) {

                                   String hexVal = input.getText().toString();
                                   hexVal = hexVal.toUpperCase();
                                   int len = hexVal.length();

                                   int base = 1;

                                   int dec_val = 0;

                                   for (int i = len - 1; i >= 0; i--) {

                                       if (hexVal.charAt(i) >= '0' && hexVal.charAt(i) <= '9') {
                                           dec_val += (hexVal.charAt(i) - 48) * base;

                                           base = base * 16;
                                       } else if (hexVal.charAt(i) >= 'A' && hexVal.charAt(i) <= 'F') {
                                           dec_val += (hexVal.charAt(i) - 55) * base;
                                           base = base * 16;
                                       }

                                   }

                                   String r = Integer.toBinaryString(dec_val);
                                   result.setText(String.valueOf(r));


                               } else if (f.equals("HexaDecimal") && t.equals("Binary")) {

                                   String hexVal = input.getText().toString();
                                   hexVal = hexVal.toUpperCase();
                                   int len = hexVal.length();

                                   int base = 1;

                                   int dec_val = 0;

                                   for (int i = len - 1; i >= 0; i--) {

                                       if (hexVal.charAt(i) >= '0' && hexVal.charAt(i) <= '9') {
                                           dec_val += (hexVal.charAt(i) - 48) * base;

                                           // incrementing base by power
                                           base = base * 16;
                                       } else if (hexVal.charAt(i) >= 'A' && hexVal.charAt(i) <= 'F') {
                                           dec_val += (hexVal.charAt(i) - 55) * base;
                                           base = base * 16;
                                       }

                                   }

                                   String r = Integer.toBinaryString(dec_val);
                                   result.setText(String.valueOf(r));


                               } else if (f.equals("HexaDecimal") && t.equals("Octal")) {

                                   String hexVal = input.getText().toString();
                                   hexVal = hexVal.toUpperCase();
                                   int len = hexVal.length();

                                   int base = 1;

                                   int dec_val = 0;

                                   for (int i = len - 1; i >= 0; i--) {

                                       if (hexVal.charAt(i) >= '0' && hexVal.charAt(i) <= '9') {
                                           dec_val += (hexVal.charAt(i) - 48) * base;

                                           // incrementing base by power
                                           base = base * 16;
                                       } else if (hexVal.charAt(i) >= 'A' && hexVal.charAt(i) <= 'F') {
                                           dec_val += (hexVal.charAt(i) - 55) * base;
                                           base = base * 16;
                                       }

                                   }

                                   String r = Integer.toOctalString(dec_val);
                                   result.setText(String.valueOf(r));


                               } else if (f.equals("HexaDecimal") && t.equals("HexaDecimal")) {

                                   String s = input.getText().toString();
                                   result.setText(String.valueOf(s));

                               }}



                               catch(Exception e){

                                   Toast.makeText(getApplicationContext(), "Invalid HexaDecimal Number", Toast.LENGTH_SHORT).show();
                                   result.setText("");



                               }


                    }

                }


        }

     }
