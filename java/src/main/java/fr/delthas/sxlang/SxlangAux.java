package fr.delthas.sxlang;

import jdk.net.Sockets;
import org.antlr.v4.runtime.ListTokenSource;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public final class SxlangAux {
  
  private SxlangAux() {}
  
  @SuppressWarnings("unchecked")
  public static <T> List<T> chain(T start, List<T> list, T end) {
    list.add(0, start);
    list.add(end);
    return list;
  }
  
  @SuppressWarnings("unchecked")
  public static <T,U> U opt(List<T> context) {
    if(context.isEmpty()) return null;
    try {
      Field field = context.get(0).getClass().getField("v");
      return (U)field.get(context.get(0));
    } catch (NoSuchFieldException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }
  
  @SuppressWarnings("unchecked")
  public static <T,U> U optt(List<T> context) {
    if(context.isEmpty()) return null;
    try {
      Method method = context.get(0).getClass().getMethod("getText");
      return (U)method.invoke(context.get(0));
    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }
  
  @SuppressWarnings("unchecked")
  public static <T,U> U or(List<? extends T>... elements) {
    try {
      for (List<? extends T> element : elements) {
        if (element.isEmpty()) { continue; }
        Field field = element.get(0).getClass().getField("v");
        return (U) field.get(element.get(0));
      }
    } catch (NoSuchFieldException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
    return null;
  }
  
  @SuppressWarnings("unchecked")
  public static <T,U> U map(T context) {
    try {
      Field field = context.getClass().getField("v");
      return (U)(field.get(context));
    } catch (NoSuchFieldException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }
  
  @SuppressWarnings("unchecked")
  public static <T,U> List<U> map(List<T> contexts) {
    if(contexts.isEmpty()) return new ArrayList<>(0);
    List<U> list = new ArrayList<>(contexts.size());
    try {
    Field field = contexts.get(0).getClass().getField("v");
      for(T t : contexts) {
        list.add((U)(field.get(t)));
      }
    } catch (NoSuchFieldException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
    return list;
  }
  
  @SuppressWarnings("unchecked")
  public static <T,U> List<U> map(List<? extends T>... contexts) {
    List<U> list = new ArrayList<>(contexts.length);
    try {
      for(List<? extends T> context : contexts) {
        if(context.isEmpty()) continue;
        Field field = context.get(0).getClass().getField("v");
        for(T object : context) {
          list.add((U)(field.get(object)));
        }
      }
    } catch (NoSuchFieldException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
    return list;
  }
  
  @SuppressWarnings("unchecked")
  public static <T,U,V,W> Map<V, W> listsToMap(List<? extends T> keys, List<? extends U> values) {
    if(keys.isEmpty()) return new HashMap<>(0);
    Map<V,W> map = new HashMap<>(keys.size());
    try {
      Field keyField = keys.get(0).getClass().getField("v");
      Field valueField = values.get(0).getClass().getField("v");
      for(int i=0;i<keys.size();++i) {
        map.put((V)keyField.get(keys.get(i)), (W)valueField.get(values.get(i)));
      }
    } catch (NoSuchFieldException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
    return map;
  }
}
