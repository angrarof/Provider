package settings;

public class WaitingTimeSetup {

    private WaitingTimeSetup(){
        super();
    }

    private static final int WAIT_FOR_WEB_ELEMENT = 40;
    private static final int WAIT_FOR_PAGE_LOAD = 60;
    private static final int WAIT_IMPLICITLY = 10;
    private static final int WAIT_FOR_AJAX_ELEMENT = 5;

    public static int getTimeForWebElement() {
        return WAIT_FOR_WEB_ELEMENT;
    }

    public static int getTimeForPageLoad() {
        return WAIT_FOR_PAGE_LOAD;
    }

    public static int getTimeToImplicitlyWait() {
        return WAIT_IMPLICITLY;
    }

    public static int getTimeForAjaxElement() {
        return WAIT_FOR_AJAX_ELEMENT;
    }
}
