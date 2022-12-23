package com.csmarton.hackerrank.algorithms.leetcode.easy.logger;

import java.util.HashMap;
import java.util.Map;

public class Logger {
    Map<String, Integer> messageWithStamp = new HashMap<>();

    public Logger() {

    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!messageWithStamp.containsKey(message)) {
            messageWithStamp.put(message, timestamp);
            return true;
        }

        boolean canLog = (timestamp - messageWithStamp.get(message)) >= 10;
        if(canLog) {
            messageWithStamp.put(message, timestamp);
        }

        return canLog;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */