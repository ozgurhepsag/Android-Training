package com.example.roomdatabaseexample;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

@Dao
public interface UserDAO {

    @Insert
    public void addUser(User user);
}
