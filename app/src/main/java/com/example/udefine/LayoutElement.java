package com.example.udefine;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class LayoutElement extends AppCompatActivity {
    private widgetManager widgetsManager;
    private LinearLayout mElementPreview;
    private Spinner mElementSpinner;
    private TextView mWidgetTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_element);


        // toolbar setting
        Toolbar toolbar = findViewById(R.id.layout_element_toolbar);
        setSupportActionBar(toolbar);

        mElementPreview = findViewById(R.id.element_preview);
        mWidgetTitle = findViewById(R.id.element_title);

        // attach adapter to widget type spinner
        mElementSpinner = findViewById(R.id.widget_type_spinner);
        ArrayAdapter<CharSequence> widget_type_list = ArrayAdapter.createFromResource(
                LayoutElement.this,
                R.array.widget_type_spinner,
                android.R.layout.simple_spinner_dropdown_item);
        mElementSpinner.setAdapter(widget_type_list);

        mElementSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                mElementPreview.removeAllViews();

                mElementPreview.setBackground(getResources().getDrawable(R.drawable.note_list_layout));
                widgetsManager = new widgetManager(LayoutElement.this, mElementPreview,
                        getSupportFragmentManager());

                widgetsManager.generate(position + 1, mWidgetTitle.getText().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
