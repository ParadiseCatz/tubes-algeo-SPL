import java.util.*;
import java.io.*;

public class MainProgram {

	InputReader mainProgramReader, inputReader;
	BufferedWriter outputWriter;

	String inputString;
	int inputInt;

	void run() throws Exception {
		init();
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
			System.out.print("Masukkan nama file input: ");
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

	void launchMenu() throws Exception {
		System.out.println();
		System.out.println("===================");
		System.out.println("TUGAS BESAR ALGEO 1");
		System.out.println("===================");
		System.out.println("Menu:");
		System.out.println("1. Menyelesaikan Matriks");
		System.out.println("2. Menyelesaikan SPL");
		System.out.println("3. Menyelesaikan Interpolasi");
		System.out.println("4. About");
		System.out.println("5. Exit");
		System.out.print("Pilihan Anda: ");
		inputInt = mainProgramReader.nextInt();
		switch (inputInt) {
			case 1: {
				launchSettings();
				launchMatriks();
				break;
			}
			case 2: {
				launchSettings();
				launchSPL();
				break;
			}
			case 3: {
				launchSettings();
				launchInterpolasi();
				break;
			}
			case 4: {
				launchAbout();
				break;
			}
			case 5: {
				mainProgramReader.close();
				inputReader.close();
				outputWriter.close();
				System.exit(0);
				break;
			}
			default: {
				System.out.println("Pilihan Salah!");
			}
		}
		System.out.println("Press Enter to continue.");
		mainProgramReader.nextChar();
		launchMenu();
	}

	void launchMatriks() throws Exception {
		System.out.println("--Masukkan Data--");
		int jmlBaris = inputReader.nextInt();
		int jmlKolom = inputReader.nextInt();
		Matrix matriks = new Matrix(jmlBaris,jmlKolom);
		matriks.read(inputReader);
		System.out.println("--MATRIKS--");
		System.out.println("1. Eliminasi menggunakan metode Gauss");
		System.out.println("2. Eliminasi menggunakan metode Gauss-Jordan");
		inputInt = mainProgramReader.nextInt();
		switch (inputInt) {
			case 1: {
				matriks.eliminateUsingGaussMethod();
				matriks.write(outputWriter);
				break;
			}
			case 2: {
				matriks.eliminateUsingGaussJordanMethod();
				matriks.write(outputWriter);
				break;
			}
			default: {
				System.out.println("Pilihan Salah!");
			}
		}
	}

	void launchSPL() throws IOException {
		System.out.println("--Masukkan Data--");
		int jmlVariabel = inputReader.nextInt();
		int jmlPersamaan = inputReader.nextInt();
		System.out.println("--Masukkan Data--");
		SistemPersamaanLinear sistemPersamaanLinear = new SistemPersamaanLinear(jmlVariabel,jmlPersamaan);
		sistemPersamaanLinear.read(inputReader);
		System.out.println("--Masukkan Data--");
		sistemPersamaanLinear.solve();
		System.out.println("---SISTEM PERSAMAAN LINEAR---");
		sistemPersamaanLinear.write(outputWriter);
	}

	void launchInterpolasi() throws IOException {
		System.out.println("--Masukkan Data--");
		int jmlTitik = inputReader.nextInt();
		Interpolasi interpolasi = new Interpolasi(jmlTitik);
		interpolasi.read(inputReader);
		interpolasi.solve();
		System.out.println("---INTERPOLASI---");
		System.out.println("1. Tunjukkan persamaan di pilihan output");
		System.out.println("2. Cari Y dengan X tertentu");
		inputInt = mainProgramReader.nextInt();
		switch (inputInt) {
			case 1: {
				interpolasi.write(outputWriter);
				break;
			}
			case 2: {
				System.out.println("Masukkan X: ");
				double x = mainProgramReader.nextDouble();
				double y = interpolasi.findY(x);
				System.out.println("Y bernilai " + y);
				break;
			}
			default: {
				System.out.println("Pilihan Salah!");
			}
		}
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
