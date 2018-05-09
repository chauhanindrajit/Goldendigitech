package dotcom.com.sam.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dotcom.com.sam.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProdiuctDetailsFragment extends Fragment {


    public ProdiuctDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_prodiuct_details, container, false);
    }

}
