package com.mr_mo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mr_mo.annotation.FindViewByIdAnnotation;
import com.mr_mo.annotation.FindViewUtil;

/**
 * Created by Mr-Mo on 15/7/2 16:51.
 */
public class AnnotationFragment extends Fragment {

    @FindViewByIdAnnotation(id = R.id.tvShow, onClick = "onClickShow")
    private TextView tvShow;

    @FindViewByIdAnnotation(id = R.id.tvHello, onClick = "onClickHello")
    private TextView tvHello;

    public AnnotationFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_annotation, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FindViewUtil.initView(this);
    }

    public void onClickShow() {
        Toast.makeText(getActivity(), "show Mr-Mo", Toast.LENGTH_SHORT).show();
    }

    public void onClickHello() {
        Toast.makeText(getActivity(), "hello Mr-Mo", Toast.LENGTH_SHORT).show();
    }
}
