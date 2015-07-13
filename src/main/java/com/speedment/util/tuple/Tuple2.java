/**
 *
 * Copyright (c) 2006-2015, Speedment, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); You may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.speedment.util.tuple;

import java.util.Objects;

/**
 *
 * @author pemi
 * @param <T0>
 * @param <T1>
 */
public class Tuple2<T0, T1> extends BasicTuple<Tuple2<T0, T1>> {

    public Tuple2() {
        super(Tuple2.class, 2);
    }

    public Tuple2(T0 v0, T1 v1) {
        super(Tuple2.class,
            Objects.requireNonNull(v0),
            Objects.requireNonNull(v1)
        );
    }

    @SuppressWarnings("unchecked")
    public T0 get0() {
        return (T0) values[0];
    }

    @SuppressWarnings("unchecked")
    public T1 get1() {
        return (T1) values[1];
    }

    public Tuple2<T0, T1> set0(T0 v0) {
        values[0] = Objects.requireNonNull(v0);
        return this;
    }

    public Tuple2<T0, T1> set1(T1 v1) {
        values[1] = Objects.requireNonNull(v1);
        return this;
    }

}
