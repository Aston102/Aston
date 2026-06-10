package aston.hometask;

import java.util.Objects;


public final class Person {
    private final String name;
    private final int birthYear;
    private final Address address;

    public Person(final String name, final int birthYear, final Address address) {
        this.name = name;
        this.birthYear = birthYear;
        this.address = address.clone();
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address.clone();
    }

    public int getBirthYear() {
        return birthYear;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return birthYear == person.birthYear && Objects.equals(name, person.name) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthYear, address);
    }

    public static final class Address {
        private String city;
        private String street;

        public Address(final String city, final String street) {
            this.city = city;
            this.street = street;
        }
        public Address(final Address other) {
            this.city = other.city;
            this.street = other.street;
        }
        public String getCity() {
            return city;
        }

        public void setCity(final String city) {
            this.city = city;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(final String street) {
            this.street = street;
        }

        @Override
        public boolean equals(final Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Address address = (Address) o;
            return Objects.equals(city, address.city) && Objects.equals(street, address.street);
        }

        @Override
        public int hashCode() {
            return Objects.hash(city, street);
        }

        @Override
        public Address clone() {
            return new Address(this);
        }
    }
}
