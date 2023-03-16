package com.home.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.home.order.Enitiy.Person;
import com.home.order.repo.RepositoryPerson;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private RepositoryPerson repositoryPerson; 
    @GetMapping(path="/addtest") 
    public @ResponseBody String addNewPersontest () {
      // @ResponseBody means the returned String is the response, not a view name
      // @RequestParam means it is a parameter from the GET or POST request
      Person n = new Person();
      n.setPerson_id(0);
      //set now as date
      n.setBalance(50);
      n.setPerson_name("Benson");
      repositoryPerson.save(n);
      return "Saved";
    }
}
