/**
 * Copyright 2017 The Java2TypeScript Authors.  All rights reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package java2typescript.translators;

import com.intellij.psi.PsiCodeBlock;
import com.intellij.psi.PsiStatement;
import java2typescript.context.TranslationContext;
import java2typescript.translators.statement.StatementTranslator;

public class CodeBlockTranslator {

    public static void translate(PsiCodeBlock block, TranslationContext ctx) {
        ctx.append("{\n");
        ctx.increaseIdent();
        for (PsiStatement statement : block.getStatements()) {
            StatementTranslator.translate(statement, ctx);
        }
        ctx.decreaseIdent();
        ctx.print("}");
    }

}
