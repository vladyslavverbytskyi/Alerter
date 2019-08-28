package com.tapadoo.alerter;

import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;

/**
 * Mock Activity for Testing
 *
 * @author Kevin Murphy
 * @since 5/10/2016
 */
public class MockActivity extends AppCompatActivity implements WindowProvider {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mock);
    }

    @NotNull
    @Override
    public Window provideWindow() {
        return getWindow();
    }
}
