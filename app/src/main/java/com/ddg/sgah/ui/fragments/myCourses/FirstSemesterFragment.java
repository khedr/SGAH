package com.ddg.sgah.ui.fragments.myCourses;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ddg.sgah.R;
import com.ddg.sgah.adapter.CoursesAdapter;
import com.ddg.sgah.adapter.StudyPlanAdapter;
import com.ddg.sgah.data.db.CoursesDb;
import com.ddg.sgah.data.db.HomeListsData;
import com.ddg.sgah.data.db.UsersDb;
import com.ddg.sgah.data.model.HomeListModel;
import com.ddg.sgah.helper.SharedPreferenceManager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstSemesterFragment extends Fragment {

    @BindView(R.id.rc_courses)
    RecyclerView rcCourses;


    public FirstSemesterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View inflate = inflater.inflate(R.layout.fragment_first_semester, container, false);
        ButterKnife.bind(this, inflate);


        rcCourses.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayout.VERTICAL, false));

        inflateCourses();
        return inflate;
    }
    private void inflateCourses() {

        SharedPreferenceManager sharedPreferenceManager = new SharedPreferenceManager(getActivity());
        String userName1 = sharedPreferenceManager.loadUserName();
        if (userName1 != null) {
            if (userName1.equals("maryam")) {

            List<HomeListModel>   getsem1CommunicationStudyPlan= CoursesDb.getsem1CommunicationStudyPlan();
            rcCourses.setAdapter(new StudyPlanAdapter(getsem1CommunicationStudyPlan,getActivity()));


        } else {
            List<HomeListModel> getsem1ComputerStudyPlan = CoursesDb.getsem1ComputersStudyPlan();
            rcCourses.setAdapter(new StudyPlanAdapter(getsem1ComputerStudyPlan,getActivity()));


        }


    }}

}
