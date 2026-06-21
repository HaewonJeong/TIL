package com.ohgiraffers.section02.extend;

public class FarmManager {

    public void managerAnyFarm(RabbitFarm<?> farm){
        System.out.println("어떤 토끼 농장이든 관리 가능해요.");
        farm.getAnimal().cry();

    }

    public void managerBunnyFarm(RabbitFarm<? extends Bunny> farm){
        System.out.println("바니 혹은 드렁큰 바니만 관리 가능해요");
        farm.getAnimal().cry();

    }

    public void managerRabbitOrBunnyFarm(RabbitFarm<? super Bunny> farm){
        System.out.println("Rabbit 혹은 바니만 가능해요");
        farm.getAnimal().cry();

    }
}
