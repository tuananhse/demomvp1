package com.tuananhse.fragment.fragment_movie.api;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.tuananhse.examplematerialretrofitmvp.R;


import java.util.ArrayList;

/**
 * Created by kyubj on 8/19/2016.
 */
public class FragmentAppointment extends Fragment {
    ArrayList<String> dsTime;
    ArrayAdapter<String>adapterTime;
    Spinner spTime,spSms;
    Switch switchbtn;
    public FragmentAppointment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
View v=inflater.inflate(R.layout.fragment_appointment_reminder,container,false);
        dsTime=new ArrayList<String>();
        switchbtn= (Switch) v.findViewById(R.id.switch1);
        appStyle(switchbtn.getTextOn(),switchbtn.getTextOff());
        switchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                togglestatehandler(view);
            }
        });
        // adapterTime=new ArrayAdapter<>();
        dsTime.add("Remid me before 20 minutes");
        dsTime.add("Remid me before 30 minutes");
        dsTime.add("Remid me before 40 minutes");
        dsTime.add("Remid me before 50 minutes");
        dsTime.add("Remid me before 60 minutes");
      //spTime=
        spTime= (Spinner) v.findViewById(R.id.spinmail1);
        spSms= (Spinner) v.findViewById(R.id.spinsms);
        adapterTime=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,dsTime);
        adapterTime.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTime.setAdapter(adapterTime);
        spSms.setAdapter(adapterTime);
        adapterTime.notifyDataSetChanged();
        spTime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(),"Bạn chon thoi gian"+dsTime.get(i),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spSms.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(),"Bạn chon thoi gian"+dsTime.get(i),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return v;
    }

    private void appStyle(CharSequence textOn, CharSequence textOff) {
        Spannable styleText = new SpannableString(textOn);
        StyleSpan style = new StyleSpan(Typeface.BOLD);
        styleText.setSpan(style, 0, textOn.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        styleText.setSpan(new ForegroundColorSpan(Color.GREEN), 0, textOn.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        switchbtn.setTextOn(styleText);

        styleText = new SpannableString(textOff);
        styleText.setSpan(style, 0, textOff.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        styleText.setSpan(new ForegroundColorSpan(Color.RED), 0, textOff.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        switchbtn.setTextOff(styleText);

    }

    public void togglestatehandler(View v)
    {
        Switch switchbtn= (Switch) v;
        boolean isChecked=switchbtn.isChecked();
        if(isChecked)
        {
            Toast.makeText(getActivity(),"Start",Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(getActivity(),"Stop",Toast.LENGTH_LONG).show();

        }
    }


}
