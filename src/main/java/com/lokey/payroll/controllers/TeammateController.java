package com.lokey.payroll.controllers;

import com.lokey.payroll.models.Data.ShiftDao;
import com.lokey.payroll.models.Data.TeammateDao;
import com.lokey.payroll.models.Teammate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "teammates")
public class TeammateController {

    @Autowired
    private TeammateDao teammateDao;

    @Autowired
    private ShiftDao shiftDao;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addTeammate (Model model) {
        Teammate.Position[] positionList = Teammate.Position.values();
        model.addAttribute("positionList", positionList);
        model.addAttribute("teammate", new Teammate());
        model.addAttribute("title", "Add New Teammate");

        return "teammates/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addTeammate (Model model, @Valid @ModelAttribute Teammate teammate,
                                 Errors errors) {

        if (errors.hasErrors()) {
            Teammate.Position[] typeList = Teammate.Position.values();
            model.addAttribute("typeList", typeList);
            model.addAttribute("title", "Add New Teammate");
            return "teammates/add";
        }

        //TODO: add check for already existing teammate

        teammateDao.save(teammate);

        return "index";
    }
}
