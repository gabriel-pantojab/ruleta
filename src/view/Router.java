package view;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class Router {
    private static Router router;
    private final Map<String, Class<?>> routes;
    private String currentRoute;
    private RouletteGame mainFrame;
    private Map<String, String> params;
    private Router() {
        routes = new HashMap<String, Class<?>>() {};
        currentRoute = "";
        params = new HashMap<String, String>();
    }

    public void addRoute(String route, Class<?> component) {
        routes.put(route, component);
    }

    public void addParams(String name, String value) {
        params.put(name, value);
    }

    public String getParam(String nameParam) {
        return params.get(nameParam);
    }
    public Component getComponent(String route) {
        Class<?> clasz = routes.get(route);
        try {
            return (Component) clasz.getConstructor().newInstance();
        }catch (Exception e) {

        }
        return null;
    }

    public void navigate(String route) {
        this.currentRoute = route;
        this.mainFrame.updateUI();
    }

    public void navigate(String route, String nameParam, String value) {
        params.put(nameParam, value);
        this.currentRoute = route;
        this.mainFrame.updateUI();
    }

    public String getCurrentRoute() {
        return currentRoute;
    }

    public Map<String, Class<?>> getRouter() {
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

    public static Router getInstance() {
        if(router == null) {
            router = new Router();
        }
        return router;
    }
}
