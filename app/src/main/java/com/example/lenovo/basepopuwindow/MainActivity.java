package com.example.lenovo.basepopuwindow;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import com.example.lenovo.basepopuwindow.Base.BasePopupHelper;

public class MainActivity extends AppCompatActivity {
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=(Button) findViewById(R.id.bt);
        final BasePopupHelper.Builder builder = new BasePopupHelper.Builder();
        builder.context(this)
                .layout(R.layout.layout_popup)
                .anchor(bt)
                .alpha(1.0f)
                .width(ViewGroup.LayoutParams.WRAP_CONTENT)
                .height(ViewGroup.LayoutParams.WRAP_CONTENT)
                .backgroundDrawable(new ColorDrawable())
                .focusable(true)
                .position(BasePopupHelper.BOTTOM);
        final BasePopupHelper popupWindowHelper = builder.build();
        popupWindowHelper.getPopupView();
        popupWindowHelper.setOnClickListener(R.id.tv_test, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bt.setText("李振佳");
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupWindow popupWindow = popupWindowHelper.show();
            }
        });
    }
}
