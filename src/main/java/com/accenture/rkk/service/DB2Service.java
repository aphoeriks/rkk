package com.accenture.rkk.service;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.jooq.generated.tables.Projects.PROJECTS;

@Transactional
@Service
public class DB2Service {
    @Autowired
    DB2Service(DSLContext dsl){
        this.create = dsl;
    }
    DSLContext create;

    public void getSql(){
       String sql = create.select().from(PROJECTS).where(PROJECTS.ID.equal(1)).getSQL();
       System.out.println(sql);
    }


}
