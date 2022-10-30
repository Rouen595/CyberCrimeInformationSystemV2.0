package edu.nsu.cis.service;

import edu.nsu.cis.model.db.Cybercrimes;
import edu.nsu.cis.repository.CybercrimesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CybercrimesService {
    @Autowired
    private CybercrimesRepository cybercrimesRepository;

    public List<Cybercrimes> retrieveCybercrimesList(Integer id) {
        return cybercrimesRepository.findByid(id);
    }
    public List<Cybercrimes> retrieveAll() {
        return cybercrimesRepository.findAll();
    }

}