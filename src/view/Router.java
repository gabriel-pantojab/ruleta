package view;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Router {
    private static Router router;
    private final Map<String, Component> routes;
    private String currentRoute;
    private RouletteGame mainFrame;
    private Router() {
        routes = new HashMap<String, Component>() {};
        currentRoute = "";
    }

    public void addRoute(String route, Component component) {
        routes.put(route, component);
    }

    public Component getComponent(String route) {
        return routes.get(route);
    }

    public void setCurrentRoute(String route) {
        this.currentRoute = route;
        this.mainFrame.updateUI();
    }

    public String getCurrentRoute() {
        return currentRoute;
    }

    public Map<String, Component> getRouter() {
        return routes;
    }

    public void setMainFrame(RouletteGame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public static Router getInstance(RouletteGame mainFrame) {
        if(router == null) {
            router = new Router();
            router.setMainFrame(mainFrame);
        }
        return router;
    }
}
