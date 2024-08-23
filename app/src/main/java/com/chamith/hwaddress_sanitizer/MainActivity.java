package com.chamith.hwaddress_sanitizer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.chamith.hwaddress_sanitizer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'hwaddress_sanitizer' library on application startup.
    static {
        System.loadLibrary("hwaddress_sanitizer");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(stringFromJNI());
    }

    /**
     * A native method that is implemented by the 'hwaddress_sanitizer' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}