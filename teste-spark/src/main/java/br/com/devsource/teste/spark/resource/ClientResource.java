package br.com.devsource.teste.spark.resource;

import java.util.HashMap;
import java.util.Map;

import br.com.devsource.teste.spark.model.client.ClientRepository;
import spark.ModelAndView;
import spark.Spark;

/**
 * @author Guilherme Pacheco
 */
public class ClientResource extends AbstractResource {

  private static int COUNT = 0;

  public ClientResource(ClientRepository clientRepository) {
    Spark.get("/clients/json", (req, res) -> {
      System.out.println(++COUNT);
      return dataToJson(clientRepository.all());
    });
    Spark.get("/clients", (req, res) -> {
      Map<String, Object> map = new HashMap<>();
      map.put("clients", clientRepository.all());
      return new ModelAndView(map, "clients");
    } , getEngine());
  }

}
