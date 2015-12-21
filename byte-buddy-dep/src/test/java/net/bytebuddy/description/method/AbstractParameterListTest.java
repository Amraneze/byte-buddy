package net.bytebuddy.description.method;

import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.generic.GenericTypeDescription;
import net.bytebuddy.matcher.AbstractFilterableListTest;
import org.junit.Test;

import java.util.Collections;

import static net.bytebuddy.matcher.ElementMatchers.none;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public abstract class AbstractParameterListTest<U extends ParameterDescription, V> extends AbstractFilterableListTest<U, ParameterList<U>, V> {

    @Test
    @SuppressWarnings("unchecked")
    public void testTokenWithoutMatcher() throws Exception {
        assertThat(asList(Collections.singletonList(getFirst())).asTokenList().size(), is(1));
        assertThat(asList(Collections.singletonList(getFirst())).asTokenList().getOnly().getType(), is(TypeDefinition.Sort.describe(Void.class)));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testTokenWithMatcher() throws Exception {
        assertThat(asList(Collections.singletonList(getFirst())).asTokenList(none()).size(), is(1));
        assertThat(asList(Collections.singletonList(getFirst())).asTokenList(none()).getOnly().getType(), is(TypeDefinition.Sort.describe(Void.class)));
    }

    @Test
    public void testTypeList() throws Exception {
        assertThat(asList(Collections.singletonList(getFirst())).asTypeList(), is(Collections.singletonList(asElement(getFirst()).getType())));
    }

    @Test
    public void testDeclared() throws Exception {
        assertThat(asList(Collections.singletonList(getFirst())).asDefined(), is(Collections.singletonList(asElement(getFirst()).asDefined())));
    }

    protected static class Foo {

        public void foo(Void v) {
            /* empty */
        }

        public void bar(Void v) {
            /* empty */
        }
    }

}
