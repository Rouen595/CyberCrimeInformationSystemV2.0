package edu.nsu.cis.service;

import edu.nsu.cis.model.db.Cybercrime;
import edu.nsu.cis.repository.CybercrimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CybercrimeService {
    @Autowired
    private CybercrimeRepository cybercrimeRepository;

    public List<Cybercrime> retrieveCybercrimeList(String cybercrimeType) {
        return cybercrimeRepository.findByCybercrimeType(cybercrimeType);
    }
    public List<Cybercrime> retrieveAll() {
        return cybercrimeRepository.findAll();
    }
    public List<String> retrieveDistinctBySeverityLevel() {
        return cybercrimeRepository.findDistinctBySeverityLevel();
    }
    public void save(Cybercrime cybercrime) {
        cybercrimeRepository.save(cybercrime);
    }

    public Cybercrime get(Integer id) {
        return cybercrimeRepository.findById(id).get();
    }

    public void delete(int id) {
        cybercrimeRepository.deleteById(id);
    }

}