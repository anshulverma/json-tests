package com.nuaavee.json.avro.util;

import org.apache.avro.Schema;
import org.apache.avro.reflect.ReflectData;
import java.util.Map;
import static com.google.common.collect.Maps.newHashMap;

public class SchemaCache {

  private static SchemaCache INSTANCE;

  private final Map<String, Schema> cache = newHashMap();

  private SchemaCache() {
  }

  public static SchemaCache getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new SchemaCache();
    }
    return INSTANCE;
  }

  public <T> Schema getOrCreateSchema(String key, Class<? extends T> clazz) {
    Schema schema = cache.get(key);
    if (schema == null) {
      schema = ReflectData.get().getSchema(clazz);
      cache.put(key, schema);
    }
    return schema;
  }

  public Schema getOrCreateSchema(String key, String schemaDescription) {
    Schema schema = cache.get(key);
    if (schema == null) {
      schema = Schema.parse(schemaDescription, true);
      cache.put(key, schema);
    }
    return schema;
  }

  public <T> Schema getSchema(Class<? extends T> clazz) {
    return getOrCreateSchema(clazz.getCanonicalName(), clazz);
  }

}
