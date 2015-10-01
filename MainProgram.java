import java.util.*;
import java.io.*;

public class MainProgram {

	InputReader mainProgramReader, inputReader;
	BufferedWriter outputWriter;

	String inputString;
	int inputInt;

	void run() throws Exception {
		init();
		launchSettings();
		launchMenu();
	}

	void init() {
		mainProgramReader = new InputReader(new BufferedReader(new InputStreamReader(System.in)));
	}

	void launchSettings() throws IOException {
		System.out.println("/-Settings-/");
		System.out.print("Masukan berasal dari mana? (stdin/file): ");
		inputString = mainProgramReader.nextString();
		if (inputString.charAt(0) == 's') {
			inputReader = new InputReader(new BufferedReader(new InputStreamReader(System.in)));
		}
		if (inputString.charAt(0) == 'f') {
			System.out.print("Masukan nama file input: ");
			inputString = mainProgramReader.nextString();
			try {
				inputReader = new InputReader(new BufferedReader(new InputStreamReader(new FileInputStream(inputString))));				
			} catch (FileNotFoundException e) {
				System.out.println("File tidak ditemukan");
			}

		}
		System.out.print("Keluaran ditulis kemana? (stdout/file): ");
		inputString = mainProgramReader.nextString();
		if (inputString.charAt(0) == 's') {
			outputWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		}
		if (inputString.charAt(0) == 'f') {
			System.out.print("Masukan nama file input: ");
			inputString = mainProgramReader.nextString();
			try {
				outputWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(inputString)));
			} catch (FileNotFoundException e) {
				System.out.println("File tidak ditemukan");
			}

		}
	}

	void launchMenu() throws IOException {
		System.out.println();
		System.out.println("===================");
		System.out.println("TUGAS BESAR ALGEO 1");
		System.out.println("===================");
		System.out.println("Menu:");
		System.out.println("1. Menyelesaikan Matriks");
		System.out.println("2. Menyelesaikan SPL");
		System.out.println("3. Menyelesaikan Interpolasi");
		System.out.println("4. Settings");
		System.out.println("5. About");
		System.out.println("6. Exit");
		System.out.print("Pilihan Anda: ");
		inputInt = mainProgramReader.nextInt();
		switch (inputInt) {
			case 1: {
				launchMatriks();
				break;
			}
			case 2: {
				launchSPL();
				break;
			}
			case 3: {
				launchInterpolasi();
				break;
			}
			case 4: {
				launchSettings();
				break;
			}
			case 5: {
				launchAbout();
				break;
			}
			case 6: {
				System.exit(0);
				break;
			}
			default: {
				System.out.println("Pilihan Salah!");
			}
		}
		System.out.println("Press Enter to continue.");
		inputReader.nextChar();
		launchMenu();
	}

	void launchMatriks() {

	}

	void launchSPL() {

	}

	void launchInterpolasi() {
		int jmlTitik = inputReader.nextInt();
		Interpolasi interpolasi = new Interpolasi(jmlTitik);
		interpolasi.read(inputReader);
		interpolasi.solve();
		System.out.println("---INTERPOLASI---");
		System.out.println("1. Tunjukkan persamaan");
		System.out.println("2. Cari Y dengan X tertentu");
		inputInt = mainProgramReader.nextInt();
		switch (inputInt) {
			case 1: {
				launchMatriks();
				break;
			}
			case 2: {
				launchSPL();
				break;
			}
			default: {
				System.out.println("Pilihan Salah!");
			}
		}
		System.out.println("Press Enter to continue.");
		inputReader.nextChar();
		launchMenu();
	}

	void launchAbout() {
		System.out.println("/-About-/");
		System.out.println("Dibuat oleh:");
		System.out.println("13514003 - Davin Prasetya");
		System.out.println("13514083 - Nathan J. Runtuwene");
		System.out.println("13514085 - Christian A. Setyawan");
	}

	public static void main(String[] args) {
		try {
			new MainProgram().run();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
