package ru.liverfluke.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.liverfluke.dao.Composition;
import ru.liverfluke.dao.CompositionDAO;
import org.springframework.ui.Model;

@Controller
public class CompositionController {
    @Autowired
    CompositionDAO dao;

    @RequestMapping("/add_composition_form")
    public String getForm(Model m){
        m.addAttribute("command", new Composition());
        return "add_composition_form";
    }

    @RequestMapping(value="/add_сomposition",method = RequestMethod.POST)
    public String add(@ModelAttribute("comp") Composition comp){
        dao.insert(comp);
        return "redirect:/get_composition_list";//will redirect to viewemp request mapping
    }

    @RequestMapping("/get_composition_list")
    public String getList(Model m){
        List<Composition> list=dao.getAllCompositions();
        m.addAttribute("list",list);
        return "get_composition_list";
    }

    @RequestMapping(value="/get_composition_by_id/{id}")
    public String getDetails(@PathVariable int id, Model m){
        Composition comp=dao.getCompositionsById(id);
        m.addAttribute("command",comp);
        return "get_composition_by_id";
    }

    @RequestMapping(value="/edit",method = RequestMethod.POST)
    public String edit(@ModelAttribute("emp") Composition comp){
        dao.update(comp);
        return "redirect:/get_composition_list";
    }

    @RequestMapping(value="/delete_composition/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        dao.delete(id);
        return "redirect:/get_composition_list";
    }
}
