package com.example.karollo.themes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String id = this.randomId();
    }

    private String randomId(){
        char[] chars = "0123456789abcdefghijklmnoprstwuxyzABCDEFGHIJKLMNOPRSTWUXYZ_-".toCharArray();
        StringBuilder sb = new StringBuilder(11);
        Random random = new Random();
        for (int i = 0; i < 11; i++ ){
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }


}
