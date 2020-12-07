package com.example.android2finalproject;

public class Deals {
    private int poster;


    public Deals(int poster) {
        this.poster = poster;

    }
    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }



        @Override
        public String toString() {
            return "Deals{" +
                    "poster=" + poster +
                    '}';
        }
    }

