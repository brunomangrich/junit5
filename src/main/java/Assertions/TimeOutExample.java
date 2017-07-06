
package Assertions;

public class TimeOutExample {

	public void aguardarDezSegundos() {
		try {
			Thread.sleep(10000);// 10 segundos
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void aguardarVinteSegundos() {
		try {
			Thread.sleep(20000);// 20 segundos
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
