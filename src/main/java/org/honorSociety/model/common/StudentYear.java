package org.honorSociety.model.common;

public enum StudentYear {
    FRESHMAN {
        @Override
        public String toString(){
            return "Freshman";
        }
    },
    SOPHOMORE {
        @Override
        public String toString(){
            return "Sophomore";
        }
    },
    JUNIOR {
        @Override
        public String toString(){
            return "Junior";
        }
    },
    SENIOR {
        @Override
        public String toString(){
            return "Senior";
        }
    };
    private final String value;

    StudentYear(String value) {
        this.value = value;
    }

    StudentYear() {
        this.value = null;
    }

    public String getValue() {
        return value;
    }

}