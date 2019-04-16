package com.doom.lucifer.chapter1.soundsystem;

import java.util.List;
import java.util.Set;

/**
 * lucifer
 *
 * @author <a href="mailto:zhengguoqiang@58.com">doom</a>
 */
public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;
    private List<String> tracks;
    private Set<String> set;

    public BlankDisc(String title, String artist,List<String> tracks,
                     Set<String> set) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
        this.set = set;
    }

    @Override
    public void play() {
        System.out.println("Playing  " + title + " by " + artist);
        for (String track:tracks){
            System.out.println("-Track:" + track);
        }
        System.out.println(set);
    }
}
