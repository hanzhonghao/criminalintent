package com.exercise.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * 项目名称：AdvancedStudy
 * 类描述：
 * 创建人：小豪
 * 创建时间：2017/4/11 16:16
 * 修改人：小豪
 * 修改时间：2017/4/11 16:16
 * 修改备注：
 */

public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public Crime() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
