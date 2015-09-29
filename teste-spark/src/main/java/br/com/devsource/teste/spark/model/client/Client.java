package br.com.devsource.teste.spark.model.client;

/**
 * @author Guilherme Pacheco
 */
public class Client {

  private long id;
  private String cpf;
  private String name;
  private int age;

  public Client(long id, String cpf, String name, int age) {
    this.id = id;
    this.cpf = cpf;
    this.name = name;
    this.age = age;
  }

  public long getId() {
    return id;
  }

  public String getCpf() {
    return cpf;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (cpf == null ? 0 : cpf.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Client other = (Client) obj;
    return cpf.equals(other.cpf);
  }

  @Override
  public String toString() {
    return String.format("Client = id: %s, cpf: %s, name: %s, age: %s", id, cpf, name, age);
  }

}
