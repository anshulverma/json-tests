package com.nuaavee.json.jackson;

import static com.google.common.collect.Lists.newArrayList;
import static junit.framework.Assert.assertEquals;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.regex.Pattern;
import junit.framework.TestCase;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;
import com.nuaavee.model.Name;
import com.nuaavee.model.Person;
import com.nuaavee.model.company.BasicCompany;
import com.nuaavee.model.company.Company;
import com.nuaavee.model.company.employee.Employee;

public class DataBindTest extends TestCase {
  
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
          "\"jcr:title\":{\"firstName\":\"Lex\",\"lastName\":\"Luthor\"}" +
        "}," +
        "\"employees\":[" +
          "{" +
            "\"age\":62," +
            "\"jcr:title\":{\"firstName\":\"Lana\",\"lastName\":\"Lang\"}," +
            "\"salary\":999999.0" +
          "}," +
          "{" +
            "\"age\":41," +
            "\"jcr:title\":{\"firstName\":\"Talia\",\"lastName\":\"al Ghul\"}," +
            "\"salary\":420.0" +
          "}" +
        "]" +
      "}";
  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  public void testSerialize()
      throws JsonGenerationException, JsonMappingException, IOException {
    System.out.println(OBJECT_MAPPER.writeValueAsString(new Person(10, new Name("a", "b"))));
    System.out.println(OBJECT_MAPPER.readValue("{\"age\":10,\"jcr:title\":{\"firstName\":\"a\",\"lastName\":\"b\"}}", Person.class));
    assertEquals(COMPANY_JSON, OBJECT_MAPPER.writeValueAsString(COMPANY_DTO));
  }
  
  public void testDeserialize()
      throws JsonParseException, JsonMappingException, IOException {
    assertEquals(COMPANY_DTO,
        OBJECT_MAPPER.readValue(COMPANY_JSON, BasicCompany.class));
    List<Test> tests = newArrayList(new Test(1, "a"), new Test(2, "b"), new Test(3, "c"));
    System.out.println(tests);
    System.out.println(OBJECT_MAPPER.writeValueAsString(tests));
    List<Test> x = ObjectReader.readValue("[{\"a\":1,\"b\":\"a\"},{\"a\":2,\"b\":\"b\"},{\"a\":3,\"b\":\"c\"}]");
    Test t = ObjectReader.readValue("{\"a\":1,\"b\":\"a\"}", 1);
    System.out.println(x.get(0).getClass());
  }
  
  public static class Test {
    private int a;
    private String b;
    
    public Test() {
    }
    
    public Test(int a, String b) {
      this.a = a;
      this.b = b;
    }
    
    public int getA() {
      return a;
    }
    public void setA(int a) {
      this.a = a;
    }
    public String getB() {
      return b;
    }
    public void setB(String b) {
      this.b = b;
    }
  }
  
  static class ObjectReader {
    public static <T> List<T> readValue(String json) throws JsonParseException, JsonMappingException, IOException {
      ObjectMapper objectMapper = new ObjectMapper();
      TypeFactory typeFactory = objectMapper.getTypeFactory();
      JavaType type = typeFactory.constructType(new TypeReference<T>() { });
      List<T> items = objectMapper.readValue(json, new TypeReference<List<T>>() { });
      System.out.println(items);
      return items;
    }
    public static <T> T readValue(String json, int x) throws JsonParseException, JsonMappingException, IOException {
      ObjectMapper objectMapper = new ObjectMapper();
      TypeFactory typeFactory = objectMapper.getTypeFactory();
      JavaType type = typeFactory.constructType(new TypeReference<T>() { });
      T item = objectMapper.readValue(json, new TypeReference<T>() { });
      System.out.println(item);
      return item;
    }
  }

}
