package com.example.alextarasyuk.anagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alextarasyuk.anagram.util.AnagramConverter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.task_text)
    TextView mTaskRext;
    @BindView(R.id.edt_input_text)
    EditText mEdtInput;
    @BindView(R.id.btn_convert)
    Button mButtonConvert;
    @BindView(R.id.tv_result)
    TextView mTvResult;
    private String LOG = this.getClass().getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mButtonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LOG, "Convert text");
                if (TextUtils.isEmpty(mEdtInput.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Please, Input text in Latin", Toast.LENGTH_LONG).show();


                } else {
                    mTvResult.setText("Initial text is:" + mEdtInput.getText().toString() +
                            "/n" + AnagramConverter.convertToAnagram(mEdtInput.getText().toString()));
                }
                mEdtInput.setText("");

            }
        });

    }
}
