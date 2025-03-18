package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KillController {

	private String Os() {

		return System.getProperty("os.name");

	}

	// Lista os processos rodando na máquina
	public void ListaProcessos() {

		Process process = null;
		String osName = Os();

		try {

			if (osName.toLowerCase().contains("windows")) {

				process = Runtime.getRuntime().exec("TASKLIST /FO TABLE");

			} else if (osName.toLowerCase().contains("nux") || osName.toLowerCase().contains("nix")
					|| osName.toLowerCase().contains("mac")) {

				process = Runtime.getRuntime().exec("ps -ef");

			}

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String linha = "";

			while ((linha = reader.readLine()) != null) {

				System.out.println(linha);

			}

			process.waitFor();
			reader.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	// Mata o processo através do pid
	public void MataPid(int pid) {

		Process process = null;
		String osName = Os();

		try {

			if (osName.toLowerCase().contains("windows")) {

				process = Runtime.getRuntime().exec("TASKKILL /PID " + pid);

			} else if (osName.toLowerCase().contains("nux") || osName.toLowerCase().contains("nix")
					|| osName.toLowerCase().contains("mac")) {

				process = Runtime.getRuntime().exec("kill -9 " + pid);

			}

			process.waitFor();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	// Mata o processo através do nome
	public void MataNome(String nome) {

		Process process = null;
		String osName = Os();

		try {

			if (osName.toLowerCase().contains("windows")) {

				process = Runtime.getRuntime().exec("TASKKILL /IM " + nome);

			} else if (osName.toLowerCase().contains("nux") || osName.toLowerCase().contains("nix")
					|| osName.toLowerCase().contains("mac")) {

				process = Runtime.getRuntime().exec("pkill -f " + nome);

			}

			process.waitFor();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
