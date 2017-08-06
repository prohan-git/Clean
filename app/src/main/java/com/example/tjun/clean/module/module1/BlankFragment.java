package com.example.tjun.clean.module.module1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.example.tjun.clean.R;
import com.example.tjun.clean.base.LazyFragment;
import com.example.tjun.clean.network.RetrofitHelper;
import com.example.tjun.clean.utils.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
/****
 * </pre>
 *  Project_Name:    NetWorkFrameSample
 *  Copyright:
 *  Version:         1.0.0.1
 *  Created:         Tijun on 2017/8/3 0003 12:18.
 *  E-mail:          prohankj@outlook.com
 *  Desc:
 * </pre>
 ****/

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class BlankFragment extends LazyFragment {

    @BindView(R.id.edit_search)
    EditText editSearch;
    @BindView(R.id.btn_search)
    Button btnSearch;
    @BindView(R.id.text_result)
    TextView textResult;

    public BlankFragment() {// Required empty public constructor
    }

    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void finishCreateView(Bundle state) {
        onCallBackActivitys("finishCreateView");
    }

    /**
     * interface must be implemented by activities
     *
     * @param str
     */
    public void onCallBackActivitys(String str) {
        if (mListener != null) {
            mListener.onFragmentInteraction(str);
        }
    }

    /**
     * 网络请求
     *
     * @param key
     */
    private void search(String key) {
        // .search1(new PostAction("Converse诞生于1908", "1", "comp"))
        //.search3(new PostRequestBody("Converse诞生于1908", "1", "comp").init())
        subscription = RetrofitHelper.getBaseApi()
                .search2(key, "1", "comp")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(zhuangbiImages -> textResult.setText("reault" + zhuangbiImages.toString())
                        , throwable -> ToastUtils.showShort("数据加载失败！！！"));
        // .subscribe(observer);
    }

    /**
     * 显示结果
     */
    @OnClick(R.id.btn_search)
    public void onViewClicked() {
        search(editSearch.getText().toString());
    }
}
