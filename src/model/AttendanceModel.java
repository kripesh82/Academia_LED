/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Date;
/**
 *
 * @author SMASHED TOMATOES
 */
public class AttendanceModel {
    private int atStudentId;
    private String atStudentName;
    private Date atDate;
    private String attendanceStatus;

    public int getAtStudentId() {
        return atStudentId;
    }

    public void setAtStudentId(int atStudentId) {
        this.atStudentId = atStudentId;
    }

    public String getAtStudentName() {
        return atStudentName;
    }

    public void setAtStudentName(String atStudentName) {
        this.atStudentName = atStudentName;
    }

    public Date getAtDate() {
        return atDate;
    }

    public void setAtDate(Date atDate) {
        this.atDate = atDate;
    }

    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }
}