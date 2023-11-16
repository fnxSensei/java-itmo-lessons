package com.itmo.project.lesson18;
@FunctionalInterface
public interface IPay {
    boolean pay(int anount);

    default IPay additionalPay(IPay another){
        return (anount) -> {
            if (!pay(anount)) return another.pay(anount);


            return true;
        };

    }
}
