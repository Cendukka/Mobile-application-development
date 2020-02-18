package com.example.samuli_lehtonen_comp304_sec003_lab02_ex2b;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BottomFragment extends Fragment {
    TextView lifecycleTextViewMain;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom, container, false);
        lifecycleTextViewMain = (TextView)view.findViewById(R.id.lifecycleFuncMain);
        return view;
    }
    public void showLifeCycleEvent(String event){
        lifecycleTextViewMain.append(event);
    }
}