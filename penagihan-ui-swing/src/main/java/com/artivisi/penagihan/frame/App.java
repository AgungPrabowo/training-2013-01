package com.artivisi.penagihan.frame;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("classpath*:com/artivisi/**/applicationContext.xml");

        MainFrame mainFrame = ctx.getBean(MainFrame.class);

        if (mainFrame == null) {
            mainFrame = new MainFrame();
        }
        mainFrame.showMainForm();
    }
}