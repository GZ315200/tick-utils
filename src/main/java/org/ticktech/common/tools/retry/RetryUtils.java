package org.ticktech.common.tools.retry;

import com.github.rholder.retry.RetryException;
import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * Project: wasta
 * Package: org.ticktech.wasta.common
 * <p>
 * Date: 2021/4/13
 * Time: 上午10:29
 * Desc:
 * <p>
 * Created with Zean
 */
public class RetryUtils {


    public static<T> void tryTimes(int n, Callable<T> call) {
        final Retryer<T> retry = RetryerBuilder.<T>newBuilder()
                .retryIfException()
                .withStopStrategy(StopStrategies.stopAfterAttempt(n))
                .build();
        try {
            retry.call(call);
        } catch (ExecutionException | RetryException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Callable<Boolean> callable = new Callable<Boolean>() {
            public Boolean call() throws Exception {
                System.out.println("exec:");
                return false;
            }
        };
        RetryUtils.tryTimes(3, callable);
    }
}
