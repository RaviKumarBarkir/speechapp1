package com.personal.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Speech.class)
public class Speech_ {
    public static volatile SingularAttribute<Speech, String> id;
    public static volatile SingularAttribute<Speech, String> body;
    public static volatile SingularAttribute<Speech, String> author;
    public static volatile SingularAttribute<Speech, String> createdDate;
    public static volatile SingularAttribute<Speech, String> subject;
}