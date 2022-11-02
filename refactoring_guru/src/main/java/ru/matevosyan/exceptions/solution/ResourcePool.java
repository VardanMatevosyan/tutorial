package ru.matevosyan.exceptions.solution;

import ru.matevosyan.exceptions.Resource;

import java.util.Stack;

class ResourcePool {
    // ...
    private Stack<Resource> available;
    private Stack<Resource> allocated;

    public Resource getResource() {
        Resource result;
        if (available.empty()) {
            result = new Resource();
        }
        else {
            result = available.pop();
        }
        allocated.push(result);
        return result;
    }
}
