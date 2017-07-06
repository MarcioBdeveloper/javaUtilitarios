package util.com;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VerificaPeriodoEntreDatasUtil {

	
	private static final DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	
	public boolean verificaPeriodoConflitante(LocalDate dataInicioPeriodo1, LocalDate dataFimPeriodo1, LocalDate dataInicioPeriodo2, LocalDate dataFimPeriodo2){

		String dataInicio1Formadata = dataInicioPeriodo1.format(formatador);
		String dataFim1Formatada = dataFimPeriodo1.format(formatador);
		String dataInicio2Formadata = dataInicioPeriodo2.format(formatador);
		String dataFim2Formatada = dataFimPeriodo2.format(formatador);

		if(conflitoIgualdade1(dataInicio1Formadata, dataInicio2Formadata)){
			return true;
		}
		if(conflitoIgualdade2(dataInicio1Formadata, dataFim2Formatada)){
			return true;
		}
		if(conflitoIgualdade3(dataFim1Formatada, dataInicio2Formadata)){
			return true;
		}
		if(conflitoIgualdade4(dataFim1Formatada, dataFim2Formatada)){
			return true;
		}
		if(conflito1(dataInicioPeriodo1, dataFimPeriodo1, dataInicioPeriodo2, dataFimPeriodo2)){
			return true;
		}
		if(conflito2(dataInicioPeriodo1, dataInicioPeriodo2, dataFimPeriodo2)){
			return true;
		}
		if(conflito3(dataFimPeriodo1, dataInicioPeriodo2, dataFimPeriodo2)){
			return true;
		}
		
		return false;
	}
	
	private Boolean conflitoIgualdade1(String dataInicio1Formadata, String dataInicio2Formadata){
		return dataInicio1Formadata.equals(dataInicio2Formadata);
	}
	
	private Boolean conflitoIgualdade2(String dataInicio1Formadata, String dataFim2Formatada){
		return dataInicio1Formadata.equals(dataFim2Formatada);
	}

	private Boolean conflitoIgualdade3(String dataFim1Formatada, String dataInicio2Formadata){
		return dataFim1Formatada.equals(dataInicio2Formadata);
	}

	private Boolean conflitoIgualdade4(String dataFim1Formatada,  String dataFim2Formatada){
		return dataFim1Formatada.equals(dataFim2Formatada);
	}
	
	private Boolean conflito1(LocalDate dataInicioPeriodo1, LocalDate dataFimPeriodo1, LocalDate dataInicioPeriodo2, LocalDate dataFimPeriodo2){
		return dataInicioPeriodo1.isAfter(dataInicioPeriodo2) && dataFimPeriodo1.isBefore(dataFimPeriodo2);
	}
	
	private Boolean conflito2(LocalDate dataInicioPeriodo1, LocalDate dataInicioPeriodo2, LocalDate dataFimPeriodo2){
		return dataInicioPeriodo1.isAfter(dataInicioPeriodo2) && dataInicioPeriodo1.isBefore(dataFimPeriodo2);
	}
	
	private Boolean conflito3(LocalDate dataFimPeriodo1, LocalDate dataInicioPeriodo2, LocalDate dataFimPeriodo2){
		return dataFimPeriodo1.isAfter(dataInicioPeriodo2) && dataFimPeriodo1.isBefore(dataFimPeriodo2);
	}
	
	
}
