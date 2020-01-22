package company;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Profiles.
 *
 * @author Maxim Vanny
 * @version 4.0
 * @since 0.1
 */
public class Profiles {

    /**
     * Method collect by address from profiles to list.
     *
     * @param profiles list profiles
     * @return list address
     */
    public final List<Address> collect(final List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }

    /**
     * Method return distinct address.
     *
     * @param profiles list profiles
     * @return list distinct address
     */
    public final List<Address> distinct(final List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .sorted(Comparator.comparing(Address::getCity))
                .distinct()
                .collect(Collectors.toList());
    }

}
