package ac.mz.hendrickpaculet2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager = findViewById(R.id.viewpager);
        layout = findViewById(R.id.layout);

        MyAdapterPager adapter = new MyAdapterPager(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        layout.setupWithViewPager(viewPager);

    }
}