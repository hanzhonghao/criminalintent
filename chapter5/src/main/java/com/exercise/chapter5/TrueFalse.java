package com.exercise.chapter5;

/**
 * 项目名称：AdvancedStudy
 * 类描述：
 * 创建人：小豪
 * 创建时间：2017/4/10 14:43
 * 修改人：小豪
 * 修改时间：2017/4/10 14:43
 * 修改备注：
 */

public class TrueFalse {
    private int mQuestion;
    private boolean mTrueQuestion;

    public TrueFalse(int question, boolean trueQuestion) {
        mQuestion = question;
        mTrueQuestion = trueQuestion;
    }

    public int getQuestion() {
        return mQuestion;
    }

    public void setQuestion(int question) {
        mQuestion = question;
    }

    public boolean isTrueQuestion() {
        return mTrueQuestion;
    }

    public void setTrueQuestion(boolean trueQuestion) {
        mTrueQuestion = trueQuestion;
    }
}
