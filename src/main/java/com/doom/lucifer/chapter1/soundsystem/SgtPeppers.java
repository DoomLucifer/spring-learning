package com.doom.lucifer.chapter1.soundsystem;

import org.springframework.stereotype.Component;

/**
 * lucifer
 *
 * @author <a href="mailto:zhengguoqiang@58.com">doom</a>
 */
@Component
public class SgtPeppers implements CompactDisc {

    @Override
    public void play() {
        String title = "Sgt. Pepper's Lonely Hearts Club Band";
        String artist = "The Beatles";
        System.out.println("Playing  " + title + " by " + artist);
    }
}
