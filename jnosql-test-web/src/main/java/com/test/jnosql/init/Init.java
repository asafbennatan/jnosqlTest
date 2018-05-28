package com.test.jnosql.init;


import com.test.jnosql.data.JNoSQLRepository;
import com.test.jnosql.model.Test;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.jnosql.artemis.Database;
import org.jnosql.artemis.DatabaseType;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.UUID;

@WebListener
@Named
public class Init implements ServletContextListener {


    @Inject
    @Database(DatabaseType.DOCUMENT)
    private JNoSQLRepository JNoSQLRepository;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        testNoSQL();

    }

    private void testNoSQL() {
        Test test=new Test();
        test.setId(getBase64ID());
        test.setDummy("test");
        JNoSQLRepository.save(test);

    }

    public static String getBase64ID() {
        String result;
        try {
            result = new String(Base64.encodeBase64(Hex.decodeHex(UUID.randomUUID().toString().replaceAll("-", "")
                    .toCharArray())));
            result = result.replace("/", "-"); // we cannot afford a slash
            result =result.substring(0,22); //we don't need the trailing ==

        } catch (DecoderException e) {
            result = "errorinid";
        }

        return result;
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
