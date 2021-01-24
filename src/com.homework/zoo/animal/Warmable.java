package com.zoo.animal;

import com.zoo.exception.NegativeTimeException;

public interface Warmable {

    void warm(int minute) throws NegativeTimeException;
}
