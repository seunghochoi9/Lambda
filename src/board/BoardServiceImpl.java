package board;

public class BoardServiceImpl implements board.BoardService {
    private static board.BoardService instance = new BoardServiceImpl();
    private BoardServiceImpl(){}

    public static board.BoardService getInstance(){
        return instance;
    }
}
