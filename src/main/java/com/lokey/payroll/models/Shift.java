package com.lokey.payroll.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Shift {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private LocalDate shiftDate;

    @NotNull
    private float totalHoursWorked;

   @NotNull
    private float totalTips;


   //getters and setters
    public int getId() {
        return id;
    }

    public LocalDate getShiftDate() {
        return shiftDate;
    }

    public void setShiftDate(LocalDate shiftDate) {
        this.shiftDate = shiftDate;
    }

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked;
    }

    public float getTotalTips() {
        return totalTips;
    }

    public void setTotalTips(float totalTips) {
        this.totalTips = totalTips;
    }

    public Shift(int id, LocalDate shiftDate, float totalHoursWorked, float totalTips) {
        this.id = id;
        this.shiftDate = shiftDate;
        this.totalHoursWorked = totalHoursWorked;
        this.totalTips = totalTips;
    }
}
