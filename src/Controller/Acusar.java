package Controller;

import java.util.ArrayList;

import javax.swing.JComboBox;

import Model.GameStart;

public class Acusar {

	public static boolean verificar(String s1, String s2, String s3)
	{
		return GameStart.getJogo().verificaResposta(s1, s2, s3);
	}
	
	public static void eliminar()
	{
		GameStart.getJogo().eliminar(Turnos.getTurno());
		Turnos.nextTurno();
	}
}
