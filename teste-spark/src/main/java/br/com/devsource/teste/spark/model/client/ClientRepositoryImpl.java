package br.com.devsource.teste.spark.model.client;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author Guilherme Pacheco
 */
public class ClientRepositoryImpl implements ClientRepository {

  private Set<Client> clients = new HashSet<>();

  @Override
  public Optional<Client> byId(long id) {
    return clients.stream().filter(c -> c.getId() == id).findFirst();
  }

  @Override
  public void add(Client client) {
    clients.add(client);
  }

  @Override
  public Set<Client> all() {
    return clients;
  }

}
