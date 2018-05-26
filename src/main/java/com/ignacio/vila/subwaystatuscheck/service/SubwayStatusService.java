package com.ignacio.vila.subwaystatuscheck.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.ignacio.vila.subwaystatuscheck.model.Line;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubwayStatusService {
    private final static Logger logger = Logger.getLogger(SubwayStatusService.class);

    public List<Line> getAllLinesStatuses() {
        List lines = new ArrayList<Line>();

        RestTemplate restTemplate = new RestTemplate();

        String response = restTemplate.getForObject("http://www.metrovias.com.ar/Subterraneos/Estado?site=Metrovias", String.class);

        Gson gson = new Gson();

        List<JsonObject> jsonObjects = gson.fromJson(response, new TypeToken<List<JsonObject>>(){}.getType());

        for (JsonObject jsonObject:
             jsonObjects) {

            String lineName = jsonObject.getAsJsonPrimitive("LineName").getAsString();

            String lineStatus = jsonObject.getAsJsonPrimitive("LineStatus").getAsString();

            Integer lineFrequency = jsonObject.getAsJsonPrimitive("LineFrequency").getAsInt();

            lines.add(new Line(lineName, lineStatus, lineFrequency));

            logger.info("Fetched information for line: ".concat(lineName));
        }

        return lines;
    }

    public Line getLineStatus(String id) {
        List<Line> lines = getAllLinesStatuses();
        return lines.stream().filter(o -> o.getLineName().equals(id)).findAny().orElse(null);
    }
}