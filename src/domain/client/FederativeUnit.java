package domain.client;

import enums.Acronym;

public class FederativeUnit {

    private Acronym acronym;
    private String state;

    private FederativeUnit(Acronym acronym, String state) {
        this.acronym = acronym;
        this.state = state;
    }

    @Override
    public String toString() {
        return acronym.name() + ", " + state;
    }


    public static final class FederativeUnitBuilder {
        private Acronym acronym;
        private String state;

        public FederativeUnitBuilder() {
        }

        public FederativeUnitBuilder acronym(Acronym acronym) {
            this.acronym = acronym;
            return this;
        }

        public FederativeUnitBuilder state(String state) {
            this.state = state;
            return this;
        }

        public FederativeUnit build() {
            return new FederativeUnit(acronym, state);
        }
    }
}
