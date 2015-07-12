package org.emilk.tabs.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.emilk.tabs.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentContacts extends android.support.v4.app.Fragment {


    public FragmentContacts() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_contacts, container, false);
    }


}
