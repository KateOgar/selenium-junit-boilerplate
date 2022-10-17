package util.reflection;

import annotations.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Injector {

    public static void inject(Object target, WebDriver driver) {
        Field[] allFields = target.getClass().getDeclaredFields();
        Object subject;

        for (Field f : allFields) {
            subject = SubjectProvider.provideSubject(f);
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
