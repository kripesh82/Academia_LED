/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.util.List;

/**
 *
 * @author User
 */
public class FeeModel {
    private int student_id;
    private String first_name;
    private String last_name;
    private float tution;
    private float eca;
    private float mic;
    private float other;
    private float due;

    private String selectedComboBoxOption;
    

    public FeeModel() {
        selectedComboBoxOption = null;
    }

    public String getSelectedComboBoxOption() {
        return selectedComboBoxOption;
    }

    public void setSelectedComboBoxOption(String selectedComboBoxOption) {
        this.selectedComboBoxOption = selectedComboBoxOption;
    }

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

    public float getTution() {
        return tution;
    }

    public void setTution(float tution) {
        this.tution = tution;
    }

    public float getEca() {
        return eca;
    }

    public void setEca(float eca) {
        this.eca = eca;
    }

    public float getMic() {
        return mic;
    }

    public void setMic(float mic) {
        this.mic = mic;
    }

    public float getOther() {
        return other;
    }

    public void setOther(float other) {
        this.other = other;
    }

    public float getDue() {
        return due;
    }

    public void setDue(float due) {
        this.due = due;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    private float total;
    
}
