package ir.khorrami.learningpackage.Navigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ir.khorrami.learningpackage.R;

public class ToFragment extends Fragment {


    public ToFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_to, container, false);
        System.out.println( "RREEZZ :" + ToFragmentArgs.fromBundle(getArguments()).getMyKey());
        return view;
    }
}