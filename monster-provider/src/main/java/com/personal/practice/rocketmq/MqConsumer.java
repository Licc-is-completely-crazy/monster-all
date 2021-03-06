package com.personal.practice.rocketmq;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.message.MessageExt;

import java.util.List;

public class MqConsumer {
    public static void main(String[] args) throws InterruptedException, MQClientException {

        // Instantiate with specified consumer group name.
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("monster-consumer2");

        // Specify name server addresses.
        consumer.setNamesrvAddr("localhost:9876");

        // Subscribe one more more topics to consume.
        consumer.subscribe("twoMaster", "*");
        // Register callback to execute on arrival of messages fetched from brokers.
        consumer.registerMessageListener(new MessageListenerConcurrently() {

            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                            ConsumeConcurrentlyContext context) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        //Launch the consumer instance.
        consumer.start();

        System.out.printf("Consumer Started.%n");
    }

    public static class MqConsumer2{
        public static void main(String[] args) throws InterruptedException, MQClientException {

            // Instantiate with specified consumer group name.
            DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("monster-consumer2");

            // Specify name server addresses.
            consumer.setNamesrvAddr("localhost:9876");

            // Subscribe one more more topics to consume.
            consumer.subscribe("monster", "*");
            // Register callback to execute on arrival of messages fetched from brokers.
            consumer.registerMessageListener(new MessageListenerConcurrently() {

                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                                ConsumeConcurrentlyContext context) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });

            //Launch the consumer instance.
            consumer.start();

            System.out.printf("Consumer Started.%n");
        }

    }

    public static class MqConsumer3{
        public static void main(String[] args) throws InterruptedException, MQClientException {

            // Instantiate with specified consumer group name.
            DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("monster-consumer2");

            // Specify name server addresses.
            consumer.setNamesrvAddr("localhost:9876");

            // Subscribe one more more topics to consume.
            consumer.subscribe("monster", "*");
            // Register callback to execute on arrival of messages fetched from brokers.
            consumer.registerMessageListener(new MessageListenerConcurrently() {

                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                                ConsumeConcurrentlyContext context) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });

            //Launch the consumer instance.
            consumer.start();

            System.out.printf("Consumer Started.%n");
        }

    }
}


