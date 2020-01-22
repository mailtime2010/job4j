package carte.tracker;

import carte.models.Item;
import carte.start.StartUI;

import java.util.ArrayList;
import java.util.List;

/**
 * * Carte.
 * MenuTracker.
 *
 * @author Maxim Vanny.
 * @version 2.0
 * @since 0.1
 */
@SuppressWarnings("ALL")
public class MenuTracker {
    /**
     * ADD.
     */
    public static final int ADD = 0;
    /**
     * SHOW.
     */
    public static final int SHOW = 1;
    /**
     * UPDATE.
     */
    public static final int UPD = 2;
    /**
     * DELETE.
     */
    public static final int DEL = 3;
    /**
     * FIND BY ID.
     */
    public static final int FIND_ID = 4;
    /**
     * FIND BY NAME.
     */
    public static final int FIND_BY_NAME = 5;
    /**
     * EXIT.
     */
    public static final int EXIT = 6;
    /**
     * Ссылка на объект ввода.
     */
    private final Input input;
    /**
     * Сылка на объект хранилища.
     */
    private final Tracker tracker;
    /**
     * Сылка на список типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     * @param aInput   объект типа Input
     * @param aTracker объект типа Tracker
     */
    public MenuTracker(final Input aInput, final Tracker aTracker) {
        this.input = aInput;
        this.tracker = aTracker;
    }

    /**
     * Метод для получения размера списка меню.
     *
     * @return размер списка
     */
    public final int getActionsSize() {
        return this.actions.size();
    }

    /**
     * Метод опеределяет количество элементов меню.
     *
     * @param length количество элементов меню.
     * @return установленное количество элементов меню.
     */
    public final int[] fillMenu(final int length) {
        int[] menu = new int[length];
        for (int index = 0; index < this.getActionsSize(); index++) {
            menu[index] = index;
        }
        return menu;
    }

    /**
     * Метод заполняет список.
     *
     * @param ui сылка на основной класс программы.
     */
    public final void fillActions(final StartUI ui) {
        this.actions = List.of(
                new AddItem(ADD, "Add new item"),
                new ShowItems(SHOW, "Show all items"),
                new UpdateItem(UPD, "Edit item"),
                new DeleteItem(DEL, "Delete item"),
                new FindItemById(FIND_ID, "Find item by Id"),
                new FindItemsByName(FIND_BY_NAME, "Find items by name"),
                new ExitProgram(EXIT, "Exit Program", ui));
    }

