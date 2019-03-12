package com.example.roomdatabaseexample;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert
    public void addUser(User user);

    @Query("select * from user")
    public List<User> readUsers();

    @Delete
    public void deleteUser(User user);
}
