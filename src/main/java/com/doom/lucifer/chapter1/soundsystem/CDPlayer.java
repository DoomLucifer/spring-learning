package com.doom.lucifer.chapter1.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Autowired注解
 *
 * @author <a href="mailto:zhengguoqiang@58.com">doom</a>
 */
@Component
public class CDPlayer {

    private CompactDisc cd;

    private CompactDisc compactDisc;

    public CDPlayer() {
    }

    //Autowired注解不仅能用在构造器上，还能用在setter方法上
    @Autowired
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

//    @Autowired
//    public void setCd(CompactDisc cd) {
//        this.cd = cd;
//    }

    //@Autowired注解可以用在类的任何方法上
//    @Autowired
//    public void insertCompactDisc(CompactDisc cd) {
//        this.cd = cd;
//    }

    @Autowired
    public void  setCompactDisc(CompactDisc compactDisc,CompactDisc cd){
        this.compactDisc = compactDisc;
        this.cd = cd;
    }

    public void setCd(CompactDisc cd) {
        this.cd = cd;
    }

    public void setCompactDisc(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    public void play(){
        cd.play();
        compactDisc.play();
    }
}
