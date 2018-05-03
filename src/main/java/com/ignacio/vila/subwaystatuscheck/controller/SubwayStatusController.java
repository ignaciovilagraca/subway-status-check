package com.ignacio.vila.subwaystatuscheck.controller;

import com.ignacio.vila.subwaystatuscheck.model.Line;
import com.ignacio.vila.subwaystatuscheck.service.SubwayStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubwayStatusController {
    @Autowired
    SubwayStatusService subwayStatusService;

    @RequestMapping("/Status")
    public List<Line> getALineStatuses() {
        return subwayStatusService.getAllLinesStatuses();
    }

    @RequestMapping("/Status/{id}")
    public Line getLineStatus(@PathVariable String id) {
        return subwayStatusService.getLineStatus(id);
    }
}