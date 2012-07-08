package com.nuaavee.json.jackson;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import com.nuaavee.model.Girl;
import static junit.framework.Assert.assertEquals;

public class AnnotationTest {

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
  private static final int GIRL_AGE = 25;
  private static final Girl GIRL_DTO = new Girl(GIRL_AGE, "Shy", "Girl");
  private static final String GIRL_JSON =
      "{\"name\":{\"firstName\":\"Shy\",\"lastName\":\"Girl\"}}";

  public void testIgnoreFieldTest()
      throws JsonGenerationException, JsonMappingException, IOException {
      assertEquals(GIRL_JSON, OBJECT_MAPPER.writeValueAsString(GIRL_DTO));
    }

  public void testCanDeserializeWithIgnoredField()
      throws JsonGenerationException, JsonMappingException, IOException {
    Girl deserializedGirl = OBJECT_MAPPER.readValue(GIRL_JSON, Girl.class);
    assertEquals(Girl.class, deserializedGirl.getClass());
    deserializedGirl.setAge(GIRL_AGE);
    assertEquals(GIRL_DTO, deserializedGirl);
  }
}
