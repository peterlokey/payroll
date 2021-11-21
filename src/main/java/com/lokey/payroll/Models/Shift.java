package com.lokey.payroll.Models;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class Shift {

    @NotNull
    private LocalDate shiftDate;

    @NotNull
    private float totalHoursWorked;

   @NotNull
    private float totalTips;

}
