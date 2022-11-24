package edu.nsu.cis.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CyberResultDTO {


    public CyberResultDTO(Integer cybercrimeID, String firstName, String lastName, String state, String city, String severityLevel, String punishment, String arrestDate, String sentencingDate) {
        this.cybercrimeID = cybercrimeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.state = state;
        this.city = city;
        this.severityLevel = severityLevel;
        this.punishment = punishment;
        this.arrestDate = arrestDate;
        this.sentencingDate = sentencingDate;
    }


   /* for expansion
    private String cybercrimeID;
    private String cybercrimeType;

    private String name;

    private String state;
    private String city;

    private String severityLevel;
    private String punishment;
    private String arrestDate;
    private String sentencingDate;
    * */

    private Integer cybercrimeID;
    //private String cybercrimeType;

    private String firstName;
    private String lastName;
    //private String name;

    private String state;
    private String city;

    private String severityLevel;
    private String punishment;
    private String arrestDate;
    private String sentencingDate;

}