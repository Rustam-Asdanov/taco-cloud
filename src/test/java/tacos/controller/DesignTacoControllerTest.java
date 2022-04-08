package tacos.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DesignTacoController.class)
class DesignTacoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void addIngredientsToModel() {
    }

    @Test
    void order() {

    }

    @Test
    void taco() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/design"))
                .andExpect(status().isOk())
                .andExpect(view().name("design"))
                .andExpect(content().string(containsString("Design your taco")));
    }

    @Test
    void getMessage() {
    }

    @Test
    void showDesignForm() {
    }

    @Test
    void processTaco() {
    }
}