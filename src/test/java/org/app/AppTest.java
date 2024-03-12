package org.app;

import static org.junit.Assert.assertTrue;

import org.app.data_base.DataBase;
import org.junit.Test;

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
        dataBase.deleteUser("admin");
        dataBase.addUser("admin", "admin", "admin");
    }
}
