package com.ignacio.vila.subwaystatuscheck.service;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

public class SubwayStatusServiceTest {

    private static final String NORMAL = "[{\"LineName\":\"A\",\"LineStatus\":\"Normal\",\"LineFrequency\":\"465\"},{\"LineName\":\"B\",\"LineStatus\":\"Normal\",\"LineFrequency\":\"465\"},{\"LineName\":\"C\",\"LineStatus\":\"Normal\",\"LineFrequency\":\"405\"},{\"LineName\":\"D\",\"LineStatus\":\"Normal\",\"LineFrequency\":\"465\"},{\"LineName\":\"E\",\"LineStatus\":\"Normal\",\"LineFrequency\":\"540\"},{\"LineName\":\"H\",\"LineStatus\":\"Normal\",\"LineFrequency\":\"430\"},{\"LineName\":\"P\",\"LineStatus\":\"Normal\",\"LineFrequency\":\"555\"},{\"LineName\":\"U\",\"LineStatus\":\"Normal\",\"LineFrequency\":\"1320\"}]";
    private static final String STRIKE = "[{\"LineName\":\"A\",\"LineStatus\":\"Servicio suspendido por medida de fuerza gremial\",\"LineFrequency\":\"\"},{\"LineName\":\"B\",\"LineStatus\":\"Servicio suspendido por medida de fuerza gremial\",\"LineFrequency\":\"\"},{\"LineName\":\"C\",\"LineStatus\":\"Servicio suspendido por medida de fuerza gremial\",\"LineFrequency\":\"\"},{\"LineName\":\"D\",\"LineStatus\":\"Servicio suspendido por medida de fuerza gremial\",\"LineFrequency\":\"\"},{\"LineName\":\"E\",\"LineStatus\":\"Servicio suspendido por medida de fuerza gremial\",\"LineFrequency\":\"\"},{\"LineName\":\"H\",\"LineStatus\":\"Servicio suspendido por medida de fuerza gremial\",\"LineFrequency\":\"\"},{\"LineName\":\"P\",\"LineStatus\":\"Servicio suspendido por medida de fuerza gremial\",\"LineFrequency\":\"\"},{\"LineName\":\"U\",\"LineStatus\":\"Servicio suspendido por medida de fuerza gremial\",\"LineFrequency\":\"\"}]";

    private SubwayStatusService subwayStatusService;
    private RestTemplate templateMock;

    public SubwayStatusServiceTest() {
        subwayStatusService = new SubwayStatusService();

        templateMock = Mockito.mock(RestTemplate.class);

        subwayStatusService.setRestTemplate(templateMock);
    }

    @Test
    public void getAllLineStatusesNormalTest() {
        Mockito.when(templateMock.getForObject(anyString(), any())).thenReturn(NORMAL);

        List list = subwayStatusService.getAllLinesStatuses();
        assert (!list.isEmpty());
    }

    @Test
    public void getAllLineStatusesStrikeTest() {
        Mockito.when(templateMock.getForObject(anyString(), any())).thenReturn(STRIKE);

        List list = subwayStatusService.getAllLinesStatuses();
        assert (!list.isEmpty());
    }
}
