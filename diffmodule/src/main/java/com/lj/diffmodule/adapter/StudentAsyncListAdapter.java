package com.lj.diffmodule.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.lj.diffmodule.R;
import com.lj.diffmodule.bean.Student;

/**
 * @ProjectName: RecycleApplication
 * @Package: com.lj.diffmodule.adapter
 * @ClassName: StudentAdapter
 * @Description: java类作用描述
 * @Author: 李军
 * @CreateDate: 2021/7/9 17:11
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/7/9 17:11
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class StudentAsyncListAdapter extends ListAdapter<Student, StudentAsyncListAdapter.ReViewHolder> {

    protected StudentAsyncListAdapter(@NonNull DiffUtil.ItemCallback<Student> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ReViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ReViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_student,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ReViewHolder holder, int position) {
        Student student = getItem(position);
        holder.textViews[0].setText(student.name);
        holder.textViews[1].setText(String.valueOf(student.age));
        holder.textViews[2].setText(String.valueOf(student.workTime));
        holder.textViews[3].setText(student.company);
    }

    class ReViewHolder extends RecyclerView.ViewHolder{
        TextView[] textViews = new TextView[4];
        public ReViewHolder(@NonNull View itemView) {
            super(itemView);
            textViews[0] = itemView.findViewById(R.id.textView);
            textViews[1] = itemView.findViewById(R.id.textView2);
            textViews[2] = itemView.findViewById(R.id.textView3);
            textViews[3] = itemView.findViewById(R.id.textView4);
        }
    }

    private class StudentDiffItemCallBack extends DiffUtil.ItemCallback<Student>{

        @Override
        public boolean areItemsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {
            return oldItem.hashCode() == newItem.hashCode();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {
            return oldItem.equals(newItem);
        }
    }


}
