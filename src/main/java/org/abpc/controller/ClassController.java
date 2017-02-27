package org.abpc.controller;


import org.abpc.bean.Classes;
import org.abpc.bean.Medal;
import org.abpc.bean.Student;
import org.abpc.repository.ClassesRepository;
import org.abpc.repository.MedalRepository;
import org.abpc.repository.StudentRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClassController {

    private static final String API_CONTEXT = "/api/v1";
    private static final String ID_SPLIT_TOKEN = "#";

    @Autowired
    private ClassesRepository classesRepository;

    @Autowired
    private MedalRepository medalRepository;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping(API_CONTEXT + "/classes")
    @ResponseBody
    public Iterable<Classes> findAll() {
        return classesRepository.findAllByOrderByDateAsc();
    }

    @GetMapping(API_CONTEXT + "/classes/{id}")
    @ResponseBody
    public Classes byId(@RequestParam Integer id) {
        return classesRepository.findOne(id);
    }

    @PostMapping(API_CONTEXT + "/classes")
    @ResponseBody
    public Classes create(@RequestBody Classes classes) {
        return classesRepository.save(classes);
    }

    @PostMapping(API_CONTEXT + "/class")
    @ResponseBody
    public Medal addClassToStudent(@RequestBody String ids) {
        if (StringUtils.isBlank(ids)) {
            //TODO adicionar chamada para o logger e identificar como retornar erro
        }

        String[] idsValues = StringUtils.split(ids, ID_SPLIT_TOKEN);
        Student student = studentRepository.findOne(Integer.valueOf(idsValues[0]));
        Classes classes = classesRepository.findOne(Integer.valueOf(idsValues[1]));
        Integer amount = Integer.valueOf(idsValues[2]);
        return medalRepository.save(new Medal(amount, student, classes));
    }

}
