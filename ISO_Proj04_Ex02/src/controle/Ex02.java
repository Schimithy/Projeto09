package controle;

import java.util.concurrent.Semaphore;

public class Ex02 extends Thread{

	private int idCarro;
	private Semaphore farol;
	private String direcao;
	
	public Ex02(int idCarro, Semaphore farol) {
		
		this.idCarro = idCarro;
		this.farol = farol;
		
	}
	
	public void run() {
		
		obtenDirecao();
		//seção crítica »
		try {
			farol.acquire();
			cruzamento();
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		} finally {
		farol.release();	
		}
		//« seção crítica 
	}
	
	private void obtenDirecao() {
		switch (idCarro) {
		case 1: direcao = "Norte";
			break;
		case 2: direcao = "Sul";
			break;
		case 3: direcao = "Leste";
			break;
		case 4: direcao = "Oeste";
			break;
		}
	}
	
	private void cruzamento() {
		int cruzando = 300;
		System.out.println("O carro #" + idCarro + " - iniciou o cruzamento para a direção " + direcao);
			try {
				Thread.sleep(cruzando);
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
			System.out.println("O carro #"+ idCarro + " finalizou o cruzamento");
		}
	
}