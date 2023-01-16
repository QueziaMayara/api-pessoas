package br.com.pessoas.controller;

import br.com.pessoas.model.Person;
import br.com.pessoas.service.AddressService;
import br.com.pessoas.service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
@AutoConfigureMockMvc
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    @MockBean
    private AddressService addressService;

    @Test
    public void testCreatePersonWithSuccess() throws Exception {
        Person person = new Person();
        person.setName("John Doe");
        person.setBirthDate(LocalDate.of(2000, 1, 1));

        ObjectMapper mapper = new ObjectMapper();
        String personJson = mapper.writeValueAsString(person);

        when(personService.savePerson(ArgumentMatchers.any(Person.class))).thenReturn(person);

        final MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/people")
                        .content(personJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();


        final String response = mvcResult.getResponse().getContentAsString();
        assertThat(response, Matchers.notNullValue());
    }
}
