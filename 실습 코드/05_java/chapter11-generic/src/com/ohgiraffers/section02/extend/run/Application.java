package com.ohgiraffers.section02.extend.run;
import com.ohgiraffers.section02.extend.*;

public class Application {
    public static void main(String[] args) {
        //RabbitFarm<Snake> rabbitFarm = new RabbitFarm<>(); //Snake는 Rabbit의 자손이 아니어서 에러
        RabbitFarm<Rabbit> farm1 = new RabbitFarm<>(new Rabbit());
        RabbitFarm<Bunny> farm2 = new RabbitFarm<>(new Bunny());
        RabbitFarm<DrunkenBunny> farm3 = new RabbitFarm<>(new DrunkenBunny());

        FarmManager farmManager = new FarmManager();
        farmManager.managerAnyFarm(farm1);
        farmManager.managerAnyFarm(farm2);
        farmManager.managerAnyFarm(farm3);

        farmManager.managerRabbitOrBunnyFarm(farm1);
        farmManager.managerRabbitOrBunnyFarm(farm2);
        //farmManager.managerRabbitOrBunnyFarm(farm3);

    }
}
