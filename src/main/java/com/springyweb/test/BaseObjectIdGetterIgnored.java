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
public class BaseObjectIdGetterIgnored {

  private String id;
  private String name;

  @JsonIgnore
  public String getId() {
    return id;
  }

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
