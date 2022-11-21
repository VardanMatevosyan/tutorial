package ru.matevosyan.inheritance.subclus_extraction.problem;

/**
 * // todo
 * Чек-лист проведения рефакторинга
 * 1. Создайте новый подкласс из интересующего вас класса.
 * 2. Если для создания объектов из подкласса будут нужны какие-то дополнительные данные, создайте конструктор и дополните его нужными параметрами. Не забудьте вызвать родительскую реализацию конструктора.
 * 3. Найдите все вызовы конструктора родительского класса. В тех случаях, когда требуется функциональность подкласса, замените родительский конструктор конструктором подкласса.
 * 4. Переместите нужные методы и поля из родительского класса в подкласс. Используйте для этого спуск метода и спуск поля. Проще всего начинать перенос с методов. Так поля будут доступны для них все время: из родительского класса до переноса, и из самого подкласса после окончания переноса.
 * 5. После того как подкласс готов, найдите все старые поля, которые управляли тем, какой набор функций должен выполняться.
 * Эти поля можно удалить, заменив полиморфизмом все условные операторы, в которых они использовались.
 * Простой пример — у вас в классе Автомобиль было поле isElectricCar, и в зависимости от него, в методе refuel() в машину либо заливается бензин,
 * либо заряжается электричество. В результате рефакторинга, поле isElectricCar будет удалено,
 * а классы Автомобиль и ЭлектроАвтомобиль будут иметь свои реализации метода refuel().
 * // todo
 * Problem.
 * ------------------------------------------------------------------------------------------
 * Solution.
 * ------------------------------------------------------------------------------------------
 * Code example is from refactoring guru course but with my changes.
 */
class JobItem {
    private int quantity;
    private int unitPrice;
    private Employee employee;
    private boolean isLabor;

    JobItem(int quantity, int unitPrice, boolean isLabor, Employee employee) {
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.isLabor = isLabor;
        this.employee = employee;
    }
    public int getTotalPrice() {
        return quantity * getUnitPrice();
    }
    public int getQuantity() {
        return quantity;
    }
    public int getUnitPrice() {
        return (isLabor) ? employee.getRate() : unitPrice;
    }
    public Employee getEmployee() {
        return employee;
    }
}
