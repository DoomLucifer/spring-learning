package com.doom.lucifer;

import com.doom.lucifer.chapter1.config.CDPlayerConfig;
import com.doom.lucifer.chapter1.soundsystem.CDPlayer;
import com.doom.lucifer.chapter1.soundsystem.CompactDisc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * lucifer
 *
 * @author <a href="mailto:zhengguoqiang@58.com">doom</a>
 */
//SpringJUnit4ClassRunner测试开始的时候自动创建应用上下文
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

    @Autowired
    private CompactDisc cd;

    @Autowired
    private CDPlayer player;

    @Test
    public void cdShouldNotBeNull(){
        assertNotNull(cd);
    }

    @Test
    public void play(){
        cd.play();
        player.play();
    }
}
