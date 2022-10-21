package edu.nsu.cis.model;

import edu.nsu.cis.model.enums.Cybercrime;
import edu.nsu.cis.model.enums.Severity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CyberSearch {

  private Cybercrime cybercrime;
  private Severity severity;

}