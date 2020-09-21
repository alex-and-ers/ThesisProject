package main.controller;

import main.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

public class DefaultController
{
    @Autowired
    Repo repo;

    @RequestMapping("/")
    public String index()
    {
        return "index";
    }
}
