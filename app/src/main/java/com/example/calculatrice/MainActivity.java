package com.example.calculatrice;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class MainActivity extends AppCompatActivity
        implements
        NormalFragment.OnFragmentInteractionListener ,
        ScientificFragment.OnFragmentInteractionListener {
    final int SETTINGS_ACTIVITY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

		setTheme();
        setContentView(R.layout.activity_main);

        setMode();

        Button nf = findViewById(R.id.fragment_normal);
        Button sf = findViewById(R.id.fragment_scientifique);

        nf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.mode_defaut,new NormalFragment());
                ft.commit();
            }
        });
        sf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.mode_defaut,new ScientificFragment());
                ft.commit();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings:
                startActivityForResult(new Intent(this,Settings.class),SETTINGS_ACTIVITY);
            break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SETTINGS_ACTIVITY){
            this.recreate();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onFragmentInteractionChangeTitle(String title) {
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
    }

    public void setTheme()
    {
        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        if(SP.getString("color_choices","Red").equals("Red"))
        {
            setTheme(R.style.RedTheme);
        }else{
            setTheme(R.style.BlueTheme);
        }
    }

    public  void setMode()
    {
        Fragment fragment=null;
        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        if (SP.getString("mode_choice","Normal").equals("Normal"))
        {
            fragment = new NormalFragment();
            this.openFragment(fragment);
        }
        else
        {
            fragment = new ScientificFragment();
            this.openFragment(fragment);
        }

    }
    private void openFragment(Fragment fragment){
        if (fragment!=null){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mode_defaut,fragment);
            ft.commit();
        }
    }
}
