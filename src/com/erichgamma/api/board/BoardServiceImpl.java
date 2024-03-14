package com.erichgamma.api.board;

public class BoardServiceImpl implements com.erichgamma.api.board.BoardService {
    private static com.erichgamma.api.board.BoardService instance = new BoardServiceImpl();
    private BoardServiceImpl(){}

    public static com.erichgamma.api.board.BoardService getInstance(){
        return instance;
    }
}
