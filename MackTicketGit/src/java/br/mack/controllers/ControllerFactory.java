package br.mack.controllers;
public class ControllerFactory {

    public static final Controller getControllerByClass(Class actionClass) {
        try {
            return (Controller) actionClass.newInstance();
        } catch (java.lang.InstantiationException | IllegalAccessException | ClassCastException e) {
        }
        return null;
    }

    public static final Controller getControllerByFullClassName(String className) {
        try {
            String name = "br.mack.controllers.impl." 
                    + className
                    + "Controller";
            Class actionClass = Class.forName(name);
            return getControllerByClass(actionClass);
        } catch (ClassNotFoundException e) {
        }
        return null;
    }
}
