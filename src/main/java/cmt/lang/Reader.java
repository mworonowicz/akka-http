package cmt.lang;

import javaslang.Function1;

public class Reader<R, A> {
    private final Function1<R, A> run;

    public Reader(Function1<R, A> run) { this.run = run; }

    public <B> Reader<R, B> map(Function1<A, B> f) {
        return new Reader<>( r -> f.apply((apply(r))) );
    }

    public <B> Reader<R, B> flatMap(Function1<A, Reader<R, B>> f) {
        return new Reader<>( r -> f.apply(apply(r)).apply(r) );
    }

    public A apply(R r) {
        return run.apply(r);
    }
}