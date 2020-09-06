package th.ac.su.speedcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button cal_button = findViewById(R.id.calculate_button);
        final Button clear_button = findViewById(R.id.clear_button);
        clear_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView valueText = findViewById(R.id.valueShow);
                valueText.setText("");
            }
        });
        cal_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText disText = findViewById(R.id.distanceSpace);
                EditText timeText = findViewById(R.id.timeSpace);

                String dis = disText.getText().toString()+"";
                String tim = timeText.getText().toString()+"";

                if(dis.isEmpty()||tim.isEmpty()){
                    Toast t = Toast.makeText(
                            MainActivity.this,
                            R.string.distanceandtime,
                            Toast.LENGTH_LONG
                    );
                            t.show();
                    /*Double discal = Double.parseDouble(dis);
                    Double timecal = Double.parseDouble(tim);
                    if(timecal>0){
                          double sum = discal/timecal;
                          double value = (sum*3600)/1000;
                          //value*=1000;
                          String finalValue = String.format(
                                  Locale.getDefault(),"%.2f",value
                          );
                        TextView valueTextView = findViewById(R.id.valueShow);
                        valueTextView.setText(finalValue);
                        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("SPEED CALCULATOR");
                        dialog.setPositiveButton("OK",null);
                        if(value > 80){
                                dialog.setMessage(R.string.overlimit);
                        }
                        dialog.show();
                    }
                    {
                        Toast t = Toast.makeText(
                                MainActivity.this,
                                R.string.timemustthanzero,
                                Toast.LENGTH_LONG
                        );
                        t.show();
                    }*/
                }
                else{
                    Double discal = Double.parseDouble(dis);
                    Double timecal = Double.parseDouble(tim);
                    if(timecal>0){
                        double sum = discal/timecal;
                        double value = (sum*3600)/1000;
                        //value*=1000;
                        String finalValue = String.format(
                                Locale.getDefault(),"%.2f",value
                        );
                        TextView valueTextView = findViewById(R.id.valueShow);
                        valueTextView.setText(finalValue);
                        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("SPEED CALCULATOR");
                        dialog.setPositiveButton("OK",null);
                        if(value > 80){
                            dialog.setMessage(R.string.overlimit);
                            dialog.show();
                        }

                    }
                    else{
                        Toast t = Toast.makeText(
                                MainActivity.this,
                                R.string.timemustthanzero,
                                Toast.LENGTH_LONG
                        );
                        t.show();
                    }
                    /*Toast t = Toast.makeText(
                            MainActivity.this,
                            R.string.distanceandtime+"",
                            Toast.LENGTH_LONG
                    );
                            t.show();*/
                }
            }
        });
    }
}