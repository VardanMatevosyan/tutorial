// Java Supplier<String> in JS
function helloSupplier() {
    return () => 'Hello';
}
console.log('helloSupplier = ' + helloSupplier()()); console.log();


// Java Predicate<String> in JS
function isEmptyPredicate() {
    return str => str !== null && str.length === 0;
}
console.log('isEmptyPredicate empty =' + isEmptyPredicate()(''));
console.log('isEmptyPredicate not empty =' +isEmptyPredicate()('str')); console.log();


// Java BiFunction<String, Integer, String> in JS
function stringMultiplier() {
    return (str, times) => {
        let temp = str;
        for(let i = 1; i < times; i++) {
            str = str + temp;
        }
        return str;
    };
}
console.log('stringMultiplier = ' + stringMultiplier()('Hi', 3)); console.log();


// Java Function<BigDecimal, String> in JS
function toDollarStringFunction() {
    return n => "$" + n;
}
console.log('toDollarStringFunction = ' + toDollarStringFunction()(1234.1234)); console.log();


// Java  Predicate<String> in JS
function lengthInRangePredicate(min, max) {
    return str => str.length >= min && str.length <= max;
}
console.log('lengthInRangePredicate less then min = ' + lengthInRangePredicate(4, 9)("123"));
console.log('lengthInRangePredicate between = ' + lengthInRangePredicate(4, 9)("1234"));
console.log('lengthInRangePredicate greater then max = ' + lengthInRangePredicate(4, 9)("0123456789")); console.log();


// Java IntSupplier in JS
function randomIntSupplier() {
    return () => Math.random();
}
console.log('randomIntSupplier = ' + randomIntSupplier()()); console.log();


//Java IntUnaryOperator in JS
function boundedRandomIntSupplier() {
    return n => Math.floor(Math.random() * n)
}
console.log('boundedRandomIntSupplier = ' + boundedRandomIntSupplier()(22)); console.log();


// Java IntUnaryOperator in JS
function intSquareOperation() {
    return x => x * x;
}
console.log('intSquareOperation 3 = ' + intSquareOperation()(3)); console.log();


// Java LongBinaryOperator in JS
function longSumOperation() {
    return (a, b) => a + b;
}
console.log('longSumOperation 3 + 4 = ' + longSumOperation()(3, 4));console.log();


// Java ToIntFunction<String>  in JS
function stringToIntConverter() {
    return str => Number(str);
}
let result = stringToIntConverter()('4');
console.log('stringToIntConverter 4 = ' + result); console.log();
console.log('stringToIntConverter should be type of number = ' + typeof result); console.log();


// Java Supplier<IntUnaryOperator> in JS
function nMultiplyFunctionSupplier(n) {
    return () => x => n * x;
}
console.log('nMultiplyFunctionSupplier n is 5, x is 5 n*x should be 25  = ' + nMultiplyFunctionSupplier(5)()(5)); console.log();


// Java UnaryOperator<Function<String, String>> in JS
function composeWithTrimFunction() {
    return func => str => func(str.trim());
}
console.log('composeWithTrimFunction = ' + composeWithTrimFunction()(str => str.toUpperCase())('hey')); console.log();


// Java Supplier<Thread> in JS
class Thread {
    constructor(runnable) {
        this.runnable = runnable;
    }
    start() {
        this.runnable();
    }
}
let cars = ["Saab", "Volvo"];
function runningThreadSupplier(runnable) {
    return () => {
        let thread = new Thread(runnable);
        thread.start();
        return thread;
    };
}

runningThreadSupplier(() => cars[2] = 'BMW')();
console.log('runningThreadSupplier should be BMW = ' + cars[2]); console.log();


// Java Consumer<Runnable> in JS
function newThreadRunnableConsumer() {
    return r => new Thread(r).start();
}
newThreadRunnableConsumer()(() => cars[2] = 'Mercedes');
console.log('runningThreadSupplier should be Mercedes = ' + cars[2]); console.log();


// Java Function<Runnable, Supplier<Thread>>  in JS
function runnableToThreadSupplierFunction() {
    return runnable => () => {
        let thread = new Thread(runnable);
        thread.start();
        return thread;
    };
}
runnableToThreadSupplierFunction()(() => cars[2] = 'Toyota')();
console.log('runnableToThreadSupplierFunction should be BMW = ' + cars[2]); console.log();


// Java BiFunction<IntUnaryOperator, IntPredicate, IntUnaryOperator>  in JS
function functionToConditionalFunction() {
    return (intFunction, predicate) => x => predicate(x) ? intFunction(x) : x;
}
let functionToConditionalResult = functionToConditionalFunction()(a => -a, a => a < 0)(-5);
console.log('functionToConditionalFunction should be 5 = ' + functionToConditionalResult); console.log();

// Java BiFunction<Map<String, IntUnaryOperator>, String, IntUnaryOperator>  in JS
let map = new Map();
map.set('increment', x => x + 1);
map.set('square', x => x * x);

function functionLoader() {
    return (map, key) => map.get(key) != null ? x => map.get(key)(x) : x => x;
}
let functionLoaderResult = functionLoader()(map, 'square')(4);
console.log('functionLoader expected 16 = ' + functionLoaderResult); console.log();


// Java Supplier<Supplier<Supplier<String>>> in JS
function trickyWellDoneSupplier() {
    return () => () => () => 'WELL DONE!'
}
console.log(trickyWellDoneSupplier()()()())

