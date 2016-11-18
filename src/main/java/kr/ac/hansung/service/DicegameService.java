package kr.ac.hansung.service;

import org.springframework.stereotype.Service;

import kr.ac.hansung.model.Dice;
import kr.ac.hansung.model.WinningStatus;

@Service
public class DicegameService {
	private static final DicegameService instance = new DicegameService();

	int Goal = 29;

	private Dice dice1;
	private Dice dice2;

	private int faceValue1;
	private int faceValue2;

	private int curCell1;
	private int curCell2;
	
	private WinningStatus ws;

	public static DicegameService getInstance() {
		return instance;
	}
	
	public DicegameService() {
		dice1 = new Dice();
		dice2 = new Dice();

		ws = WinningStatus.NotYet;
		
		faceValue1 = 0;
		faceValue2 = 0;
		curCell1 = 0;
		curCell2 = 0;
		/*
		map = new int[30];

		for (int i=0; i<30; i++) {
			map[i] = i;
		}
		*/
	}

	public void init() {
		faceValue1 = 0;
		faceValue2 = 0;
		curCell1 = 0;
		curCell2 = 0;
	}

	public void roll() {
		faceValue1 = dice1.roll();
		faceValue2 = dice2.roll();

		curCell1 = curCell1 + faceValue1;
		curCell2 = curCell2 + faceValue2;

		// �� player�� ���ÿ� goal�� �����ߴ��� ���º�
		if (curCell1 >= Goal && curCell2 >= Goal) {
			// ���ΰ�ħ�̳� �ڷΰ��� ���� �� �����Ǵ� �� ����
			init();
			ws = WinningStatus.Draw;
		}
		// player�� ���� goal�� �����ߴٸ� player ��
		else if (curCell1 >= Goal && curCell2 < Goal) {
			init();
			ws = WinningStatus.Player;
		}
		// alpha�� ���� goal�� �����ߴٸ� alpha ��
		else if (curCell1 < Goal && curCell2 >= Goal) {
			init();
			ws = WinningStatus.AlphaDice;
		} else {
			if (curCell1 != map[curCell1]) {
				curCell1 = map[curCell1];
			}
			if (curCell2 != map[curCell2]) {
				curCell2 = map[curCell2];
			}
		}
	}


	public int getFaceValue1() {
		return faceValue1;
	}
	public int getFaceValue2() {
		return faceValue2;
	}
	public int getCurCellPos1() {
		return curCell1;
	}
	public int getCurCellPos2() {
		return curCell2;
	}
	
	public WinningStatus getWs() {
		return ws;
	}
	
	public String getResultMessage(WinningStatus ws) {
		
		String message;
		
		if(ws == WinningStatus.Draw)
			message = "Draw!";
		else if(ws == WinningStatus.Player)
			message = "Win!";
		else
			message = "Lose!";
		
		this.ws = WinningStatus.NotYet;
		
		return message;
	}
}
