package com.example.library.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

public interface ApiService {
    public String getLink(String bookName);
    JsonNode fetchBookData(String bookName) throws JsonProcessingException;
}
