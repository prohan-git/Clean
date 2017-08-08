package com.example.tjun.clean.module.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tjun.clean.R;
import com.example.tjun.clean.base.LazyFragment;

public class UserFragment extends LazyFragment {

    public UserFragment() {
        // Required empty public constructor
    }

    public static UserFragment newInstance(String param1, String param2) {
        UserFragment fragment = new UserFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    @Override
    public void finishCreateView(Bundle state) {
        onCallBackActivitys("UserFragment");
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
}
