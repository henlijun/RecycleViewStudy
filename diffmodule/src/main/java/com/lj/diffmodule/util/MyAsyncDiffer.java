package com.lj.diffmodule.util;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;

import com.lj.diffmodule.bean.Student;

/**
 * @ProjectName: RecycleApplication
 * @Package: com.lj.diffmodule.util
 * @ClassName: MyAsyncDiffer
 * @Description: java类作用描述
 * @Author: 李军
 * @CreateDate: 2021/7/10 8:36
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/7/10 8:36
 * @UpdateRemark: DiffUtil 子线程使用
 * @Version: 1.0
 */
public class MyAsyncDiffer extends DiffUtil.ItemCallback<Student> {

    @Override
    public boolean areItemsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {

        return false;
    }

    @Override
    public boolean areContentsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {
        return false;
    }
}
