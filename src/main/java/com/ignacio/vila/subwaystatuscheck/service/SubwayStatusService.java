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
    private static final Logger logger = Logger.getLogger(SubwayStatusService.class);
    private static final String API_METROVIAS = "http://www.metrovias.com.ar/Subterraneos/Estado?site=Metrovias";

    private RestTemplate restTemplate;
    private Gson gson;

    public SubwayStatusService(){
        restTemplate = new RestTemplate();
        gson = new Gson();
    }

    public List<Line> getAllLinesStatuses() {
        List lines = new ArrayList<Line>();

        String response = restTemplate.getForObject(API_METROVIAS, String.class);

        List<JsonObject> jsonObjects = gson.fromJson(response, new TypeToken<List<JsonObject>>(){}.getType());

        for (JsonObject jsonObject:
             jsonObjects) {

            String lineName = jsonObject.getAsJsonPrimitive("LineName").getAsString();

            String lineStatus = jsonObject.getAsJsonPrimitive("LineStatus").getAsString();

            String lineFrequency = jsonObject.getAsJsonPrimitive("LineFrequency").getAsString();

            Integer parsedLineFrequency = lineFrequency.isEmpty() ? 0 : Integer.valueOf(lineFrequency);

            lines.add(new Line(lineName, lineStatus, parsedLineFrequency));

            logger.info("Fetched information for line: ".concat(lineName));
        }

        return lines;
    }

    public Line getLineStatus(String id) {
        List<Line> lines = getAllLinesStatuses();
        return lines.stream().filter(o -> o.getLineName().equals(id)).findAny().orElse(null);
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}