package com.laissantiago.cursomc.resources.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class StandardError implements Serializable {
  
  private static final long serialVersionUID = 625292258261698147L;
  
  private Integer status;
  private String msg;
  private Long timeStamp;
  
  public StandardError(Integer status, String msg, Long timeStamp) {
    this.status = status;
    this.msg = msg;
    this.timeStamp = timeStamp;
  }

}
