package com.zzh.dao;



import com.zzh.bean.UserEntity;

public interface UserEntityDAO {
  boolean login(UserEntity ue);
  boolean register(UserEntity ue);
  boolean addinfo(UserEntity ue);
  boolean updatename(UserEntity ue);
  boolean finduser(UserEntity ue);
  boolean regcheck(UserEntity ue);
  boolean findadmin(UserEntity ue);
  int findid(UserEntity ue);
}
