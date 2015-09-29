package br.com.devsource.teste.spark.resource;

import java.io.IOException;
import java.io.StringWriter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import spark.template.thymeleaf.ThymeleafTemplateEngine;

/**
 * @author Guilherme Pacheco
 */
public abstract class AbstractResource {

  private static final ObjectMapper MAPPER;
  private static final ThymeleafTemplateEngine ENGINE;

  static {
    MAPPER = new ObjectMapper();
    MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
    ENGINE = new ThymeleafTemplateEngine();
  }

  public static ThymeleafTemplateEngine getEngine() {
    return ENGINE;
  }

  public static String dataToJson(Object data) {
    try {
      StringWriter sw = new StringWriter();
      MAPPER.writeValue(sw, data);
      return sw.toString();
    } catch (IOException e) {
      throw new RuntimeException("IOException from a StringWriter?");
    }
  }

}
