/**
 * 
 */
package com.springyweb.test;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @author si
 * 
 * 
 * 
 */
public class BaseObjectIdGetterAndSetterIgnored {

  private String id;
  private String name;

  @JsonIgnore
  public String getId() {
    return id;
  }

  @JsonIgnore
  public void setId(final String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }
}