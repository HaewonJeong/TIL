package com.ohgiraffers.section01.init;

public class Application {
    public static void main(String[] args) {
        Car car1 = new Car("페라리", 300);
        Car car2 = new Car("람보르기니", 350);
        Car car3 = new Car("롤스로이스", 250);

        car1.driveMaxSpeed();
        car2.driveMaxSpeed();
        car3.driveMaxSpeed();

        //객체 배열 선언
        Car[] carArr = new Car[3];
        System.out.println(carArr[0]);
        //Null point exception 반환
        //Exception in thread "main" java.lang.NullPointerException: Cannot invoke "com.ohgiraffers.section01.init.Car.driveMaxSpeed()" because "carArr[0]" is null
        //	at com.ohgiraffers.section01.init.Application.main(Application.java:17)

        try{
            carArr[0].driveMaxSpeed();
        }catch(NullPointerException e){
            System.out.println("!! NPE 발생 !!");
        }
        carArr[0] = new Car("페라리", 300);
        carArr[1] = new Car("람보르기니", 350);
        carArr[2] = new Car("롤스로이스", 250);

        carArr[0].driveMaxSpeed();

        for(int i = 0; i < carArr.length; i++){
            carArr[i].driveMaxSpeed();
        }
        int[] arr = {1, 2, 3, 4, 5};
        //객체 배열도 선언과 동시에 리터럴({})로 초기화 할 수 있다.
        Car[] carArr2 = {
                new Car("페라리", 300),
                new Car("람보르기니", 350),
                new Car("롤스로이스", 250)
        };

        for(Car car : carArr2){
            car.driveMaxSpeed();
        }

        /*가장 빠른 차 찾기*/
        //1. 첫 번째 차를 '가장 빠른 차'라고 가정
        Car fastestCar = carArr[0];
        //2. 두 번째 차부터 비교 - 더 빠른 차가 나오면 교체
        for(int i = 1; i < carArr.length; i++){
            if(carArr[i].getMaxSpeed() > fastestCar.getMaxSpeed() ){
                fastestCar = carArr[i];
            }
        }
        System.out.println("가장 빠른 차: "+fastestCar.getModelName()+"시속: "+fastestCar.getMaxSpeed());

    }
}
