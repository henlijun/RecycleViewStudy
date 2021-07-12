package com.lj.diffmodule.ui;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lj.diffmodule.R;
import com.lj.diffmodule.adapter.StudentAsyncListAdapter;
import com.lj.diffmodule.adapter.StudentDiffItemCallBack;
import com.lj.diffmodule.bean.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Student | StudentAdapter | StudentAsyncListAdapter (ListAdapter)
 */
public class RecycleDiffListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        initView();
    }

    private void initView() {
        RecyclerView recyclerView = findViewById(R.id.studentRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        StudentAsyncListAdapter adapter = new StudentAsyncListAdapter(new StudentDiffItemCallBack());
        recyclerView.setAdapter(adapter);
        adapter.submitList(getData());

        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            adapter.submitList(getData());
        });
    }

    Random random = new Random();
    private List<Student> getData(){
        List<Student> students = new ArrayList<>();
        int a = random.nextInt(100);
        students.clear();
        while (a > 0){
            a--;
            students.add(new Student(String.valueOf(a), random.nextInt(),random.nextInt()));
        }
        return students;
    }
}