package com.personal.controller;

import com.personal.model.Speech;
import com.personal.entity.*;
import com.personal.model.SpeechSearch;
import com.personal.service.SpeechServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "https://speechapp1.herokuapp.com")
@RestController
@RequestMapping("speech")
@ComponentScan
public class SpeechController {

    @Autowired
    SpeechServiceImpl speechService;

    @PostMapping("/create")
    public com.personal.entity.Speech createSpeech(@RequestBody Speech request) {
        return speechService.createSpeech(request);
    }

    @GetMapping("/get/all")
    public List<com.personal.entity.Speech> getAllSpeech() {
        return speechService.getallSpeech();
    }

    @PutMapping("/update/{speechid}")
    public com.personal.entity.Speech modifySpeech(@PathVariable String speechid, @RequestBody Speech request) {
        return speechService.updateSpeech(speechid,request);
    }

    @DeleteMapping("/delete/{speechid}")
    public boolean deleteSpeech(@PathVariable String speechid) {
        return speechService.deleteSpeech(speechid);
    }

    @PostMapping("/get/speech")
    public Set<com.personal.entity.Speech> getSpeech(@RequestBody SpeechSearch request) {
        return speechService.getSpeech(request);
    }
}