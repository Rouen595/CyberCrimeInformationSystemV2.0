package edu.nsu.cis.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CyberSearchDTO {

  private String cybercrimeType;
  private String severityLevel;

  private String punishment;
  private String arrestDate;
  private String sentencingDate;

  private String firstName;
  private String lastName;
  private String age;
  private String streetAddress;
  private String city;
  private String state;
  private String zipcode;

  private String personType;

}