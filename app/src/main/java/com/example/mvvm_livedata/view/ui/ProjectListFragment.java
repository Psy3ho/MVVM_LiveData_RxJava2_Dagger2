package com.example.mvvm_livedata.view.ui;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProviders;

import com.example.mvvm_livedata.R;
import com.example.mvvm_livedata.UpdateBroadcastReceiver;
import com.example.mvvm_livedata.databinding.FragmentItemListBinding;
import com.example.mvvm_livedata.model.Project;
import com.example.mvvm_livedata.view.adapter.ProjectAdapter;
import com.example.mvvm_livedata.view.callback.ObserveCallback;
import com.example.mvvm_livedata.view.callback.ProjectClickCallback;
import com.example.mvvm_livedata.viewmodel.ProjectListViewModel;

/**
 * fragment for loading layout resources
 *
 * This activity is used to display layout resources.
 * Mainly to display users project list in adapter
 *
 * @author Eugen Benčat
 * @version 1.0
 * @date 2019-2020
 */
public class ProjectListFragment extends Fragment implements ObserveCallback {
    private FragmentItemListBinding binding;
    private ProjectAdapter projectAdapter;
    private ProjectListViewModel projectListViewModel;
    private PendingIntent pendingIntent;
    private AlarmManager alarmManager;
    /**
     * public static final value
     * value for new Broadcast with intent
     */
    public static final String mMyBroadcastReceiver = "com.example.broadcast.MY_BROADCAST";
    private IntentFilter intentFilter;
    IntentFilter intentFilter1;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil
                .inflate(inflater,R.layout.fragment_item_list,container,false);
        binding.recycleView.setAdapter(projectAdapter);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addCategory(Intent.CATEGORY_DEFAULT);


        projectListViewModel = ViewModelProviders
                .of(this)
                .get(ProjectListViewModel.class);
        observeData();
        intentFilter1 = new IntentFilter(mMyBroadcastReceiver);
        intentFilter.addCategory(Intent.CATEGORY_DEFAULT);


    }



    @Override
    public void onPause() {
        super.onPause();
        getContext().unregisterReceiver(mReceiver);

    }

    @Override
    public void onResume() {
        super.onResume();
        setAlarmManager(10000);
        getActivity().registerReceiver(mReceiver, intentFilter1);


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        alarmManager.cancel(pendingIntent);
    }


    /**
     * Method that set AlarmManager to observe changes in project details in intervals
     *
     * @param time specified interval
     */
    private void setAlarmManager(long time) {
        alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);

        Intent i = new Intent(getActivity(), UpdateBroadcastReceiver.class);


        pendingIntent = PendingIntent.getBroadcast(getActivity().getBaseContext(), 0,i,0);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, 0,time,pendingIntent);

        Toast.makeText(getContext(), "Alarm is set", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void observeData() {
        projectListViewModel.setProject();
        projectListViewModel.getProjectListObservable().observe(this,project ->
                binding.recycleView.setAdapter(new ProjectAdapter(project,projectListViewModel, projectClickCallback)));
        Toast.makeText(getContext(), "Reloading data", Toast.LENGTH_SHORT).show();
    }

    /**
     * private class
     * BrodcastReceiver class with constructor
     * contain override method onReceive for observe data in projects
     */
    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            observeData();
        }
    };

    /**
     * private final interface
     * contain override method onClick
     */
    private final ProjectClickCallback projectClickCallback = new ProjectClickCallback() {
        @Override
        public void onClick(Project project) {
            if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                ((MainActivity) getActivity()).showProjectDetails(project);
            }

        }
    };


}
