package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
	public static void main(String[] args) {
		System.out.println();
		String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
		for(String candidato: candidatos) {
			entrandoEmContato(candidato);
		}
	}
	static void entrandoEmContato(String candidato) {
		int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu = false;
		
		do {
			atendeu = atender();
			continuarTentando = !atendeu;
			if (continuarTentando) {
				tentativasRealizadas++;
			}else {
				System.out.println("contato realizado com sucesso");
			}
			
		}while(continuarTentando && tentativasRealizadas < 3);
			
		if(atendeu) {
			System.out.println("conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentaiva");
		}else {
			System.out.println("Nao conseguimos contato com " + candidato + " numero maximo tentativas " + tentativasRealizadas + " realziadas");
		}	
		
	}
	
	static boolean atender() {
		return new Random().nextInt(3)==1;
	}
	
	static void imprimirSelecionados() {
		String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
		
		for(int i = 0; i < candidatos.length; i++) {
			System.out.println("o candidato de numero " + (i +1) + "é o" + candidatos[i]);
		}
	}
	
	static void selecaoCandidatos() {
		String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};
		
		int candidatosSelecionados = 0;
		int candidatoAtual = 0;
		double salarioBase = 2000.0;
		while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
			String candidato = candidatos[candidatoAtual];
			double salarioPretendido = valorPretendido();
			
			System.out.println("o candidato " + candidato + "solicitou esse salario " + salarioPretendido);
			
			if(salarioBase >= salarioPretendido) {
				System.out.println("o candidato " + candidato + "foi selecionado para a vaga");
				candidatosSelecionados++;
			}
			candidatoAtual++;
		}
	}
	
	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}
	
	static void analisarCandidato(double salarioPretendido) {
		double salarioBase = 2000.0;
		
		if(salarioBase > salarioPretendido) {
			System.out.println("ligar para o candidato");
		}else if(salarioBase == salarioPretendido){
			System.out.println("Ligar para candidato com contra proposta");
		}else {
			System.out.println("aguardando resultado dos demais candidatos");
		}
	}
}
