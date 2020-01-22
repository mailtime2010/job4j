package company;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * Address.
 *
 * @author Maxim Vanny
 * @version 4.0
 * @since 0.1
 */
public class Address {
    /**
     * city.
     */
    private final String city;
    /**
     * street.
     */
    private final String street;
    /**
     * home.
     */
    private final int home;
    /**
     * apartment.
     */
    private final int apartment;

    /**
     * Constructor.
     *
     * @param aCity      city
     * @param aStreet    street
     * @param aHome      home
     * @param aApartment apartment
     */
    public Address(final String aCity, final String aStreet,
                   final int aHome, final int aApartment) {
        this.city = aCity;
        this.street = aStreet;
        this.home = aHome;
        this.apartment = aApartment;
    }

    /**
     * Method get user's city.
     *
     * @return city
     */
    public final String getCity() {
        return this.city;
    }

    @Override
    public final String toString() {
        return new StringJoiner(", ", Address.class.getSimpleName()
                + "[", "]")
                .add("city='" + city + "'")
                .add("street='" + street + "'")
                .add("home=" + home)
                .add("apartment=" + apartment)
                .toString();
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Address address = (Address) o;
        return this.city.equals(address.city);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.city);
    }
}
