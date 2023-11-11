package services;

import domain.client.*;
import enums.Acronym;

import java.util.*;

public class ClientService {
    public ClientService() {
    }

    public Client createClient() {

        System.out.println("Name: (only letters!)");
        String name = "João";

        while (!validName(name)) {
            System.out.println("Invalid!");
            System.out.println("Name: (only letters!)");
            name = ReadService.readString();
        }

        System.out.println("Cpf: (only numbers!)");
        String cpf = "121.798.237-03";

        while (!validDocument(cpf)) {
            System.out.println("Invalid!");
            System.out.println("Cpf: (only numbers!)");
            cpf = ReadService.readString();
        }

        System.out.println("Phone number: (only numbers and special chars!)");
        String phoneNumber = "21989432205";


        while (!validPhoneNumber(phoneNumber)) {
            System.out.println("Invalid!");
            System.out.println("Phone number: (only numbers!)");
            phoneNumber = ReadService.readString();
        }

        Adress adress = createAdress(name);

        System.out.println(name + "Created! ");
        System.out.println();

        //Using builder pattern
        return new Client.ClientBuilder()
                .name(name)
                .cpf(cpf)
                .phoneNumber(phoneNumber)
                .adress(adress)
                .build();
    }

    private Adress createAdress(String name) {

        System.out.println("Your Federative unit and state, Mr/s " + name);
        int i = 1;

        //Mapping keys for get
        List<Acronym> keys = new ArrayList<>();
        for (Map.Entry<Acronym, String> pair : MockService.getMockUfsAndStates().entrySet()) {
            System.out.println(i + " - " + pair.getKey().toString() + " - State of " + pair.getValue());
            keys.add(pair.getKey());
            i++;
        }

        System.out.print("Your choice: ");
        int choice = 1;
        while (!ValidUtilService.validChoice(choice, keys.size())) {
            System.out.println("Invalid!");

            i = 1;
            for (Acronym key : keys) {
                System.out.println(i + key.toString() + " - State of " + MockService.getMockUfsAndStates().get(key));
                i++;
            }

            System.out.print("Your choice: ");
            choice = ReadService.readInt();
        }

        Acronym acronym = keys.get(choice - 1);
        String state = MockService.getMockUfsAndStates().get(acronym);
        FederativeUnit federativeUnit = new FederativeUnit.FederativeUnitBuilder()
                .acronym(acronym)
                .state(state)
                .build();

        System.out.println("Your house number: (only numbers!)");
        long number = 22L;

        while (!validHouseNumber(number)) {
            System.out.println("Invalid!");
            System.out.println("Your house number: (only numbers!)");
            number = ReadService.readLong();
        }

        System.out.println("District: ");
        String district = "bahia";

        System.out.println("City: ");
        String city = "americo";

        System.out.println("Complement: ");
        String complement = "arqueologia";

        return new Adress.AdressBuilder()
                .street(state)
                .number(number)
                .district(district)
                .city(city)
                .complement(complement)
                .federativeUnit(federativeUnit)
                .build();

    }

    public Client removeClient() {
        System.out.println("Client deleted!");
        return null;
    }

    private boolean validName(String name) {
        return (name.length() >= 2) && (name.matches("^[a-zA-ZÀ-ÿ,\". ]+$"));
    }

    private boolean validDocument(String cpf) {
        return cpf.matches("^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$");
    }

    private boolean validPhoneNumber(String phoneNumber) {
        return phoneNumber
                .matches("^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$");
    }

    private boolean validHouseNumber(long number) {
        return number >= 0;
    }

}
