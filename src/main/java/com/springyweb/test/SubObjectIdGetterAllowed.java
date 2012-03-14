/**
 * 
 */
package com.springyweb.test;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @author si
 * 
 *         Override the getId() method and make it readable.
 */
public class SubObjectIdGetterAllowed extends BaseObjectIdGetterIgnored {

  @Override
  /** Override ignore in the superclass */
  @JsonIgnore(value = false)
  public String getId() {
    return super.getId();
  }
}