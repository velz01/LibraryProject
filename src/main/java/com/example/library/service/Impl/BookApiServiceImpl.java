package com.example.library.service.Impl;

import com.example.library.Constants;
import com.example.library.service.ApiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Service
public class BookApiServiceImpl implements ApiService {
    public final RestTemplate restTemplate;
    public final ObjectMapper mapper;


    @Override
    public String getLink(String bookName) {
        String bookNameForQuery = bookName.replaceAll(" ", "+");
        return Constants.DOMAIN + bookNameForQuery;
    }


//    public Book getInfoFromApi(String bookName) throws JsonProcessingException {
//        String link = getLink(bookName);
//        String response = restTemplate.getForObject(link, String.class);
//        JsonNode node = mapper.readTree(response);
//        Book book =  bookInfoService.getBookInfo(node);
//        System.out.println(book);
//        return book;
//
//    }
    public JsonNode fetchData(String bookName) throws JsonProcessingException {
        String link = getLink(bookName);
        String response = restTemplate.getForObject(link, String.class);
        return mapper.readTree(response);

    }




}