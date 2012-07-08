package com.nuaavee.json.jackson;

import static com.google.common.collect.Lists.newArrayList;
import static junit.framework.Assert.assertEquals;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import com.nuaavee.model.Name;
import com.nuaavee.model.Person;
import com.nuaavee.model.company.BasicCompany;
import com.nuaavee.model.company.Company;
import com.nuaavee.model.company.employee.Employee;

public class DataBindTest {
  
  private static final Company COMPANY_DTO =
      new BasicCompany("Gotham City", "LexCorp", true,
        new Person(71, new com.nuaavee.model.Name("Lex", "Luthor")),
        newArrayList(
            new Employee(new Name("Lana", "Lang"), 62, 999999),
            new Employee(new Name("Talia", "al Ghul"), 41, 420)));
  private static final String COMPANY_JSON =
      "{" +
        "\"location\":\"Gotham City\"," +
        "\"name\":\"LexCorp\"," +
        "\"ipo\":true," +
        "\"owner\":{" +
          "\"age\":71," +
          "\"name\":{\"firstName\":\"Lex\",\"lastName\":\"Luthor\"}" +
        "}," +
        "\"employees\":[" +
          "{" +
            "\"age\":62," +
            "\"name\":{\"firstName\":\"Lana\",\"lastName\":\"Lang\"}," +
            "\"salary\":999999.0" +
          "}," +
          "{" +
            "\"age\":41," +
            "\"name\":{\"firstName\":\"Talia\",\"lastName\":\"al Ghul\"}," +
            "\"salary\":420.0" +
          "}" +
        "]" +
      "}";
  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  public void testSerialize()
      throws JsonGenerationException, JsonMappingException, IOException {
    assertEquals(COMPANY_JSON, OBJECT_MAPPER.writeValueAsString(COMPANY_DTO));
  }
  
  public void testDeserialize()
      throws JsonParseException, JsonMappingException, IOException {
    assertEquals(COMPANY_DTO,
        OBJECT_MAPPER.readValue(COMPANY_JSON, BasicCompany.class));
  }

}
