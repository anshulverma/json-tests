package com.nuaavee.json.avro;

import com.nuaavee.model.Name;
import com.nuaavee.model.Person;
import com.nuaavee.model.company.Company;
import com.nuaavee.model.company.BasicCompany;
import com.nuaavee.model.company.employee.Employee;
import java.io.IOException;
import static com.google.common.collect.Lists.newArrayList;
import static com.nuaavee.json.avro.util.AvroUtils.deserializeFromJson;
import static com.nuaavee.json.avro.util.AvroUtils.serializeToJson;
import static junit.framework.Assert.assertEquals;

public class ReflectTest {
  private static final Company COMPANY_DTO =
    new BasicCompany("Gotham City", "LexCorp", true,
      new Person(71, new Name("Lex", "Luthor")),
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
          "\"salary\":999999.0," +
          "\"age\":62," +
          "\"name\":{\"firstName\":\"Lana\",\"lastName\":\"Lang\"}" +
        "}," +
        "{" +
          "\"salary\":420.0," +
          "\"age\":41," +
          "\"name\":{\"firstName\":\"Talia\",\"lastName\":\"al Ghul\"}" +
        "}" +
      "]" +
    "}";

  public void testSerialization() throws IOException {
    assertEquals(COMPANY_JSON, serializeToJson(COMPANY_DTO));
  }

  public void testDeserialization() throws IOException {
    assertEquals(COMPANY_DTO,
        deserializeFromJson(COMPANY_JSON, BasicCompany.class));
  }
}
