package com.lj.diffmodule.bean;

import java.util.Objects;

/**
 * @ProjectName: RecycleApplication
 * @Package: com.lj.diffmodule.bean
 * @ClassName: Student
 * @Description: java类作用描述
 * @Author: 李军
 * @CreateDate: 2021/7/9 17:10
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/7/9 17:10
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Student {

    public String name;
    public int age;
    public int workTime;
    public String company;

    public Student(){}

    public Student(String name, int age, int workTime){
        this.name = name;
        this.age = age;
        this.workTime = workTime;
        this.company = "company";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                workTime == student.workTime &&
                Objects.equals(name, student.name) &&
                Objects.equals(company, student.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, workTime, company);
    }
}
