package org.honorSociety.model.common;

public enum Degree {
    MASTERS {
        @Override
        public String toString(){
            return "Masters";
        }
    },
    DOCTORATE {
        @Override
        public String toString(){
            return "Doctorate";
        }
    };
    private final String value;

    Degree(String value) {
        this.value = value;
    }

    Degree() {
        this.value = null;
    }


    public String getValue() {
        return value;
    }



}