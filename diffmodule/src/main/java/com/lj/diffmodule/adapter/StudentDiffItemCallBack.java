package com.lj.diffmodule.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.lj.diffmodule.bean.Student;

/**
 * @ProjectName: RecycleApplication
 * @Package: com.lj.diffmodule.adapter
 * @ClassName: StudentDiffItemCallBack
 * @Description: java类作用描述
 * @Author: 李军
 * @CreateDate: 2021/7/12 9:13
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/7/12 9:13
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class StudentDiffItemCallBack extends DiffUtil.ItemCallback<Student> {

    @Override
    public boolean areItemsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {
        return oldItem.hashCode() == newItem.hashCode();
    }

    @Override
    public boolean areContentsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {
        return oldItem.equals(newItem);
    }
}
