package com.zoo.animal;

import com.zoo.exception.RefuseCompleteException;

public interface Climbable {

    void climb(String subject) throws RefuseCompleteException;
}