    /**
     * Метод в зависимости от указанного ключа,
     * выполняет соответствующие действие.
     *
     * @param key ключ операции
     */
    public final void select(final int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public final void show() {
        System.out.println("-----------------------------------------------");
        System.out.println("Carte.");
        System.out.println("-----------------------------------------------");
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Inner class AddItem.
     */
    public class AddItem extends BaseAction {
        /**
         * Constructor.
         *
         * @param aKey  the key of menu.
         * @param aName the name of menu
         */
        public AddItem(final int aKey, final String aName) {
            super(aKey, aName);
        }

        /**
         * Override method adds new Item.
         *
         * @param pInput   объект типа Input.
         * @param pTracker объект типа Tracker.
         */
        @Override
        public final void execute(final Input pInput, final Tracker pTracker) {
            System.out.println("--------- Добавление новой заявки -----------");
            String name = pInput.ask("Введите имя заявки: ");
            String desc = pInput.ask("Введите описание заявки: ");
            Item item = new Item(name, desc);
            if (pTracker.add(item) == null) {
                System.out.println("Заявка не добавлена. Хранилище полное.");
            } else {
                System.out.println("----- Новая заявка ID: " + item.getId());
            }
        }
    }

    /**
     * Inner class ShowItem.
     */
    public class ShowItems extends BaseAction {
        /**
         * Constructor.
         *
         * @param aKey  the key of menu.
         * @param aName the name of menu
         */
        public ShowItems(final int aKey, final String aName) {
            super(aKey, aName);
        }

        /**
         * Override method shows all Items.
         *
         * @param pInput   объект типа Input.
         * @param pTracker объект типа Tracker.
         */
        @Override
        public final void execute(final Input pInput, final Tracker pTracker) {
            System.out.println(tracker.findAll());
        }
    }

    /**
     * Inner class UpdateItem.
     */
    public class UpdateItem extends BaseAction {
        /**
         * Constructor.
         *
         * @param aKey  the key of menu.
         * @param aName the name of menu
         */
        public UpdateItem(final int aKey, final String aName) {
            super(aKey, aName);
        }

        /**
         * Override method updates Item.
         *
         * @param pInput   объект типа Input.
         * @param pTracker объект типа Tracker.
         */
        @Override
        public final void execute(final Input pInput, final Tracker pTracker) {
            String id = pInput.ask("Введите ID обновляемой заявки: ");
            String name = pInput.ask("Введите имя заявки: ");
            String desc = pInput.ask("Введите описание заявки: ");
            if (!pTracker.replace(id, new Item(name, desc))) {
                System.out.println("Заявка ID: " + id + " не обновлена.");
            } else {
                System.out.println("Заявка ID: " + id + " обновлена.");
            }
        }
    }

    /**
     * Inner class DeleteItem.
     */
    public class DeleteItem extends BaseAction {
        /**
         * Constructor.
         *
         * @param aKey  the key of menu.
         * @param aName the name of menu
         */
        public DeleteItem(final int aKey, final String aName) {
            super(aKey, aName);
        }

        /**
         * Override method delete Item.
         *
         * @param pInput   объект типа Input.
         * @param pTracker объект типа Tracker.
         */
        @Override
        public final void execute(final Input pInput, final Tracker pTracker) {
            String id = pInput.ask("Введите ID удаляемой заявки: ");
            if (!pTracker.delete(id)) {
                System.out.println("Заявка не удалена. Уточните ID заявки.");
            } else {
                System.out.println("Заявка " + id + " удалена.");
            }
        }
    }

    /**
     * Inner class FindItemById.
     */
    public class FindItemById extends BaseAction {
        /**
         * Constructor.
         *
         * @param aKey  the key of menu.
         * @param aName the name of menu
         */
        public FindItemById(final int aKey, final String aName) {
            super(aKey, aName);
        }

        /**
         * Override method finds Item by ID.
         *
         * @param pInput   объект типа Input.
         * @param pTracker объект типа Tracker.
         */
        @Override
        public final void execute(final Input pInput, final Tracker pTracker) {
            String id = pInput.ask("Поиск, введите ID заявки: ");
            Item byId = pTracker.findById(id);
            if (byId == null) {
                System.out.println("Заявка не обнаружена. Уточните ID");
            } else {
                System.out.println(byId);
            }
        }
    }

    /**
     * Inner class FindItemByName.
     */
    public class FindItemsByName extends BaseAction {
        /**
         * Constructor.
         *
         * @param aKey  the key of menu.
         * @param aName the name of menu
         */
        public FindItemsByName(final int aKey, final String aName) {
            super(aKey, aName);
        }

        /**
         * Override method find Item by name.
         *
         * @param pInput   объект типа Input.
         * @param pTracker объект типа Tracker.
         */
        @Override
        public final void execute(final Input pInput, final Tracker pTracker) {
            String name = pInput.ask("Поиск, введите название заявки:");
            List<Item> byNames = pTracker.findByName(name);
            if (byNames.size() == 0) {
                System.out.println("Заявка не обнаружена. Уточните название.");
            } else {
                System.out.println(byNames);
            }
        }
    }

    /**
     * Inner class ExitProgram.
     */
    public class ExitProgram extends BaseAction {
        /**
         * link on StartUI.
         */
        private final StartUI ui;

        /**
         * Constructor.
         *
         * @param aKey  the key of menu.
         * @param aName the name of menu.
         * @param aUi   the link to StartUI.
         */
        public ExitProgram(final int aKey, final String aName,
                           final StartUI aUi) {
            super(aKey, aName);
            this.ui = aUi;
        }

        /**
         * Override method to close program.
         *
         * @param pInput   объект типа Input.
         * @param pTracker объект типа Tracker.
         */
        @Override
        public final void execute(final Input pInput, final Tracker pTracker) {
            this.ui.stop();
        }

    }
}
