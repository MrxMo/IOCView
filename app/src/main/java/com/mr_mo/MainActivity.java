package com.mr_mo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.mr_mo.annotation.FindContentViewAnnotation;
import com.mr_mo.annotation.FindViewByIdAnnotation;
import com.mr_mo.annotation.FindViewUtil;
/**
 * 自定义注解
 * Created by Mr-Mo on 15/7/2 16:51.
 */
@FindContentViewAnnotation(R.layout.activity_main)
public class MainActivity extends Activity {

    @FindViewByIdAnnotation(id = R.id.tvActivityDemo, onClick = "onClickActivity")
    private TextView tvShow;

    @FindViewByIdAnnotation(id = R.id.tvFragmentDemo, onClick = "onClickFragment")
    private TextView tvHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FindViewUtil.initView(this);
    }

    public void onClickActivity() {
        Intent intent = new Intent(this, AnnotationActivity.class);
        startActivity(intent);
    }

    public void onClickFragment() {
        Intent intent = new Intent(this, AnnotationFragmentActivity.class);
        startActivity(intent);
    }
}
