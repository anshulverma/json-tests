package com.nuaavee.json.jackson.complextype;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import junit.framework.TestCase;
import org.codehaus.jackson.map.ObjectMapper;
import com.nuaavee.model.complextype.Comparison;
import com.nuaavee.model.complextype.Data;
import com.nuaavee.model.complextype.DataType;
import com.nuaavee.model.complextype.OperatorType;

public class ComplexTypeTest extends TestCase {

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
  private static final String SERIALIZED_DATA =
    "{" +
      "\"id\":1," +
      "\"comment\":\"some comment\"," +
      "\"type\":\"STRING\"," +
      "\"operator\":\"EQUALS\"," +
      "\"expression\":{" +
        "\"value\":\"something\"" +
      "}" +
    "}";
  private static final Data DESERIALIZED_DATA;
  
  static {
    Map<String, Object> expression = new HashMap<String, Object>();
    expression.put("value", "something");
    DESERIALIZED_DATA = new Data(1, "some comment", DataType.STRING,
      new Comparison(OperatorType.EQUALS, expression));
  }

  public void testSerialize() throws IOException {
    assertEquals(SERIALIZED_DATA,
        OBJECT_MAPPER.writeValueAsString(DESERIALIZED_DATA));
    assertEquals(DESERIALIZED_DATA,
        OBJECT_MAPPER.readValue(SERIALIZED_DATA,Data.class));
  }
}
