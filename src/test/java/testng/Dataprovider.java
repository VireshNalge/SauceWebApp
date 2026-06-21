package testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider {

    @Test(dataProvider = "details")
    public void login(String un, String pwd) {
        System.out.println(un + " --- " + pwd);
    }

    @DataProvider
    public Object[][] details() {
        Object[][] objarr = new Object[2][2];

        objarr[0][0] = "Dhoni";
        objarr[0][1] = "Dhoni7";

        objarr[1][0] = "Virat";
        objarr[1][1] = "Virat18";

        return objarr;
    }
}