package org.rxbooter.flow;

import static org.rxbooter.flow.Tuples.*;

public class Flux {
    public static<O1, I1> FluxBuilder1<Tuple1<O1>, I1> take(Class<I1> input) {
        return new FluxBuilder1<>(null);
    }

    protected static class FluxBuilder<O> {
        public FluxBuilder(FluxBuilder<O> parent) {}
    }

    public static class FluxBuilder1<O, I1> extends FluxBuilder<O> {
        public FluxBuilder1(FluxBuilder<O> parent) { super(parent);}

        public <R1> FluxBuilder1<O, R1> apply1(FN11<I1, R1> function) {
            return new FluxBuilder1<>(this);
        }

        public <R1, R2> FluxBuilder2<O, R1, R2> apply2(FN12<I1, R1, R2> function) {
            return new FluxBuilder2<>(this);
        }

        public <R1, R2, R3> FluxBuilder3<O, R1, R2, R3> apply3(FN13<I1, R1, R2, R3> function) {
            return new FluxBuilder3<>(this);
        }
    }

    public static class FluxBuilder2<O, I1, I2> extends FluxBuilder1<O, I1> {
        public FluxBuilder2(FluxBuilder<O> parent) { super(parent);}

        public <R1> FluxBuilder1<O, R1> apply1(FN21<I1, I2, R1> function) {
            return new FluxBuilder1<>(this);
        }

        public <R1, R2> FluxBuilder2<O, R1, R2> apply2(FN22<I1, I2, R1, R2> function) {
            return new FluxBuilder2<>(this);
        }

        public <R1, R2, R3> FluxBuilder3<O, R1, R2, R3> apply3(FN23<I1, I2, R1, R2, R3> function) {
            return new FluxBuilder3<>(this);
        }
    }

    public static class FluxBuilder3<O, I1, I2, I3> extends FluxBuilder2<O, I1, I2> {
        public FluxBuilder3(FluxBuilder<O> parent) { super(parent);}

        public <R1> FluxBuilder1<O, R1> apply1(FN31<I1, I2, I3, R1> function) {
            return new FluxBuilder1<>(this);
        }

        public <R1, R2> FluxBuilder2<O, R1, R2> apply2(FN32<I1, I2, I3, R1, R2> function) {
            return new FluxBuilder2<>(this);
        }

        public <R1, R2, R3> FluxBuilder3<O, R1, R2, R3> apply3(FN33<I1, I2, I3, R1, R2, R3> function) {
            return new FluxBuilder3<>(this);
        }
    }

    public interface FN10<I, O> { O apply(I input); }
    public interface FN11<I1, O1> extends FN10<I1, Tuple1<O1>> {}
    public interface FN12<I1, O1, O2> extends FN10<I1, Tuple2<O1, O2>> {}
    public interface FN13<I1, O1, O2, O3> extends FN10<I1, Tuple3<O1, O2, O3>> {}

    public interface FN20<I1, I2, O> { O apply(I1 input1, I2 input2); }
    public interface FN21<I1, I2, O1> extends FN20<I1, I2, Tuple1<O1>> {}
    public interface FN22<I1, I2, O1, O2> extends FN20<I1, I2, Tuple2<O1, O2>> {}
    public interface FN23<I1, I2, O1, O2, O3> extends FN20<I1, I2, Tuple3<O1, O2, O3>> {}

    public interface FN30<I1, I2, I3, O> { O apply(I1 input1, I2 input2, I3 input3); }
    public interface FN31<I1, I2, I3, O1> extends FN30<I1, I2, I3, Tuple1<O1>> {}
    public interface FN32<I1, I2, I3, O1, O2> extends FN30<I1, I2, I3, Tuple2<O1, O2>> {}
    public interface FN33<I1, I2, I3, O1, O2, O3> extends FN30<I1, I2, I3, Tuple3<O1, O2, O3>> {}
}
