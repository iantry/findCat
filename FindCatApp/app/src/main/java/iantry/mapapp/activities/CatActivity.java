package iantry.mapapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import iantry.mapapp.R;
import iantry.mapapp.factories.IntentFactory;

public class CatActivity extends AppCompatActivity {

    private ImageView mImageViewPhoto;
    private TextView mTextViewName;
    private TextView mTextViewRace;
    private TextView mTextViewDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);
        initVariable();

    }

    private void initVariable() {
        Intent intent = getIntent();
        mImageViewPhoto = (ImageView)findViewById(R.id.imageView);
        mImageViewPhoto.setImageResource(intent.getIntExtra(IntentFactory.IMAGE_RES, R.drawable.american_kerl_vas));

        mTextViewName = (TextView)findViewById(R.id.name);
        mTextViewName.setText(intent.getStringExtra(IntentFactory.NAME));

        mTextViewRace = (TextView)findViewById(R.id.race);
        mTextViewRace.setText(intent.getStringExtra(IntentFactory.RACE));

        mTextViewDesc = (TextView)findViewById(R.id.desc);
        mTextViewDesc.setText(intent.getStringExtra(IntentFactory.DESC));
    }

    public void onCallClick(View view) {
        IntentFactory.call(this);
    }
}
