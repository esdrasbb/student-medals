package org.abpc.controller;


import org.abpc.bean.Medal;
import org.abpc.repository.MedalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedalController {

    private static final String API_CONTEXT = "/api/v1";

    @Autowired
    private MedalRepository medalRepository;

    @GetMapping(API_CONTEXT + "/medals")
    @ResponseBody
    public Iterable<Medal> getMedals() {
        return medalRepository.findAll();
    }

}
