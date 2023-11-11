
package domain.client;

import java.util.Objects;

public class Client {
    private String name;
    private String cpf;
    private String phoneNumber;
    private Adress adress;

    private Client(String name, String cpf, String phoneNumber, Adress adress) {
        this.name = name;
        this.cpf = cpf;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) && Objects.equals(cpf, client.cpf) && Objects.equals(phoneNumber, client.phoneNumber) && Objects.equals(adress, client.adress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cpf, phoneNumber, adress);
    }

    @Override
    public String toString() {
        return name + ", " + cpf + ", " + phoneNumber + ", " + "\n" + adress;
    }


    public static final class ClientBuilder {
        private String name;
        private String cpf;
        private String phoneNumber;
        private Adress adress;

        public ClientBuilder() {
        }

        public ClientBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ClientBuilder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public ClientBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public ClientBuilder adress(Adress adress) {
            this.adress = adress;
            return this;
        }

        public Client build() {
            return new Client(name, cpf, phoneNumber, adress);
        }
    }
}
