package interacao;

import java.util.concurrent.Semaphore;

import controle.Ex02;

public class Main_Ex02 {

	public static void main(String[] args) {
		
		int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);
		for(int id = 1; id <= 4; id++) {
			Thread tCarro = new Ex02(id, semaforo);
			tCarro.start();
		}
	}

}
