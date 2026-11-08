package be.osse.focus_track_api.controller.projects;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("it")
class ProjectControllerIT {

    @Autowired
    MockMvc mvc;

    @Test
    void testFindAll() throws Exception {
        // GIVEN

        // WHEN
        mvc.perform(get("/projects")
                        .contentType(MediaType.APPLICATION_JSON))

                // THEN
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].title").value("Project Alpha"))
                .andExpect(jsonPath("$.length()").value("3"));
    }
}
