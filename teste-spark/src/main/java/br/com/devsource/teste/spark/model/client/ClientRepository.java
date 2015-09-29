package br.com.devsource.teste.spark.model.client;

import java.util.Optional;
import java.util.Set;

/**
 * @author Guilherme Pacheco
 */
public interface ClientRepository {

  Optional<Client> byId(long id);

  void add(Client client);

  Set<Client> all();

}
