package com.example.kjpro.networkframesample.module.module1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kjpro.networkframesample.R;

import com.example.kjpro.networkframesample.model.ZhuangbiImage;
import com.example.kjpro.networkframesample.network.RetrofitHelper;
import com.example.kjpro.networkframesample.network.api.ZhuangbiApi;
import com.example.kjpro.networkframesample.network.requestBody.PostRequestBody;
import com.example.kjpro.networkframesample.utils.ToastUtils;
import com.orhanobut.logger.Logger;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
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

public class BlankFragment extends Fragment {
    protected Subscription subscription;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Unbinder unbinder;
    @BindView(R.id.edit_search)
    EditText editSearch;
    @BindView(R.id.btn_search)
    Button btnSearch;
    @BindView(R.id.text_result)
    TextView textResult;

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    Observer<ZhuangbiImage> observer = new Observer<ZhuangbiImage>() {

        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(ZhuangbiImage zhuangbiImage) {

        }
    };

    public BlankFragment() {// Required empty public constructor
    }

    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    /**
     * interface must be implemented by activities
     *
     * @param uri
     */
    public void onCallBackActivitys(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
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


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

}
