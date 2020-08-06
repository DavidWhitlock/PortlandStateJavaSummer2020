package edu.pdx.cs410j.whitlock.phonebill;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int CALCULATOR_RESULT = 43;
    private ArrayAdapter<Double> results;

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

        ListView resultsView = findViewById(R.id.results);
        results = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        resultsView.setAdapter(results);
    }

    private void saveResults() throws IOException {
        File dir = getDataDir();
        File file = new File(dir, "results.txt");
        try (PrintWriter pw = new PrintWriter(new FileWriter(file), true)) {
            for (int i = 0; i < results.getCount(); i++) {
                pw.println(results.getItem(i));
            }
            pw.flush();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CALCULATOR_RESULT && resultCode == RESULT_OK) {
            if (data != null) {
                if (data.hasExtra("Sum")){
                    Operation result = (Operation) data.getSerializableExtra("Sum");
                    Toast.makeText(this, "Result was " + result, Toast.LENGTH_LONG).show();
                    results.add(result.getValue());
                    try {
                        saveResults();
                    } catch (IOException e) {
                        Toast.makeText(this, "While writing file " + e.getMessage(), Toast.LENGTH_LONG).show();
                    }

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