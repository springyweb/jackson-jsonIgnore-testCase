/**
 * 
 */
package com.springyweb.test;

import static org.hamcrest.Matchers.equalTo;

import java.io.StringWriter;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import com.jayway.jsonassert.JsonAssert;

/**
 * @author si<si@springyweb.com>
 * 
 *         Test cases for @JSONIgnore behavior with Jackson
 * 
 */
public class JacksonIgnoreTest {

  StringWriter writer;
  ObjectMapper mapper;

  @Before
  public void setup() {
    writer = new StringWriter();
    mapper = new ObjectMapper();
  }

  /**
   * As the getter for id is annotated with @JSONIgnore it should not be defined
   * in the JSON output after serialization
   * 
   * @throws Exception
   */
  @Test
  public void testIgnoreIdGetter() throws Exception {
    final BaseObjectIdGetterIgnored obj = new BaseObjectIdGetterIgnored();
    final String id = "id_foo";
    final String name = "name_bar";
    obj.setId(id);
    obj.setName(name);
    mapper.writeValue(writer, obj);
    final String json = writer.toString();
    JsonAssert.with(json).assertThat("name", equalTo(name));
    JsonAssert.with(json).assertNotDefined("id");
  }

  /**
   * As the getter for id is annotated with @JSONIgnore(value=false) in the
   * subclass it should be defined in the JSON output after serialization
   * 
   * @throws Exception
   */
  @Test
  public void testAllowOverridenIgnoreIdGetter() throws Exception {
    final SubObjectIdGetterAllowed obj = new SubObjectIdGetterAllowed();
    final String id = "id_foo";
    final String name = "name_bar";
    obj.setId(id);
    obj.setName(name);
    mapper.writeValue(writer, obj);
    final String json = writer.toString();
    JsonAssert.with(json).assertThat("name", equalTo(name));
    JsonAssert.with(json).assertThat("id", equalTo(id));
  }

  /**
   * As the getter for id is annotated with @JSONIgnore it should not be defined
   * in the JSON output after serialization
   * 
   * @throws Exception
   */
  @Test
  public void testIgnoreIdGetterAndSetterAnnotated() throws Exception {
    final BaseObjectIdGetterAndSetterIgnored obj = new BaseObjectIdGetterAndSetterIgnored();
    final String id = "id_foo";
    final String name = "name_bar";
    obj.setId(id);
    obj.setName(name);
    mapper.writeValue(writer, obj);
    final String json = writer.toString();
    JsonAssert.with(json).assertThat("name", equalTo(name));
    JsonAssert.with(json).assertNotDefined("id");
  }

  /**
   * As the getter for id is annotated with @JSONIgnore(value=false) in the
   * subclass it should be defined in the JSON output after serialization
   * 
   * @throws Exception
   */
  @Test
  public void testAllowOverridenGetterAndIgnoreSetter() throws Exception {
    final SubObjectIdGetterAllowedAndSetterIgnored obj = new SubObjectIdGetterAllowedAndSetterIgnored();
    final String id = "id_foo";
    final String name = "name_bar";
    obj.setId(id);
    obj.setName(name);
    mapper.writeValue(writer, obj);
    final String json = writer.toString();
    JsonAssert.with(json).assertThat("name", equalTo(name));
    JsonAssert.with(json).assertThat("id", equalTo(id));
  }
}