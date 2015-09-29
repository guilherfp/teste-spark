package br.com.devsource.teste.spark;

import java.util.Collections;

import org.apache.commons.lang3.StringUtils;

import br.com.devsource.teste.spark.model.client.Client;
import br.com.devsource.teste.spark.model.client.ClientRepository;
import br.com.devsource.teste.spark.model.client.ClientRepositoryImpl;
import br.com.devsource.teste.spark.resource.ClientResource;
import spark.ModelAndView;
import spark.Spark;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

/**
 * @author Guilherme Pacheco
 */
public class Application {

  public static void main(String[] args) {
    ClientRepository clientRepository = new ClientRepositoryImpl();
    loadData(clientRepository);
    Spark.get("/", (req, res) -> new ModelAndView(Collections.emptyMap(), "index"),
        new ThymeleafTemplateEngine());
    new ClientResource(clientRepository);
  }

  public static void loadData(ClientRepository clientRepository) {
    for (int i = 0; i < 10; i++) {
      String cpf = StringUtils.leftPad(String.valueOf(i), 11, '0');
      clientRepository.add(new Client(i, cpf, "Client " + i, i));
    }
  }
}
