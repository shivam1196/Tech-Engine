package com.shivam.users.socialmedia;

import java.lang.reflect.Field;

public class TestUtils {

  public static void injectObjects(Object target, String targetName,Object injectTo){
    boolean wasPrivate = false;
    try {
      Field field = target.getClass().getDeclaredField(targetName);
      if(!field.isAccessible()){
        field.setAccessible(true);
        wasPrivate = true;
      }
      field.set(target,injectTo);
      if(wasPrivate){
        field.setAccessible(false);
      }

    }catch (NoSuchFieldException e){
      throw  new RuntimeException("No such field Exception",e);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
  }

}
