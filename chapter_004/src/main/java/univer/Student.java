package univer;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * Student.
 *
 * @author Maxim Vanny.
 * @version 4.0
 * @since 0.1
 */
public class Student implements Comparable<Student> {
    /**
     * FIO student.
     */
    private final String name;
    /**
     * Scope attested.
     */
    private final int scope;

    /**
     * Constructor.
     *
     * @param aName  name
     * @param aScope scope
     */
    public Student(final String aName, final int aScope) {
        this.name = aName;
        this.scope = aScope;
    }

    /**
     * getter name.
     *
     * @return name
     */
    @SuppressWarnings("unused")
    public final String getName() {
        return this.name;
    }

    /**
     * getter scope.
     *
     * @return scope
     */
    public final int getScope() {
        return this.scope;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Student student = (Student) o;
        return this.scope == student.scope
                && Objects.equals(this.name, student.name);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.name, this.scope);
    }

    @Override
    public final String toString() {
        return new StringJoiner(", ",
                Student.class.getSimpleName() + "[", "]")
                .add("name='" + this.name + "'")
                .add("scope=" + this.scope)
                .toString();
    }

    @Override
    public final int compareTo(final Student o) {
        return Integer.compare(this.scope, o.scope);
    }
}
