package com.myworkspace.java.collections.thread;

import java.util.LinkedList;

class Student implements Runnable {
    private String studentName;
    private Integer studentId;
    private LinkedList<Student> studentList;

    public Student(Integer studentId, String name) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    @Override
    public void run() {
        System.out.println("Invoked student::" + this);
        studentList.add(this);
    }
}


public class ThreadMain {
    public static void main(String[] args) {
        Thread studentThread1 = new Thread(new Student(100, "Kranthi"));
        Thread studentThread2 = new Thread(new Student(101, "Shyam"));
        studentThread1.start();
        studentThread2.start();
    }


}
