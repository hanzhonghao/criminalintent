package com.exercise.chapter5;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class CheatingActivity extends AppCompatActivity {
    private static final String EXTRA_ANSWER_IS_TRUE = "com.exercise.chapter5.answer is true";
    private static final String EXTRA_ANSWER_SHOW = "com.exercise.chapter5.answer_shown";
    private TextView mAnswerTextView;
    private Button mShowAnswer;

    public static Intent newIntent(Context packageContext, boolean answerIsTrue) {
        Intent intent = new Intent(packageContext, CheatingActivity.class);
        intent.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return intent;
    }

    private boolean mAnswerIsTrue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheating);


        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mAnswerTextView = (TextView) findViewById(R.id.answer_text_view);

        mShowAnswer = (Button) findViewById(R.id.show_answer_button);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswerIsTrue) {
                    mAnswerTextView.setText(R.string.true_button);
                } else {
                    mAnswerTextView.setText(R.string.false_button);
                }
                setAnswerShownResult(true);

                //加了这个判断版本号的语句后，下面代码只有在API21级或者更高版本的设备上才能运行
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                int cx = mShowAnswer.getWidth()/2;
                int cy = mShowAnswer.getHeight()/2;
                float radius = mShowAnswer.getWidth();
                Animator anim = ViewAnimationUtils.createCircularReveal(mShowAnswer, cx, cy, radius, 0);
                anim.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        mShowAnswer.setVisibility(View.INVISIBLE);
                    }
                });
                anim.start();
                }else{
                    mShowAnswer.setVisibility(View.INVISIBLE);
                }
            }
        });


        TextView apishown = (TextView) findViewById(R.id.api);
        int version = Integer.valueOf(Build.VERSION.SDK);
        apishown.setText("API LEVEL "+ version);
    }

    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_ANSWER_SHOW,isAnswerShown);
        setResult(RESULT_OK,intent);
    }

    public static boolean wasAnswerShown(Intent result){
        return result.getBooleanExtra(EXTRA_ANSWER_SHOW,false);
    }
}
