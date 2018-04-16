package com.dzm.loader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.dzm.loader.lod.MyServicesLoader;
import com.dzm.loader.lod.PropertiesLoader;
import com.dzm.loader.service.TestService;

import java.util.ServiceLoader;

public class MainActivity extends AppCompatActivity {

    PropertiesLoader propertiesLoader = new PropertiesLoader("assets/services/data.properties");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),propertiesLoader.getProperty("ip"),Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.bt_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),MyServicesLoader.getService(TestService.class).test() + "    hashcode: "+MyServicesLoader.getService(TestService.class).hashCode(),Toast.LENGTH_SHORT).show();
            }
        });
        ServiceLoader<TestService> services = ServiceLoader.load(TestService.class);
        services.iterator();


    }
}
