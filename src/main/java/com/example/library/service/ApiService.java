package com.example.library.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

public interface ApiService {
    String getLink(String name);
    JsonNode fetchData(String name) throws JsonProcessingException;
}
