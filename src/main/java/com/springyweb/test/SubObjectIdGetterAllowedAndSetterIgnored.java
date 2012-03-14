/**
 * 
 */
package com.springyweb.test;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @author si
 * 
 */
public class SubObjectIdGetterAllowedAndSetterIgnored extends BaseObjectIdGetterAndSetterIgnored {

  @Override
  /** Override ignore in the superclass */
  @JsonIgnore(value = false)
  public String getId() {
    return super.getId();
  }
}