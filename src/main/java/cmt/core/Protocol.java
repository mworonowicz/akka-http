package cmt.core;

import cmt.lang.Reader;

public interface Protocol<T> {
    <S> S run(Reader<T,S> reader);
}
