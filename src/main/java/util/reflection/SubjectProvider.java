package util.reflection;

import annotations.Driver;
import annotations.Page;
import annotations.Steps;
import browser.drivers.DriverStore;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class SubjectProvider {
    public static Object provideSubject(Field f) {
        Object subject = null;

        if (f.isAnnotationPresent(Page.class) || f.isAnnotationPresent(Steps.class)) {
            try {
                subject = f.getType().getDeclaredConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }

        if (f.isAnnotationPresent(Driver.class)) {
            subject = DriverStore.getDriver();
        }
        return subject;
    }
}
