package accident.service;

import accident.model.Accident;

import java.util.List;

/**
 * IAccidentService.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/4/2020
 */
public interface IAccidentService {
    /**
     * Method to save.
     *
     * @param accident a accident
     * @return a accident
     */
    @SuppressWarnings("unused")
    Accident saveAccident(Accident accident);

    /**
     * Method to edit.
     *
     * @param accident a accident
     * @return a accident
     */
    @SuppressWarnings("unused")
    Accident editAccident(Accident accident);

    /**
     * Method to delete.
     *
     * @param accident a accident
     * @return a accident
     */
    @SuppressWarnings("unused")
    Accident deleteAccident(Accident accident);

    /**
     * Method to get.
     *
     * @param value a accident
     * @return a accident
     */
    @SuppressWarnings("unused")
    Accident getAccident(Accident value);

    /**
     * Method to get.
     *
     * @return all accident
     */
    List<Accident> getAllAccident();
}
