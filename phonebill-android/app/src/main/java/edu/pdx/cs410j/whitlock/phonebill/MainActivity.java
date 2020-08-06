package edu.pdx.cs410j.whitlock.phonebill;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int CALCULATOR_RESULT = 43;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button launchCalculator = findViewById(R.id.launchCalculator);
        launchCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
                startActivityForResult(intent, CALCULATOR_RESULT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CALCULATOR_RESULT && resultCode == RESULT_OK) {
            if (data != null) {
                if (data.hasExtra("Sum")){
                    Operation result = (Operation) data.getSerializableExtra("Sum");
                    Toast.makeText(this, "Result was " + result, Toast.LENGTH_LONG).show();
                }
                if (data.hasExtra("PhoneCall")) {
                    PhoneCall result = (PhoneCall) data.getSerializableExtra("PhoneCall");
                    Toast.makeText(this, "PhoneCall was " + result, Toast.LENGTH_LONG).show();
                }
                if (data.hasExtra("PhoneBill")) {
                    PhoneBill result = (PhoneBill) data.getSerializableExtra("PhoneBill");
                    Toast.makeText(this, "PhoneBill was " + result, Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}