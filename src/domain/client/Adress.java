package domain.client;

import java.util.Objects;

public class Adress {
    private String street;
    private long number;
    private String district;
    private String city;
    private String complement;
    private FederativeUnit federativeUnit;

    public Adress(String street, long number, String district, String city, String complement, FederativeUnit federativeUnit) {
        this.street = street;
        this.number = number;
        this.district = district;
        this.city = city;
        this.complement = complement;
        this.federativeUnit = federativeUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adress adress = (Adress) o;
        return Objects.equals(street, adress.street) && Objects.equals(number, adress.number) && Objects.equals(district, adress.district) && Objects.equals(city, adress.city) && Objects.equals(complement, adress.complement) && Objects.equals(federativeUnit, adress.federativeUnit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, number, district, city, complement, federativeUnit);
    }

    @Override
    public String toString() {
        return street + ", " + number + ", " + complement + district + ", " +
                "\n" +
                city + ", " + federativeUnit;
    }


    public static final class AdressBuilder {
        private String street;
        private long number;
        private String district;
        private String city;
        private String complement;
        private FederativeUnit federativeUnit;

        public AdressBuilder() {
        }

        public AdressBuilder street(String street) {
            this.street = street;
            return this;
        }

        public AdressBuilder number(long number) {
            this.number = number;
            return this;
        }

        public AdressBuilder district(String district) {
            this.district = district;
            return this;
        }

        public AdressBuilder city(String city) {
            this.city = city;
            return this;
        }

        public AdressBuilder complement(String complement) {
            this.complement = complement;
            return this;
        }

        public AdressBuilder federativeUnit(FederativeUnit federativeUnit) {
            this.federativeUnit = federativeUnit;
            return this;
        }

        public Adress build() {
            return new Adress(street, number, district, city, complement, federativeUnit);
        }
    }
}
