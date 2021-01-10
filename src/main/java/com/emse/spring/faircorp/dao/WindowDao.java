package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WindowDao extends JpaRepository<Window, Long> , WindowDaoCustom {



    @Query("select  c from Window c where c.name= :name")
    List< Window > findByName(@Param("name") String name);



    @Modifying
    @Query("delete from Window c where c.name = ?1")
    void deleteByName(String name);

//    @Modifying // (3)
//    @Query("delete id from Window r where r.id=-8")
//    void deleteBySiteId (long id);
}
