package com.artivisi.penagihan.client.local;

import javax.swing.JFrame;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AplikasiPenagihan {
    public static void main(String[] args) {
        ApplicationContext ctx = 
                new ClassPathXmlApplicationContext("classpath*:com/artivisi/**/applicationContext.xml");
        
        FrameCekOutstanding fr = ctx.getBean(FrameCekOutstanding.class);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }
}
