package com.lj.diffmodule.ui;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lj.diffmodule.R;
import com.lj.diffmodule.adapter.StudentAdapter;
import com.lj.diffmodule.adapter.StudentAsyncAdapter;
import com.lj.diffmodule.bean.Student;
import com.lj.diffmodule.util.RecycleDiffUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Student | StudentAsyncAdapter | AsyncListDiffer
 */
public class RecycleAsyncDiffActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        initView();
    }

    private void initView() {
        RecyclerView recyclerView = findViewById(R.id.studentRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        StudentAsyncAdapter adapter = new StudentAsyncAdapter();
        adapter.diffUtil.submitList(getData());
        recyclerView.setAdapter(adapter);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
           adapter.diffUtil.submitList(getData());
        });
    }

    Random random = new Random();
    private List<Student> getData(){
        int a = random.nextInt(16);
        List<Student> students = new ArrayList<>();
        students.clear();
        while (a > 0){
            a--;
            students.add(new Student(String.valueOf(a), random.nextInt(),random.nextInt()));
        }
        return students;
    }
}