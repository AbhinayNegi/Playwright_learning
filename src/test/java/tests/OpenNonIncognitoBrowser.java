package tests;

import com.microsoft.playwright.*;

import java.nio.file.Paths;
import java.util.ArrayList;

public class OpenNonIncognitoBrowser {

    public static void main(String[] args) {

        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");

        Playwright playwright = Playwright.create();
        BrowserContext browserContext = playwright.chromium().launchPersistentContext(Paths.get(""), new BrowserType.LaunchPersistentContextOptions().setHeadless(false).setArgs(arguments).setViewportSize(null));
//        BrowserContext browserContext = playwright.chromium().launchPersistentContext(Paths.get(""), new BrowserType.LaunchPersistentContextOptions().setHeadless(false).setArgs(arguments).setViewportSize(null).setExecutablePath(Paths.get("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe")));

        Page page = browserContext.pages().get(0); // a tab is already created
        page.navigate("https://www.google.com");

        page.close();
        playwright.close();
    }
}
