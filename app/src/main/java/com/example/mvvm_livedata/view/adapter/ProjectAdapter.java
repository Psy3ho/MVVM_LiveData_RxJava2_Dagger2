package com.example.mvvm_livedata.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvm_livedata.R;
import com.example.mvvm_livedata.databinding.FragmentItemListBinding;
import com.example.mvvm_livedata.databinding.ProjectItemBinding;
import com.example.mvvm_livedata.model.Project;
import com.example.mvvm_livedata.viewmodel.ProjectListViewModel;

import java.util.List;


public class ProjectAdapter extends
        RecyclerView.Adapter<ProjectAdapter.ViewHolder> {
    private List<Project> projects;
    private ProjectListViewModel projectListViewModel;

    public ProjectAdapter(List<Project> projects, ProjectListViewModel projectListViewModel) {
        this.projects = projects;
        this.projectListViewModel = projectListViewModel;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ProjectItemBinding binding = DataBindingUtil.inflate(layoutInflater,
                R.layout.project_item,parent, false);
        return  new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Project project = projects.get(position);
        holder.setBinding(project, projectListViewModel);

    }

    @Override
    public int getItemCount() {
        return  projects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ProjectItemBinding binding;

        public ViewHolder(@NonNull ProjectItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void setBinding(Project project, ProjectListViewModel viewModel) {
            binding.setProject(project);
            binding.setViewModel(viewModel);
            binding.executePendingBindings();

        }
    }
}
