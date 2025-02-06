package tests;

import com.microsoft.playwright.*;

import java.util.ArrayList;

public class OpenDifferentBrowsers {

    public static void main(String[] args) {

        openBrowser("chrome");
    }

    public static void openBrowser(String browserName) {
        if(browserName == null || browserName.isEmpty()) {
            throw new IllegalArgumentException("Please provide a browser name");
        }

        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");

        Playwright playwright = Playwright.create();
        Browser browser;

        if(browserName.equalsIgnoreCase("Chrome")) {
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
            Page page = context.newPage();

            page.navigate("https://www.google.com");

            System.out.print(page.title());

            page.close();
            playwright.close();
        }else if(browserName.equalsIgnoreCase("Edge")) {
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false).setArgs(arguments));
            Page page = browser.newContext(new Browser.NewContextOptions().setViewportSize(null)).newPage();

            page.navigate("https://www.google.com");

            System.out.print(page.title());

            page.close();
            playwright.close();
        }else if(browserName.equalsIgnoreCase("Firefox")) {
            browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));
            Page page = browser.newContext(new Browser.NewContextOptions().setViewportSize(null)).newPage();

            page.navigate("https://www.google.com");

            System.out.print(page.title());

            page.close();
            playwright.close();
        }
    }
}
