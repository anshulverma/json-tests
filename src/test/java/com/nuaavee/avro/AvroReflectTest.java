package com.nuaavee.avro;

import com.nuaavee.avro.util.AvroUtils;
import com.nuaavee.company.Company;
import com.nuaavee.company.BasicCompany;
import com.nuaavee.company.employee.Employee;
import com.nuaavee.company.employee.Name;
import com.nuaavee.company.employee.Person;
import junit.framework.TestCase;
import java.io.IOException;
import static com.google.common.collect.Lists.newArrayList;

public class AvroReflectTest extends TestCase {
  private static Company COMPANY_DTO =
    new BasicCompany("Gotham City", "LexCorp", true,
      new Person(71, new Name("Lex", "Luthor")),
      newArrayList(
          new Employee(new Name("Lana", "Lang"), 62, 999999),
          new Employee(new Name("Talia", "al Ghul"), 41, 420)));

  private static String COMPANY_JSON =
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
    assertEquals(COMPANY_JSON, AvroUtils.serializeToJson(COMPANY_DTO));
  }
  
  public void testDeserialization() throws IOException {
    assertEquals(COMPANY_DTO,
        AvroUtils.deserializeFromJson(COMPANY_JSON, BasicCompany.class));
  }
}
