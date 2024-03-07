package proxy;

import com.sun.jdi.connect.Connector;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MathProxy {
    public static Function<Integer, Integer> absInt = Math::abs;

    public static BiFunction<Integer, Integer, Integer> maxInt = Math::max;
    public static BiFunction<Integer, Integer, Integer> minInt = Math::min;

    public static Supplier<Double> randomDouble = Math::random;
    public static BiFunction<Integer, Integer, Integer> randomInt = (a, b) -> (int) (Math.random() * (b-a) + a);

    // ceil
    public static Function<Double, Double> ceilDouble = Math::ceil;
    // floor
    public static Function<Double, Double> floorDouble = Math::floor;
    // round
    public static Function<Double, Long> roundDouble = Math::round;

    //Integer.parseInt
//    public static Function<String, Integer> integerInt = Integer.parseInt();


}
