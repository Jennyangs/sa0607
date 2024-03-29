package com.example.sa.fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.sa.R;

public class ContainerActivity extends AppCompatActivity {
    private AFragment aFragment;
    private BFragment bFragment;

    private Button pass;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        pass = (Button) findViewById(R.id.pass);

        next = (Button) findViewById(R.id.next);

        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aFragment == null) {
                    aFragment = new AFragment();
                }
                if (bFragment == null) {
                    bFragment = new BFragment();
                }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, aFragment).commitAllowingStateLoss();


            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aFragment == null) {
                    aFragment = new AFragment();
                }
                if (bFragment == null) {
                    bFragment = new BFragment();
                }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).commitAllowingStateLoss();


            }
        });
        //實例化AFragment
        aFragment = new AFragment();
        //把AFragment添加到Activity中，記得調用commit
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container, aFragment).commitAllowingStateLoss();
    }
}
