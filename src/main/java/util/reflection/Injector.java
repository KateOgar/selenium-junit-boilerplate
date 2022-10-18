package util.reflection;

import annotations.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import util.NoSuchBrowserExeption;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Injector {

    public static void inject(Object target, WebDriver driver) throws NoSuchBrowserExeption {
        Field[] allFields = target.getClass().getDeclaredFields();

        for (Field f : allFields) {
            Object subject = SubjectProvider.provideSubject(f);
            if (subject != null) {
                try {
                    f.setAccessible(true);
                    f.set(target, subject);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                inject(subject, driver);
                for (Annotation a : f.getAnnotations()) {
                    if (Page.class.equals(a.annotationType())) {
                        PageFactory.initElements(driver, subject);
                    }
                }
            }
        }
    }
}
