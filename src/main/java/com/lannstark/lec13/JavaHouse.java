package com.lannstark.lec13;

public class JavaHouse {

    private String address;
    private LivingRoom livingRoom;

    public JavaHouse(String address) {
        this.address = address;
        this.livingRoom = new LivingRoom(10);
    }

    public LivingRoom getLivingRoom() {
        return livingRoom;
    }

    public static class LivingRoom {
        private double area;

        public LivingRoom(double area) {
            this.area = area;
        }

        /*
        public String getAddress() {
            // 바깥 클래스와 연결
            // 내부 클래스를 static 사용 클래스로 바꾸면, 바깥 클래스를 바로 불러올 수 없음
            return JavaHouse.this.address;
        }
        */
    }

}