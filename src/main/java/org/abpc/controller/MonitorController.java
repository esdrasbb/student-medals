package org.abpc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonitorController {

    @RequestMapping("/ping")
    @ResponseBody
    public String ping() {
        return "pong";
    }

}
