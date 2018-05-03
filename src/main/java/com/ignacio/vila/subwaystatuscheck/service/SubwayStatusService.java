package com.ignacio.vila.subwaystatuscheck.service;

import com.ignacio.vila.subwaystatuscheck.model.Line;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class SubwayStatusService {
    private final static Logger logger = Logger.getLogger(SubwayStatusService.class);

    public List<Line> getAllLinesStatuses() {
        List<Line> lines = new ArrayList<>();

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("http://www.metrovias.com.ar/Subterraneos/Estado?site=Metrovias", String.class);
        JSONParser parser = new JSONParser();
        JSONArray jsonArray;
        try {
            jsonArray = (JSONArray) parser.parse(response);
        } catch (ParseException e) {
            logger.info(e.getStackTrace());
            return lines;
        }

        Iterator<JSONObject> iterator = jsonArray.iterator();
        while (iterator.hasNext()) {
            JSONObject jsonObject = iterator.next();
            Line line = new Line(String.valueOf(jsonObject.get("LineName")), String.valueOf(jsonObject.get("LineStatus")), Integer.valueOf((String) jsonObject.get("LineFrequency")));
            lines.add(line);
        }

        return lines;
    }

    public Line getLineStatus(String id) {
        List<Line> lines = getAllLinesStatuses();
        return lines.stream().filter(o -> o.getLineName().equals(id)).findAny().orElse(null);
    }
}