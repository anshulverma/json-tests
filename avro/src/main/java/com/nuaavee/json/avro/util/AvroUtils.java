package com.nuaavee.json.avro.util;

import org.apache.avro.Schema;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.reflect.ReflectDatumReader;
import org.apache.avro.reflect.ReflectDatumWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class AvroUtils {

  public static <T> String serializeToJson(T obj) throws IOException {
    Schema schema = SchemaCache.getInstance().getSchema(obj.getClass());
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    Encoder encoder = EncoderFactory.get().jsonEncoder(schema, output);
    DatumWriter<T> writer = new ReflectDatumWriter<T>(schema);
    writer.write(obj, encoder);
    encoder.flush();
    return output.toString();
  }

  public static <T> T deserializeFromJson(String json, Class<? extends T> clazz)
      throws IOException {
    Schema schema = SchemaCache.getInstance().getSchema(clazz);
    DatumReader<T> reader = new ReflectDatumReader<T>(schema);
    Decoder decoder = DecoderFactory.get().jsonDecoder(schema,
        new ByteArrayInputStream(json.getBytes()));
    return reader.read(null, decoder);
  }

}
