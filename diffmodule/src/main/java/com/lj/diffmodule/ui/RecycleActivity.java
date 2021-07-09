package com.lj.diffmodule.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.lj.diffmodule.R;
import com.lj.diffmodule.adapter.StudentAdapter;
import com.lj.diffmodule.bean.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecycleActivity extends AppCompatActivity {

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
        recyclerView.setAdapter(adapter);


        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            adapter.data = getData();
            //不重新绘制仅更新数据源时-报错
            adapter.notifyDataSetChanged();
        });
    }

    Random random = new Random();
    List<Student> students = new ArrayList<>();
    private List<Student> getData(){
        int a = random.nextInt(100);
        students.clear();
        while (a > 0){
            a--;
            students.add(new Student(String.valueOf(a), random.nextInt(),random.nextInt()));
        }

        return students;
    }
}