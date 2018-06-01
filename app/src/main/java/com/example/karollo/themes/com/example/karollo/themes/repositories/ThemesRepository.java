package com.example.karollo.themes.com.example.karollo.themes.repositories;

import com.example.karollo.themes.com.example.karollo.themes.entity.Theme;

public class ThemesRepository {
    public void setTheme(Theme theme){
        theme.save();
    }
}
