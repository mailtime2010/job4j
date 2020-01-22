package carte.tracker;

/**
 * * Carte.
 * UserAction.
 *
 * @author Maxim Vanny.
 * @version 2.0
 * @since 0.1
 */
public interface UserAction {
    /**
     * Метод возвращает ключ опции.
     *
     * @return ключ
     */
    @SuppressWarnings("unused")
    int key();

    /**
     * Основной метод.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    void execute(Input input, Tracker tracker);

    /**
     * Метод возвращает информацию о данном пункте меню.
     *
     * @return Строка меню
     */
    String info();
}
