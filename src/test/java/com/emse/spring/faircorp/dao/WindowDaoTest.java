package com.emse.spring.faircorp.dao;
import com.emse.spring.faircorp.model.Window;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest

public class WindowDaoTest {




        @Autowired
        private WindowDao windowDao;

//        @Test
//        public void shouldFindAWindow() {
//            Window window = windowDao.getOne(-10L);
//            Assertions.assertThat(window.getName()).isEqualTo("Window 1");
//           Assertions.assertThat(window.getWindow_status()).isEqualTo(WindowStatus.CLOSED);
//        }



    
 @Test
  public void shouldFindAWindowbyname() {
      List< Window> window = windowDao.findByName("Window 2");
       Assertions.assertThat(window.size()).isEqualTo(2);

    }

//    @Test
//    public void shouldFindRoomOpenWindows() {
//        List<Window> result = windowDao.findRoomOpenWindows(-9L);
//        Assertions.assertThat(result)
//                .hasSize(1)
//                .extracting("id", "windowStatus")
//                .containsExactly(Tuple.tuple(-8L, WindowStatus.OPEN));
//    }
//
//    @Test
//    public void shouldNotFindRoomOpenWindows() {
//        List<Window> result = windowDao.findRoomOpenWindows(-10L);
//        Assertions.assertThat(result).isEmpty();
//    }
    }

