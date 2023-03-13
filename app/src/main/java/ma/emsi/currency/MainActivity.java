package ma.emsi.currency;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner s1;
    Spinner s2;
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    EditText e1;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s1=findViewById(R.id.s1);
        s2=findViewById(R.id.s2);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
        e1=findViewById(R.id.e1);
        btn=findViewById(R.id.btn);

        String[] from = {"DH","USD","EURO"};
        ArrayAdapter ad = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        s1.setAdapter(ad);

        String[] to = {"DH","USD","EURO"};
        ArrayAdapter ad1 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,to);
        s2.setAdapter(ad1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double rlt;
                Double amt = Double.parseDouble(e1.getText().toString());

                if(s1.getSelectedItem().toString() == "DH" && s2.getSelectedItem().toString() == "USD")
                {
                    rlt = amt * 0.097;
                    t4.setText(rlt+ " USD");
                } else if (s1.getSelectedItem().toString() == "DH" && s2.getSelectedItem().toString() == "EURO") {
                    rlt = amt * 0.091;
                    t4.setText(rlt+ " EURO");
                } else if (s1.getSelectedItem().toString() == "USD" && s2.getSelectedItem().toString() == "DH") {
                    rlt = amt * 10.34;
                    t4.setText(rlt+ " DH");
                } else if (s1.getSelectedItem().toString() == "USD" && s2.getSelectedItem().toString() == "EURO") {
                    rlt = amt * 0.94;
                    t4.setText(rlt+ " EURO");
                } else if (s1.getSelectedItem().toString() == "EURO" && s2.getSelectedItem().toString() == "DH") {
                    rlt = amt * 11.01;
                    t4.setText(rlt+ " DH");
                } else if (s1.getSelectedItem().toString() == "EURO" && s2.getSelectedItem().toString() == "USD") {
                    rlt = amt * 1.06;
                    t4.setText(rlt+ " USD");
                }
            }
        });
    }
}