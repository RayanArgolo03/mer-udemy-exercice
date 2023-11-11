package repository;

import java.util.*;
import java.util.function.Predicate;

public interface Repository<T> {
    Optional<T> findBy(Predicate<T> predicate);
}
