package com.erichgamma.api.board;

import com.erichgamma.api.common.UtilService;
import com.erichgamma.api.common.UtilServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BoardView {
    public static void main(Scanner scanner) {
        List<Board> articles = new ArrayList<>();
        UtilService util = UtilServiceImpl.getInstance();

        for(int i=0;i<5;i++){
            articles.add(Board.builder()
                    .boardType(util.createRandomTitle())
                    .boardName(util.createRandomName()).build());
            System.out.println(articles.get(i));
        }

        for(Board i :articles) {
            System.out.println(i.toString());
        }
        articles.forEach(i -> {
            System.out.println(i.toString());
        });
    }
}
