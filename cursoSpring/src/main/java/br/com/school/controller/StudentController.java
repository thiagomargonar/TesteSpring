package br.com.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class StudentController {

    public String retornoNomeJson(String name){
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode arrayNode = mapper.createArrayNode();

        ObjectNode objectNode1 = mapper.createObjectNode();
        objectNode1.put("Name", name);

        return  objectNode1.toString();
    }


}




