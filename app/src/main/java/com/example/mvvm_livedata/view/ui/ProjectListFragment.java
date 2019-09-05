package com.example.mvvm_livedata.view.ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mvvm_livedata.R;
import com.example.mvvm_livedata.databinding.FragmentItemListBinding;
import com.example.mvvm_livedata.view.adapter.ProjectAdapter;
import com.example.mvvm_livedata.viewmodel.ProjectListViewModel;

public class ProjectListFragment extends Fragment {
    private FragmentItemListBinding binding;
    private ProjectAdapter projectAdapter;

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

        ProjectListViewModel projectListViewModel = ViewModelProviders
                .of(this)
                .get(ProjectListViewModel.class);

        projectListViewModel.setProject();
        projectListViewModel.getProjectListObservable().observe(this,project ->
                binding.recycleView.setAdapter(new ProjectAdapter(project,projectListViewModel)));

    }


}
