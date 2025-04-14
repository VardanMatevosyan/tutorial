package com.practice.chain.solution;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PhoneNumberSendChainElement extends CommonChain implements Chain {


    @Override
    public void send(Request request) {
        if (Objects.nonNull(request.getPhoneNumber())) {
            System.out.println("Send message via the phone number "
                    + request.getPhoneNumber() + " Message is " + request.getMessage());
        } else {
            sendToNextChain(request);
        }
    }


    @Override
    public void setNext(Chain chain) {
        this.nextChain = chain;
    }
}
