
package sg.edu.rp.c346.id20047223.p03_billcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText amountet;
    EditText noofpplet;
    ToggleButton svsbtn;
    ToggleButton gstbtn;
    EditText discountEt;
    RadioGroup paymentrg;
    RadioButton cash;
    RadioButton paynow;
    Button splitBtn;
    Button resetBtn;
    TextView totaltv;
    TextView eachpaytv;
    Double output;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amountet = findViewById(R.id.etAmount);
        noofpplet = findViewById(R.id.etPax);
        svsbtn = findViewById(R.id.btnSvs);
        gstbtn = findViewById(R.id.btnGST);
        discountEt = findViewById(R.id.etDiscount);
        paymentrg = findViewById(R.id.rgPayment);
        cash = findViewById(R.id.rbCash);
        paynow = findViewById(R.id.rbPaynow);
        splitBtn = findViewById(R.id.btnSplit);
        resetBtn = findViewById(R.id.btnReset);
        totaltv = findViewById(R.id.tvTotal);
        eachpaytv = findViewById(R.id.tvEach);


        svsbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String data1 = amountet.getText().toString();
                if(svsbtn.isChecked() == true) {
                    output = (Double.parseDouble(data1)) * 0.90;
                } else if (svsbtn.isChecked() == false) {
                    output = Double.parseDouble(data1);
                }
            }
        });

        gstbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String data1 = amountet.getText().toString();
                String discount = discountEt.getText().toString();
                if(gstbtn.isChecked() == true) {
                    output = (Double.parseDouble(data1)) * 0.93 * (100-(Integer.parseInt(discount)));
                } else if(gstbtn.isChecked() == false){
                    output = Double.parseDouble(data1);
                }
            }
        });

        splitBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String data1 = totaltv.getText().toString();
                String data2 = noofpplet.getText().toString();
                String perpax = String.format("%.2f", output / (Integer.parseInt(data2)));
                int checkRadioId = paymentrg.getCheckedRadioButtonId();
                totaltv.setText("Total Bill: $" + output);
                if(checkRadioId == R.id.rbCash){
                    eachpaytv.setText("Each Pays: $" + perpax);
                } else if (checkRadioId == R.id.rbPaynow){
                    eachpaytv.setText("Each Pays: $" + perpax + " via PayNow to 912345678");
                }

            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                amountet.setText("");
                noofpplet.setText("");
                discountEt.setText("");
                svsbtn.setTextOff("");
                gstbtn.setTextOff("");
                cash.setChecked(false);
                paynow.setChecked(false);
            }
        });



    }



}