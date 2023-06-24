/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.*;
/**
 *
 * @author SMASHED TOMATOES
 */
public class ResultModel {
    private int student_id;
    private String first_name;
    private String last_name;
    private float course1;
    private float course2;
    private float course3;
    private float course4;
    private float course5;
    private double percentage;
    private int ranks;

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public float getCourse1() {
        return course1;
    }

    public void setCourse1(float course1) {
        this.course1 = course1;
    }

    public float getCourse2() {
        return course2;
    }


    public void setCourse2(float course2) {
        this.course2 = course2;
    }

    public float getCourse3() {
        return course3;
    }


    public void setCourse3(float course3) {
        this.course3 = course3;
    }

    public float getCourse4() {
        return course4;
    }


    public void setCourse4(float course4) {
        this.course4 = course4;
    }
    
    public float getCourse5() {
        return course5;
    }

    public void setCourse5(float course5) {
        this.course5 = course5;
    }
    
    public double getPercent(){
        return percentage;
    }
    
   
    public void setPercent(double percentage) {
        this.percentage = percentage;
    }
    
    
    public int getRank() {
        return ranks;
    }

    public void setRank(int ranks) {
        this.ranks = ranks;
    }
}
