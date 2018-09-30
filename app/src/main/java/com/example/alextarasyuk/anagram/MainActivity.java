package com.example.alextarasyuk.anagram;

import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
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
import com.example.alextarasyuk.anagram.util.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.task_text)
    public TextView mTaskRext;
    @BindView(R.id.edt_input_text)
    public EditText mEdtInput;
    @BindView(R.id.btn_convert)
    public Button mButtonConvert;
    @BindView(R.id.tv_result)
    public TextView mTvResult;
    private String LOG = this.getClass().getSimpleName();


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (savedInstanceState != null) {

            mTvResult.setText(savedInstanceState.getString(Constants.RESULT_TEXT_STATE));
        }
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        mButtonConvert.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                Timber.d("Buttom convert is clicked");
                if (TextUtils.isEmpty(mEdtInput.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Please, Input text in Latin", Toast.LENGTH_LONG).show();


                } else {
                    mTvResult.setText("Initial text is: " + mEdtInput.getText().toString() +
                            "\n  Anagram is:  " + AnagramConverter.convertLineToAnagram(mEdtInput.getText().toString()));
                }
                mEdtInput.setText("");

            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(Constants.RESULT_TEXT_STATE, mTvResult.getText().toString());
    }
}
