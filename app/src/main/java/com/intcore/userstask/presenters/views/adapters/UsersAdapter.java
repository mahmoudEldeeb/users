package com.intcore.userstask.presenters.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.intcore.userstask.R;
import com.intcore.userstask.databinding.ItemUserBinding;
import com.intcore.userstask.db.User;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {
    List<User> userList=new ArrayList<>() ;
    UserClickListener userClickListener;
    @Inject
    public UsersAdapter(){

    }
 public interface UserClickListener{
     void onClick(User user);
 }

    @Override
    public UsersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemUserBinding itemUserBinding;

            itemUserBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                    R.layout.item_user, parent, false);
         return new ViewHolder(itemUserBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     holder.itemUserBinding.setUser(userList.get(position));
    }

    

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void addUsers(List<User> users) {
        userList.clear();
        userList.addAll(users);
        notifyDataSetChanged();
    }
    public void setUserClickListener(UserClickListener userClickListener){
     this.userClickListener=userClickListener;
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ItemUserBinding itemUserBinding;
        public ViewHolder(ItemUserBinding userBinding) {
            super(userBinding.getRoot());
            this.itemUserBinding=userBinding;
            this.itemUserBinding.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View view)
        {
         userClickListener.onClick(userList.get(getAdapterPosition()));
        }
    }
}