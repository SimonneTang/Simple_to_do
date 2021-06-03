package sg.edu.rp.c346.id20025732.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText tasket;
    Button addbtn;
    Button clearbtn;
    ListView tasklv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tasket = findViewById(R.id.editTextenterTask);
        addbtn = findViewById(R.id.buttonadd);
        clearbtn = findViewById(R.id.buttonclear);
        tasklv = findViewById(R.id.ListviewToDo);

        ArrayList<String> altodo ;
        ArrayAdapter<String> aatodo;

        altodo = new ArrayList<>();

        aatodo = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, altodo);
        tasklv.setAdapter(aatodo);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String todostring = tasket.getText().toString();
                altodo.add(todostring);
                aatodo.notifyDataSetChanged();
                tasket.setText(null);
            }
        });

        clearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aatodo.clear();
                aatodo.notifyDataSetChanged();
            }
        });
    }
}