package com.icare.ing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.icare.ing.dto.Count;
import com.icare.ing.service.IngestionService;
import com.icare.ing.service.WordCount;

import java.util.List;

/**
 * Created by Owner on 2017. 03. 29..
 */
@Controller
@RequestMapping("/ingestion")
public class ApiController {
    @Autowired
    WordCount wordCount;

    @Autowired
    IngestionService ingestionService;
    
    @RequestMapping(value="/wordcount", method = RequestMethod.GET)
    public ResponseEntity<List<Count>> words() {
        return new ResponseEntity<>(wordCount.count(), HttpStatus.OK);
    }
    
    @RequestMapping(value="/ingest", method = RequestMethod.GET)
    public ResponseEntity<String> ingest() throws InterruptedException {
    	//ingestionService.docal();
        return new ResponseEntity<String>("", HttpStatus.OK);
    }
}
