package org.app;

import static org.junit.Assert.assertTrue;

import org.app.data_base.DataBase;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        DataBase dataBase = DataBase.getDataBase();
        dataBase.addUser("dda", "dada", "dada");
    }
}
