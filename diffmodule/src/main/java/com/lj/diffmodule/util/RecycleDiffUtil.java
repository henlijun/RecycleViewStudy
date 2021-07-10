package com.lj.diffmodule.util;

import androidx.recyclerview.widget.DiffUtil;

import com.lj.diffmodule.bean.Student;

import java.util.List;

/**
 * @ProjectName: RecycleApplication
 * @Package: com.lj.diffmodule.util
 * @ClassName: RecycleDiffUtil
 * @Description: java类作用描述
 * @Author: 李军
 * @CreateDate: 2021/7/9 17:10
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/7/9 17:10
 * @UpdateRemark: DiffUtil 简单使用
 * Student | StudentAdapter |
 *
 * @Version: 1.0
 */
public class RecycleDiffUtil extends DiffUtil.Callback {

    public List<Student> oldData;
    public List<Student> newData;

    public RecycleDiffUtil(List<Student> newData) {
        this.newData = newData;
    }

    @Override
    public int getOldListSize() {
        return oldData == null?0:oldData.size();
    }

    @Override
    public int getNewListSize() {
        return newData == null?0:newData.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        if(oldData == null || newData == null)
            return false;
       /* if(oldItemPosition < oldData.size() && newItemPosition < newData.size() ){
            return oldData.get(oldItemPosition).name.equals(newData.get(newItemPosition).name);
        }
        return false;*/
        return oldData.get(oldItemPosition).name.equals(newData.get(newItemPosition).name);
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldData.get(oldItemPosition).equals(newData.get(newItemPosition));
    }
}
