package com.example.week7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    TextView text;
    EditText WriteFileName;
    EditText WriteText;
    EditText ReadFileName;
    Button btn;

    Context context = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        System.out.println(context.getFilesDir());

        WriteFileName = (EditText) findViewById(R.id.WriteFileName);
        WriteText = (EditText) findViewById(R.id.WriteText);
        ReadFileName = (EditText) findViewById(R.id.readFileName);
        btn = (Button) findViewById(R.id.WriteButton);
        text = (TextView) findViewById(R.id.textView);
    }
    public void Write(View v) {
        try {
            OutputStreamWriter writer = new OutputStreamWriter(context.openFileOutput("testi.txt", Context.MODE_PRIVATE));
            //String s = "";
            writer.write(WriteText.getText().toString());
            writer.close();
        } catch (IOException e) {
            Log.e("IOException", "Virhe");
        }finally {
            System.out.println("Kirjoitettu");
        }
    }
    public void Read(View v) {
        try {
            InputStream input = context.openFileInput(ReadFileName.getText().toString());
            BufferedReader br = new BufferedReader(new InputStreamReader(input));
            String s = "";

            while ((s = br.readLine())!= null) {
                System.out.println(s);
                text.setText(s);
            }
            input.close();
        } catch (IOException e) {
            Log.e("IOException", "Virhe");
        }finally {
            System.out.println("Luettu");
        }
    }
}

