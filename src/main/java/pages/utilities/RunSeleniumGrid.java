package pages.utilities;

import java.io.IOException;

public class RunSeleniumGrid {

    public static void run() throws IOException {
        Runtime.
                getRuntime().
                exec("src/main/resources/run_grid.bat");
    }
}