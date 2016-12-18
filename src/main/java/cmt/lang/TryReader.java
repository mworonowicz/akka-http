package cmt.lang;

import javaslang.Function1;
import javaslang.control.Try;

public class TryReader<R, A> {
    private final Function1<R, Try<A>> run;
    public TryReader(Function1<R, Try<A>> run) { this.run = run; }

    public <B> TryReader<R, B> map(Function1<A, B> f) {
        return new TryReader<>(r -> apply(r).map(f::apply));
    }

    public <B> TryReader<R, B> flatMap(Function1<A, TryReader<R, B>> f) {
        return new TryReader<>(r -> apply(r).flatMap(a -> f.apply(a).apply(r)));
    }

    public <B> TryReader<R, B> mapReader(Function1<A, Reader<R, B>> f) {
        return new TryReader<>(r -> apply(r).map( a -> f.apply(a).apply(r) ) );
    }

    public Try<A> apply(R r) { return run.apply(r); }
}