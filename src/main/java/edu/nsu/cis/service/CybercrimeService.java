package edu.nsu.cis.service;

import edu.nsu.cis.model.db.Cybercrime;
import edu.nsu.cis.repository.CybercrimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CybercrimeService {
    @Autowired
    private CybercrimeRepository cybercrimeRepository;

    public List<Cybercrime> retrieveCybercrimeList(String cybercrimeType) {
        return cybercrimeRepository.findByCybercrimeType(cybercrimeType);
    }

}