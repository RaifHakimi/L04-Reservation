package sg.edu.rp.c346.id22016635.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText firstname;
    EditText lastname;
    EditText number;
    EditText pax;
    CheckBox smokeBox;
    TimePicker time;
    DatePicker date;
    Button cfm;
    Button reset;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstname = findViewById(R.id.tvFirst);
        lastname = findViewById(R.id.tvLast);
        number = findViewById(R.id.tvNumber);
        pax = findViewById(R.id.tvPax);
        smokeBox = findViewById(R.id.smokeBox);
        time = findViewById(R.id.timePicker);
        date = findViewById(R.id.datePicker);
        cfm = findViewById(R.id.btnBook);
        reset = findViewById(R.id.btnReset);
        time.setCurrentHour(19);
        time.setCurrentMinute(30);
        date.updateDate(2020,5,1);

        cfm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (firstname.getText().length() != 0 && lastname.getText().length() != 0 && number.getText().length() != 0 && pax.getText().length() != 0 && Integer.parseInt(pax.getText().toString()) != 0) {
                    if (number.length() == 8) {
                        String hour = "";
                        String min = "";
                        String smoke = "";
                        String fullname = firstname.getText().toString() + " " + lastname.getText().toString();
                        if(time.getCurrentHour()<10 && time.getCurrentHour() >-1){
                            hour = "0";
                        }
                        if(time.getCurrentMinute()<10 && time.getCurrentMinute()> -1){
                            min = "0";
                        }
                        if(smokeBox.isChecked()){
                            smoke = "(Smoking area)";
                        }
                        String sumTime = hour + time.getCurrentHour() + ":" + min + time.getCurrentMinute();

                        String dateSum = date.getDayOfMonth() + "/" + (date.getMonth()+1) + "/" + date.getYear();

                        Toast.makeText(getApplicationContext(), String.format("Table for %s and %s other(s) booked on %s at %s %s.",fullname,pax.getText().toString(),dateSum, sumTime, smoke  ), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Please insert a proper Mobile Number", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(getApplicationContext(), "Requirements not filled", Toast.LENGTH_SHORT).show();
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstname.setText("");
                lastname.setText("");
                number.setText("");
                pax.setText("");
                smokeBox.setChecked(false);
                time.setCurrentHour(19);
                time.setCurrentMinute(30);
                date.updateDate(2020,5,1);

            }
        });


    }
}