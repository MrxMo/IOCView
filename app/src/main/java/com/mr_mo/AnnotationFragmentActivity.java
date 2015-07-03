package com.mr_mo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.mr_mo.annotation.FindContentViewAnnotation;
import com.mr_mo.annotation.FindViewUtil;

/**
 * Created by Mr-Mo on 15/7/2 16:51.
 */
@FindContentViewAnnotation(R.layout.activity_fragment_contain)
public class AnnotationFragmentActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FindViewUtil.initView(this);
    }
}
