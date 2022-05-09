package com.personal.service;

import com.personal.entity.Speech;
import com.personal.filter.SpeechSpecification;
import com.personal.model.SpeechSearch;
import com.personal.repository.SpeechRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@ComponentScan
public class SpeechServiceImpl implements SpeechService {
    private Logger log = LogManager.getLogger(SpeechServiceImpl.class);

    @Autowired
    SpeechRepository speechRepository;

    public Speech createSpeech(com.personal.model.Speech request) {
        Speech response=new Speech();
        log.info("createInstrument (START)",request.toString());
        response.setAuthor(request.getAuthor());
        response.setBody(request.getBody());
        response.setCreatedDate(LocalDate.now().toString());
        response.setSubject(request.getSubject());
        response= speechRepository.save(response);
        log.info("createInstrument (END)",response.toString());
        return response;
    }

    public List<Speech> getallSpeech() {
        log.info("getallSpeech (START)");
        List<Speech> responce= speechRepository.findAll();
        log.info("getallSpeech (END)");
        return responce;
    }
    public Set<Speech>  getSpeech(SpeechSearch request) {
        log.info("getSpeech (START)");
        Specification<Speech> specification = SpeechSpecification.filterpredicatesBySpeechSearch(request);
        Set<Speech> responce = new HashSet<Speech>(speechRepository.findAll(specification));
        log.info("getSpeech (END)");
        return responce;
    }

    public boolean deleteSpeech(String speechid) {
        log.info("deleteSpeech (START)");
        speechRepository.deleteById(speechid);
        log.info("deleteSpeech (END)");
        return true;
    }
    public Speech updateSpeech(String speechid,com.personal.model.Speech request) {
        Speech response = null;
        try {
            if (!speechid.isEmpty())
                log.info("updateSpeech (START)", request.toString());
            response = speechRepository.findById(speechid).get();
            if (!request.getAuthor().isEmpty())
                response.setAuthor(request.getAuthor());
            if (!request.getBody().isEmpty())
                response.setBody(request.getBody());
            if (!request.getSubject().isEmpty())
                response.setSubject(request.getSubject());
            response = speechRepository.save(response);
            log.info("updateSpeech (END)", response.toString());
        }
        catch (Exception e){
            log.error(e.toString());
        }
        return response;
    }
}