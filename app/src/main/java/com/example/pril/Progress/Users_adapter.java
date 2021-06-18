package com.example.pril.Progress;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pril.R;

import java.util.ArrayList;

public class Users_adapter extends RecyclerView.Adapter<Users_adapter.UsersViewHolder> {
    //количество элементов в списке
    private int count_users;
    private static int viewHolderCount;
    ArrayList<ArrayList<Object>> mass;
    public  Users_adapter(int count_users, ArrayList<ArrayList<Object>> mass){
        this.count_users = count_users;
        this.mass = mass;
        viewHolderCount = 0;
    }
    @NonNull
    @Override
    //создаем холдеры
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //получаем контекст recyclerview
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.users_list_item;
        //создаем новое представление
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForListItem, parent, false);
        UsersViewHolder viewHolder = new UsersViewHolder(view);
        viewHolderCount+=1;
        return  viewHolder;
    }

    @Override
    //меняем значения холдеров
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        holder.listItemUserView.setText(mass.get(position).get(0).toString());
        holder.number.setText(String.valueOf(position+1));
        holder.viewHolderIndex.setText(mass.get(position).get(1).toString());

    }

    @Override
    public int getItemCount() {
        return count_users;
    }

    class  UsersViewHolder extends RecyclerView.ViewHolder {
        //соответствуют двум созданным textview;
        //имя
        TextView listItemUserView;
        //очки
        TextView viewHolderIndex;
        //номер
        TextView number;
        public UsersViewHolder(@NonNull View itemView) {
            super(itemView);
            listItemUserView = itemView.findViewById(R.id.rv_users_item);
            viewHolderIndex = itemView.findViewById(R.id.tv_holder_users);
            number = itemView.findViewById(R.id.tv_number);
        }
        //меняем число для отображения
        void bind(int listIndex){
            listItemUserView.setText(String.valueOf(listIndex));
        }
    }
}
