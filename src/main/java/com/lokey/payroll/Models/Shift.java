package com.lokey.payroll.Models;

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


}
