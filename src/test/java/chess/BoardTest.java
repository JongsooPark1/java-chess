package chess;

import static org.junit.Assert.*;

import static utils.StringUtils.appendNewLine;

import org.junit.Before;
import org.junit.Test;

import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;

public class BoardTest {
	Board board;

	@Before
	public void setUp() {
		board = new Board();
		board.initialize();
	}

	@Test
	public void createTest() throws Exception {
		String blankRank = appendNewLine("........");
		assertEquals((appendNewLine("RNBQKBNR") + appendNewLine("PPPPPPPP") + blankRank + blankRank + blankRank
				+ blankRank + appendNewLine("pppppppp") + appendNewLine("rnbqkbnr")), board.showBoard());
	}

	@Test
	public void getMatchCountOfPieceTest() throws Exception {
		assertEquals(8, board.getMatchCountsOfPiece(Color.WHITE, Type.PAWN));
		assertEquals(2, board.getMatchCountsOfPiece(Color.BLACK, Type.BISHOP));
		assertEquals(2, board.getMatchCountsOfPiece(Color.WHITE, Type.KNIGHT));
		assertEquals(2, board.getMatchCountsOfPiece(Color.BLACK, Type.ROOK));
		assertEquals(1, board.getMatchCountsOfPiece(Color.WHITE, Type.KING));
		assertEquals(32, board.getMatchCountsOfPiece(Color.NO_COLOR, Type.NO_PIECE)); 
	}

	@Test
	public void findPiece() throws Exception {
		assertEquals(Piece.createBlackRook(), board.findPiece("a8"));
		assertEquals(Piece.createBlackKnight(), board.findPiece("g8"));
		assertEquals(Piece.createWhiteBishop(), board.findPiece("c1"));
		assertEquals(Piece.createWhiteKing(), board.findPiece("e1"));
	}
	
	@Test
	public void showBoard() {
		System.out.println(board.showBoard());
	}

//	@Test
//    public void move() throws Exception {
//        board.initializeEmpty();
//
//        String position = "b5";
//        Piece piece = Piece.createBlackRook();
//        board.move(position, piece);
//
//        assertEquals(piece, board.findPiece(position));
//        System.out.println(board.showBoard());
//    }
}
