package com.personal.entity;

import java.io.Serializable;

public interface Identifiable <T extends Serializable> {
    Serializable getId();
/*
    T getId();*/
}