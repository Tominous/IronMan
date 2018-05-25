package com.spigotcodingacademy.ironman.utils.menu;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by IVenomX (BantaGaming)
 */
@RequiredArgsConstructor
public class GuiItem<A, B> {

    @Getter
    private final A a;
    @Getter
    private final B b;

}
