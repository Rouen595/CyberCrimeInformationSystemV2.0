package edu.nsu.cis.service;

import edu.nsu.cis.model.CyberResultDTO;
import edu.nsu.cis.model.db.Cybercrime;
import edu.nsu.cis.model.db.Cybercrimes;
import edu.nsu.cis.repository.CybercrimesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CybercrimesService {
    @Autowired
    private CybercrimesRepository cybercrimesRepository;

    public List<Cybercrimes> retrieveAll() {
        return cybercrimesRepository.findAll();
    }

    //switching to search by params instead of parameters
    public List<Cybercrimes> searchCybercrimes(Integer id, String severity, String punishment, String arrest, String sentence, String firstName, String lastName,
                                               String address, String city, String state, String zip) {
        return cybercrimesRepository.searchByParams(id, severity, punishment, arrest, sentence, firstName, lastName, address, city, state, zip);
    }

    public void save(Cybercrimes cybercrimes) {
        cybercrimesRepository.save(cybercrimes);
    }

    public Cybercrimes get(Integer id) {
        return cybercrimesRepository.findById(id).get();
    }

    public void delete(int id) {
        cybercrimesRepository.deleteById(id);
    }



}