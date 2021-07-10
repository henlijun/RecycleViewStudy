package com.lj.diffmodule.ui;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lj.diffmodule.R;
import com.lj.diffmodule.adapter.StudentAdapter;
import com.lj.diffmodule.bean.Student;
import com.lj.diffmodule.util.RecycleDiffUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Student | StudentAdapter | RecycleDiffUtil
 */
public class RecycleDiffActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        initView();
    }

    private void initView() {
        RecyclerView recyclerView = findViewById(R.id.studentRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        StudentAdapter adapter = new StudentAdapter();
        adapter.data = getData();
        RecycleDiffUtil diffUtil = new RecycleDiffUtil(adapter.data);
        recyclerView.setAdapter(adapter);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            if(diffUtil.oldData == null){
                diffUtil.oldData = new ArrayList<>();
            }
            diffUtil.oldData.clear();
            diffUtil.oldData.addAll(diffUtil.newData);
            diffUtil.newData = getData();
            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffUtil);
            diffResult.dispatchUpdatesTo(adapter);
            adapter.data= diffUtil.newData;

        });
    }

    Random random = new Random();
    List<Student> students = new ArrayList<>();
    private List<Student> getData(){
        int a = random.nextInt(16);
        students.clear();
        while (a > 0){
            a--;
            students.add(new Student(String.valueOf(a), random.nextInt(),random.nextInt()));
        }
        return students;
    }
}