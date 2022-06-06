package com.lj.module_basequick.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lj.module_basequick.cymchad.L_BaseViewHolder;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: RecycleApplication
 * @Package: com.lj.module_basequick.adapter
 * @ClassName: L_BaseQuickAdapter
 * @Description: java类作用描述
 * @Author: 李军
 * @CreateDate: 2022/6/6 17:08
 * @UpdateUser: 更新者
 * @UpdateDate: 2022/6/6 17:08
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public abstract class L_BaseQuickAdapter<T, K extends L_BaseViewHolder> extends RecyclerView.Adapter<K> {

    private boolean mNextLoadEnable = false;
    private boolean mLoadMoreEnable = false;
    private boolean mLoading = false;
    private boolean mEnableLoadMoreEndClick = false;

    public static final int ALPHAIN = 0x00000001;
    public static final int SCALEIN = 0x00000002;
    public static final int SLIDEIN_BOTTOM = 0x00000003;
    public static final int SLIDIN_LEFT = 0x00000004;
    public static final int SLIDIN_RIGHT = 0x00000005;

    private OnItemClickListener mOnItemClickListener;


    @IntDef({ALPHAIN, SCALEIN, SLIDEIN_BOTTOM, SLIDIN_LEFT, SLIDIN_RIGHT})
    @Retention(RetentionPolicy.SOURCE)
    public @interface  AnimationType  {}

    private boolean mFirstOnlyEnable = true;

    private LinearLayout mHeaderLayout;
    private LinearLayout mFooterLayout;

    private FrameLayout mEmptyLayout;
    private boolean mIsUseEmpty  true;
    private boolean mHeadAndEmptyEnable = true;
    private boolean mFootAndEmptyEnable;

    protected Context mContext;
    protected int mLayoutResId;
    protected LayoutInflater mLayoutInFlater;
    protected List<T> mData;

    public static final int HEADER_VIEW = 0x00000111;
    public static final int LOADING_VIEW = 0x00000222;
    public static final int FOOTER_VIEW = 0x00000333;
    public static final int EMPTY_VIEW = 0x00000555;

    private RecyclerView mRecycleView;


    public L_BaseQuickAdapter(int rid, List<T> data){
        this.mLayoutResId = rid;
        mData = data == null? new ArrayList<>():data;
    }

    @NonNull
    @Override
    public K onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        a
    }

    public void setNewData(List<T> data){
        mData = data == null? new ArrayList<>():data;
        notifyDataSetChanged();
    }


    public void setRecycleView(RecyclerView mRecycleView) {
        this.mRecycleView = mRecycleView;
    }

    public interface OnItemClickListener{
        void onItemClick(L_BaseQuickAdapter adapter, View view, int position);
    }

}
