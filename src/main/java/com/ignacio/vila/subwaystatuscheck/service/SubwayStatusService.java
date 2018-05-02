package com.ignacio.vila.subwaystatuscheck.service;

import com.ignacio.vila.subwaystatuscheck.SubwayStatusException;
import com.ignacio.vila.subwaystatuscheck.model.LineStatus;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.expression.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Service
public class SubwayStatusService {
    private final static Logger logger = Logger.getLogger(SubwayStatusService.class);

    public List<LineStatus> getAllLinesStatuses() {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("http://www.metrovias.com.ar/Subterraneos/Estado?site=Metrovias", String.class);
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = null;
        try {
            jsonArray = (JSONArray) parser.parse(response);
        } catch (ParseException e) {
            logger.info(e.getStackTrace());
        }
        List<LineStatus> lineStatuses = new ArrayList<>();
        Iterator<JSONObject> iterator = jsonArray.iterator();
        while (iterator.hasNext()) {
            JSONObject jsonObject = iterator.next();
            LineStatus lineStatus = new LineStatus(String.valueOf(jsonObject.get("LineName")), String.valueOf(jsonObject.get("LineStatus")), Integer.valueOf((String) jsonObject.get("LineFrequency")));
            lineStatuses.add(lineStatus);
        }

        return lineStatuses;
    }

    public LineStatus getLineStatus(String id) {
        List<LineStatus> lineStatuses = getAllLinesStatuses();
        return lineStatuses.stream().filter(o -> o.getLineName().equals(id)).findAny().orElse(null);
    }
}