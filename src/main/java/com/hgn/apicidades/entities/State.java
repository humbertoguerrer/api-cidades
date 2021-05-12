package com.hgn.apicidades.entities;

import com.vladmihalcea.hibernate.type.json.*;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.*;

@Entity(name = "State")
@Table(name = "estado")
@TypeDefs({@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)})
public class State {

  @Id private Long id;

  @Column(name = "nome")
  private String name;

  private String uf;

  private Integer ibge;

  @ManyToOne
  @JoinColumn(name = "pais", referencedColumnName = "id")
  private Country country;

  @Type(type = "jsonb")
  @Basic(fetch = FetchType.LAZY)
  @Column(name = "ddd", columnDefinition = "jsonb")
  private List<Integer> ddd;

  public State() {}

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getUf() {
    return uf;
  }

  public Integer getIbge() {
    return ibge;
  }

  public List<Integer> getDdd() {
    return ddd;
  }

  public Country getCountry() {
    return country;
  }
}
