package com.mr_mo.annotation;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 注解处理器工具类
 * Created by Mr-Mo on 15/7/2 14:17.
 */
public class FindViewUtil {

    private FindViewUtil() {
    }

    public static void initView(Object object) {
        initContentView(object);
        initComponentView(object);
    }

    /**
     * 初始化setContentView资源布局
     *
     * @param object
     */
    private static void initContentView(Object object) {

        if (object instanceof Activity) {

            Class clazz = object.getClass();
            FindContentViewAnnotation contentView = (FindContentViewAnnotation) clazz.getAnnotation(FindContentViewAnnotation.class);
            if (contentView != null) {
                try {
                    int resId = contentView.value();
//                activity.setContentView(resId);
                    Method setContentViewMethod = clazz.getMethod("setContentView", int.class);
                    setContentViewMethod.invoke(object, resId);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 初始化控件
     *
     * @param object
     */
    private static void initComponentView(final Object object) {
        try {
            final Class clazz = object.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                FindViewByIdAnnotation viewByIdAnnotation = field.getAnnotation(FindViewByIdAnnotation.class);
                if (viewByIdAnnotation != null) {
                    int resId = viewByIdAnnotation.id();
                    final String onClick = viewByIdAnnotation.onClick();
                    Object view;
                    if (object instanceof Fragment) {
                        Method getViewMethod = clazz.getMethod("getView");
                        View rootView = (View) getViewMethod.invoke(object);
                        view = rootView.findViewById(resId);
                    } else {
                        Method findViewByIdMethod = clazz.getMethod("findViewById", int.class);
                        view = findViewByIdMethod.invoke(object, resId);
                    }

                    field.setAccessible(true);
                    field.set(object, view);

                    if (onClick != null && onClick.trim().length() > 0) {
                        Object objectField = field.get(object);
                        if (objectField instanceof View) {
                            final Method onClickMethod = clazz.getMethod(onClick);
                            View viewItem = (View) objectField;
                            viewItem.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    try {
                                        onClickMethod.setAccessible(true);
                                        onClickMethod.invoke(object);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
