package com.example.samuli_lehtonen_comp304_sec003_lab02_ex2b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/*import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;*/


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.Fragment;
import android.widget.Toast;


public class TopFragment extends Fragment{

    String[] activities = { "AIActivity","VRActivity" };
    ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_top, container, false);
        listView = (ListView)view.findViewById(R.id.list);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, activities);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {
                String clickedDetail = (String)arg0.getItemAtPosition(position);
                Toast.makeText(getActivity(),clickedDetail,Toast.LENGTH_SHORT).show();


                switch (clickedDetail) {
                    case "AIActivity":

                        Intent intent = new Intent(getActivity(), AIActivity.class);
                        startActivity(intent);
                        break;
                    case "VRActivity":
                        Intent intent1 = new Intent(getActivity(), VRActivity.class);
                        startActivity(intent1);
                        break;
                    default:
                        break;
                }
            }
            });
        return view;
    }

    /*public void onListItemClick(ListView l, View v, int position, long id) {

        String clickedDetail = (String)l.getItemAtPosition(position);
        Toast.makeText(getActivity(),clickedDetail,Toast.LENGTH_SHORT).show();



    }*/
}
