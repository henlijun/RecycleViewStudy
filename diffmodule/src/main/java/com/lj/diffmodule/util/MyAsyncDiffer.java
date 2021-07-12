package com.lj.diffmodule.util;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

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
 * @UpdateRemark:  自继承实现 AsyncListDiffer
 * @Version: 1.0
 */
public class MyAsyncDiffer extends AsyncListDiffer<Student>{

    //todo 源码复写
    public MyAsyncDiffer(@NonNull RecyclerView.Adapter adapter, @NonNull DiffUtil.ItemCallback<Student> diffCallback) {
        super(adapter, diffCallback);
    }


}
