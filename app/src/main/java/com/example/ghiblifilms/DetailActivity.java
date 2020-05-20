package com.example.ghiblifilms;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class DetailActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        DetailController controller = new DetailController(this);
        controller.onStart();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
