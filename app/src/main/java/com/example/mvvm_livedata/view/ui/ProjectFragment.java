package com.example.mvvm_livedata.view.ui;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvvm_livedata.R;
import com.example.mvvm_livedata.databinding.ProjectFragmentBinding;
import com.example.mvvm_livedata.model.Project;
import com.example.mvvm_livedata.viewmodel.ProjectViewModel;

public class ProjectFragment extends Fragment {

    private static final String KEY_PROJECT_ID = "project_id";
    private ProjectFragmentBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.project_fragment, container, false);

        return  binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ProjectViewModel.Factory factory = new ProjectViewModel.Factory(getActivity().getApplication(), getArguments().getString(KEY_PROJECT_ID));

        final ProjectViewModel viewModel = new ViewModelProvider(this, factory).get(ProjectViewModel.class);

        binding.setProjectViewModel(viewModel);
        observeModel(viewModel);

    }

    private void observeModel(final ProjectViewModel viewModel) {
        viewModel.getProjectLiveData().observe(this, new Observer<Project>() {
            @Override
            public void onChanged(@Nullable Project project) {
                viewModel.setProjectObservableField(project);
            }
        });
    }

    public static ProjectFragment forProject(String projectID) {

        ProjectFragment fragment = new ProjectFragment();
        Bundle args = new Bundle();
        args.putString(KEY_PROJECT_ID,projectID);
        fragment.setArguments(args);
        return fragment;
    }

}
