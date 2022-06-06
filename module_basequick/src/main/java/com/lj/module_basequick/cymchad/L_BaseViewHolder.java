package com.lj.module_basequick.cymchad;

import android.util.SparseArray;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @ProjectName: RecycleApplication
 * @Package: com.lj.module_basequick.cymchad
 * @ClassName: L_BaseViewHolder
 * @Description: java类作用描述
 * @Author: 李军
 * @CreateDate: 2022/6/6 16:25
 * @UpdateUser: 更新者
 * @UpdateDate: 2022/6/6 16:25
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class L_BaseViewHolder extends RecyclerView.ViewHolder {

    private final SparseArray<View> views;
    public final HashSet<Integer> nestViews;
    private final LinkedHashSet<Integer> childClickViewIds;
    private final LinkedHashSet<Integer> itemChildLongClickViewIds;
    private BaseQuickAdapter adapter;

    public View itemView;
    Object associatedObject;

    public L_BaseViewHolder(@NonNull final View itemView) {
        super(itemView);
        this.views = new SparseArray<>();
        this.nestViews = new HashSet<>();
        this.childClickViewIds = new LinkedHashSet<>();
        this.itemChildLongClickViewIds = new LinkedHashSet<>();
    }

    public L_BaseViewHolder setText(@IdRes int rid, CharSequence value){
        TextView view = getView(rid);
        view.setText(value);
        return this;
    }

    public L_BaseViewHolder addOnClickListener(@IdRes int rid){
        childClickViewIds.add(rid);
        final View view = getView(rid);
        if(null != view){
            view.setOnClickListener(v->{
                if(adapter.getOnItemChildClickListener() != null){
                    adapter.getOnItemChildClickListener().onItemChildClick(adapter,v,getClickPosition());
                }
            });
        }

        return this;
    }

    private int getClickPosition(){
        if(getLayoutPosition() >= adapter.getHeaderLayoutCount()){
            return getLayoutPosition() - adapter.getHeaderLayoutCount();
        }

        return 0;
    }

    public <T extends View> T getView(@IdRes int rid){
        View view = views.get(rid);
        if(view == null){
            view = itemView.findViewById(rid);
            views.put(rid, view);
        }
        return (T) view;
    }


    public void setAdapter(BaseQuickAdapter adapter) {
        this.adapter = adapter;
    }
}
