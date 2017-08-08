package com.example.tjun.clean.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;


import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Subscription;

/****
 * </pre> 
 *  Project_Name:    NetWorkFrameSample
 *  Copyright: 
 *  Version:         1.0.0.1
 *  Created:         Tijun on 2017/8/3 0003 16:18.
 *  E-mail:          prohankj@outlook.com
 *  Desc:            完成bindView，懒加载，回掉接口
 *
 * //     public static BlankFragment newInstance(String param1, String param2) {
 * //         BlankFragment fragment = new BlankFragment();
 * //         //安全传递参数的方式
 * //         Bundle args = new Bundle();
 * //         args.putString(ARG_PARAM1, param1);
 * //         args.putString(ARG_PARAM2, param2);
 * //         fragment.setArguments(args);
 * //         return fragment;
 * //     }
 * //          @Override
 * //          public void onCreate(Bundle savedInstanceState) {
 * //              super.onCreate(savedInstanceState);
 * //              if (getArguments() != null) {
 * //              mParam1 = getArguments().getString(ARG_PARAM1);
 * //              mParam2 = getArguments().getString(ARG_PARAM2);
 * //              }
 * //          }
 * </pre>
 ****/
public abstract class LazyFragment extends Fragment {
    //标志位 fragment是否可见
    protected boolean isVisible;

    public OnFragmentInteractionListener mListener;

    protected Unbinder unbind;
    protected Subscription subscription;


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbind = ButterKnife.bind(this, view);
        finishCreateView(savedInstanceState);
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
        unSubscribe();
        unbind.unbind();

    }

    protected void unSubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    /**
     * 初始化views完成
     *
     * @param state
     */
    public abstract void finishCreateView(Bundle state);

    /**
     * Fragment数据的懒加载
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    /**
     * fragment显示时才加载数据
     */
    protected void onVisible() {
        lazyLoad();
    }

    /**
     * fragment懒加载方法
     */
    protected void lazyLoad() {
    }

    /**
     * fragment隐藏
     */
    protected void onInvisible() {
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String str);
    }
}
