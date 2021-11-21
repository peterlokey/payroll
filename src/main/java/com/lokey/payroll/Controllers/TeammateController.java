package com.lokey.payroll.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeammateController {
    @RequestMapping(value = "newTeammate")
    public String index() {
        return "newTeammate";
    }
}
