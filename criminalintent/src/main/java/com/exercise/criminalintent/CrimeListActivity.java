package com.exercise.criminalintent;

import android.support.v4.app.Fragment;

/**
 * 项目名称：AdvancedStudy
 * 类描述：
 * 创建人：小豪
 * 创建时间：2017/4/13 15:14
 * 修改人：小豪
 * 修改时间：2017/4/13 15:14
 * 修改备注：
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
