package ru.matevosyan.exceptions.problem;

import ru.matevosyan.exceptions.Resource;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * // todo
 * Problem.
 * Исключения должны использоваться для обработки внештатного поведения, связанного с неожиданной ошибкой.
 * Они не должны служить заменой проверкам выполнения условий. Если исключения можно избежать,
 * просто проверив какое-то условие перед выполнением действия, то стоит так и сделать.
 * Исключения следует приберечь для настоящих ошибок.
 * ------------------------------------------------------------------------------------------
 * Solution.
 * Простой условный оператор иногда может быть очевиднее блока обработки исключения.
 * ------------------------------------------------------------------------------------------
 * Code example is from refactoring guru course but with my changes.
 */
class ResourcePool {
    // ...
    private Stack<Resource> available;
    private Stack<Resource> allocated;

    public Resource getResource() {
        Resource result;
        try {
            result = available.pop();
            allocated.push(result);
            return result;
        } catch (EmptyStackException e) {
            result = new Resource();
            allocated.push(result);
            return result;
        }
    }
}
