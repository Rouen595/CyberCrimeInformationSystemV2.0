package edu.nsu.cis.service;

import edu.nsu.cis.model.db.Cybercrime;
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

    public List<Cybercrimes> searchCybercrimes(Integer id, String state) {
        return cybercrimesRepository.searchByParameters(id, state);
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