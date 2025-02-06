package tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.awt.*;
import java.util.ArrayList;

public class OpenBrowser {

    public static void main(String[] args) {

        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));
        Page page = browser.newContext(new Browser.NewContextOptions().setViewportSize(null)).newPage();

        page.navigate("https://www.google.com");
        System.out.println(page.title());
        page.close();
        playwright.close();
    }

}
