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
package com.speedment.internal.core.manager.sql.generator;

import com.speedment.internal.codegen.base.Generator;
import com.speedment.internal.codegen.base.Transform;
import com.speedment.field.operators.StandardUnaryOperator;
import static com.speedment.field.operators.StandardUnaryOperator.IS_NOT_NULL;
import static com.speedment.field.operators.StandardUnaryOperator.IS_NULL;
import com.speedment.field.builders.UnaryPredicateBuilder;
import com.speedment.field.operators.UnaryOperator;
import static java.util.Objects.requireNonNull;

import java.util.Optional;

/**
 *
 * @author Emil Forslund
 */
@SuppressWarnings("rawtypes")
public final class UnaryPredicateBuilderView implements Transform<UnaryPredicateBuilder, String> {

    private String render(StandardUnaryOperator op) {
        requireNonNull(op);
        switch (op) {
            case IS_NOT_NULL:
                return " <> NULL";
            case IS_NULL:
                return " == NULL";
            default:
                throw new UnsupportedOperationException(
                    "Unknown enum constant " + op.name() + "."
                );
        }
    }

    @Override
    public Optional<String> transform(Generator gen, UnaryPredicateBuilder model) {
        requireNonNull(gen);
        requireNonNull(model);
        final UnaryOperator uo = model.getUnaryOperator();
        if (uo instanceof StandardUnaryOperator) {

            @SuppressWarnings("unchecked")
            final StandardUnaryOperator suo = (StandardUnaryOperator) uo;

            return Optional.of("("
                + model.getField().getColumnName()
                + render(suo)
                + ")"
            );

        } else {
            return Optional.empty();
        }
    }
}
