package com.mr_mo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.mr_mo.annotation.FindContentViewAnnotation;
import com.mr_mo.annotation.FindViewByIdAnnotation;
import com.mr_mo.annotation.FindViewUtil;

/**
 * activity demo
 * Created by Mr-Mo on 15/7/2 16:51.
 */
@FindContentViewAnnotation(R.layout.activity_annotation)
public class AnnotationActivity extends Activity {

    @FindViewByIdAnnotation(id = R.id.tvShow, onClick = "onClickShow")
    private TextView tvShow;

    @FindViewByIdAnnotation(id = R.id.tvHello, onClick = "onClickHello")
    private TextView tvHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FindViewUtil.initView(this);
    }

    public void onClickShow() {
        Toast.makeText(getApplicationContext(), "show Mr-Mo", Toast.LENGTH_SHORT).show();
    }

    public void onClickHello() {
        Toast.makeText(getApplicationContext(), "hello Mr-Mo", Toast.LENGTH_SHORT).show();
    }
}
