package app.web.orders.domain.element.element;

public class ElementData {
    public static final String BASIC_TABLE_NAME = "elements";
    public static final String ASSOCIATED_ELEMENTS_TABLE = "associated_elements";

    public static class Info {
        public static final int NAME_MIN_LENGTH = 3;
        public static final int NAME_MAX_LENGTH = 100;
        public static final int DESCRIPTION_MIN_LENGTH = 0;
        public static final int DESCRIPTION_MAX_LENGTH = 300;
        public static final int URL_MIN_LENGTH = 5;
        public static final int URL_MAX_LENGTH = 300;
        public static final int SERIAL_NUMBER_MIN_LENGTH = 3;
        public static final int SERIAL_NUMBER_MAX_LENGTH = 300;
        static final String NAME = "nazwa";
        static final String DESCRIPTION = "opis";
        static final String URL = "URL";
        static final String SERIAL_NUMBER = "Numer seryjny";
    }

    public static class Category {
        public static final int CATEGORY_MIN_LENGTH = 3;
        public static final int CATEGORY_MAX_LENGTH = 50;
        static final String CATEGORY = "kategoria";
    }

    public static class Provider {
        static final String PROVIDER = "dostawca";
        static final int PROVIDER_MIN_LENGTH = 3;
        static final int PROVIDER_MAX_LENGTH = 50;
    }

    public static class Producer {
        static final String PRODUCER = "producent";
        static final int PRODUCER_MIN_LENGTH = 3;
        static final int PRODUCER_MAX_LENGTH = 50;
    }

}
