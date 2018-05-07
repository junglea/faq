package com.junglea.faq.controller;

import com.junglea.faq.model.Faq;
import com.junglea.faq.storage.mongodb.FaqRepository;
import org.json.JSONArray;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@WebMvcTest(value = FaqController.class, secure = false)
public class FaqControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FaqRepository faqRepository;

    @Test
    public void retrieveAllFaqs() throws Exception {

        List<Faq> searchFaqs = new ArrayList<>();
        searchFaqs.add(
                createFaq( "001","Question1 always", "My Answer1 found - Good",
                        Arrays.asList("Home", "Work", "Challenge")));
        searchFaqs.add(
                createFaq( "002","Question2 never", "My Answer2 found - Not good",
                        Arrays.asList("Work", "Challenge")));
        searchFaqs.add(
                createFaq( "003","Question3 may be", "My Answer3 found - notgoodforyou",
                        Arrays.asList("Work", "other")));

        Mockito.when(
                faqRepository.findBy("", ""))
                .thenReturn(searchFaqs);
        try {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                    "/api/faqs").accept(
                    MediaType.APPLICATION_JSON);

            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            Object json = JSONParser.parseJSON(result.getResponse().getContentAsString());
            assertTrue(json instanceof JSONArray);
            Assert.assertEquals(3, ((JSONArray)json).length());

        } catch (Exception e){
            fail(e.getMessage());
        }
    }

    @Test
    public void retrieveSomeFaqs() throws Exception {

        List<Faq> searchFaqs1 = new ArrayList<>();

        searchFaqs1.add(getFaq001());
        searchFaqs1.add(getFaq002());
        searchFaqs1.add(getFaq003());

        List<Faq> searchFaqs2 = new ArrayList<>();
        searchFaqs2.add(getFaq001());

        Mockito.when(
                faqRepository.findBy("", ""))
                .thenReturn(searchFaqs1);
        Mockito.when(
                faqRepository.findBy("question1", ""))
                .thenReturn(searchFaqs2);
        try {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                    "/api/faqs").accept(
                    MediaType.APPLICATION_JSON);

            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            Object json = JSONParser.parseJSON(result.getResponse().getContentAsString());
            assertTrue(json instanceof JSONArray);
            Assert.assertEquals(3, ((JSONArray)json).length());

        } catch (Exception e){
            fail(e.getMessage());
        }

        try {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                    "/api/faqs").param("question","question1").accept(
                    MediaType.APPLICATION_JSON);

            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            Object json = JSONParser.parseJSON(result.getResponse().getContentAsString());
            assertTrue(json instanceof JSONArray);
            Assert.assertEquals(1, ((JSONArray)json).length());

            JSONAssert.assertEquals("["+getFaqAsJsonString(getFaq001())+"]", result.getResponse()
                    .getContentAsString(), false);

        } catch (Exception e){
            fail(e.getMessage());
        }
    }


    private Faq getFaq001(){
        return createFaq( "001","Question1 always", "My Answer1 found - Good",
                Arrays.asList("Home", "Work", "Challenge"));
    }

    private Faq getFaq002(){
        return createFaq( "002","Question2 never", "My Answer2 found - Not good",
                Arrays.asList("Work", "Challenge"));
    }

    private Faq getFaq003(){
        return createFaq( "003","Question3 may be", "My Answer3 found - notgoodforyou",
                Arrays.asList("Work", "other"));
    }


    private Faq createFaq(String id, String question, String answer, List<String> tags){
        Faq newFaq = new Faq();
        newFaq.setId(id/*UUID.randomUUID().toString()*/);
        newFaq.setQuestion(question);
        newFaq.setAnswer(answer);
        newFaq.setTags(tags);
        return newFaq;
    }


    public String getFaqAsJsonString(Faq faq){
        return String.format("{\"id\":\"%s\",\"question\":\"%s\",\"answer\":\"%s\",\"tags\":%s}",
                faq.getId(),
                faq.getQuestion(),
                faq.getAnswer(),
                faq.getTags().toString());
    }


}
