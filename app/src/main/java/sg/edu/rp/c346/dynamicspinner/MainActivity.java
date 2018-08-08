package sg.edu.rp.c346.dynamicspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spin1, spin2;
    Button btnUpdate;
    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spin1 = findViewById(R.id.spinner);
        spin2 = findViewById(R.id.spinner2);
        btnUpdate = findViewById(R.id.buttonUpdate);

        alNumbers = new ArrayList<>();
        /*
        alNumbers.add("2");
        alNumbers.add("4");
        alNumbers.add("6");
        */
        final String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
        alNumbers.addAll(Arrays.asList(strNumbers));

        aaNumbers = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alNumbers);
        spin2.setAdapter(aaNumbers);

        /*
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = spin1.getSelectedItemPosition();
                alNumbers.clear();
                if (pos == 1){
                    String[] strNumbers = getResources().getStringArray(R.array.odd_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                }
                else if (pos == 0){
                    String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                }
                
            }
        });*/


        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                alNumbers.clear();
                if (position==0){
                    String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                    spin2.setSelection(2);
                }
                else if (position==1){
                    String[] strNumbers = getResources().getStringArray(R.array.odd_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                    spin2.setSelection(1);
                }
                aaNumbers.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
