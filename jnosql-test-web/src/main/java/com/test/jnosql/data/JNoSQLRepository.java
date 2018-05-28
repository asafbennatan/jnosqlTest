package com.test.jnosql.data;


import com.test.jnosql.model.Test;
import org.jnosql.artemis.Repository;

import java.util.List;


/**
 * Created by Asaf on 01/12/2016.
 */
public interface JNoSQLRepository extends Repository<Test, String> {

    List<Test> findByDummy(String dummy);


}
