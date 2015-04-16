package icaro.aplicaciones.agentes.AgenteAplicacionMinions.tareas;

import icaro.aplicaciones.informacion.gestionCitas.VocabularioGestionCitas;
import icaro.aplicaciones.informacion.minions.Evento;
import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
import icaro.infraestructura.entidadesBasicas.comunicacion.MensajeSimple;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;
import icaro.infraestructura.patronAgenteCognitivo.factoriaEInterfacesPatCogn.ItfUsoAgenteCognitivo;

public class Observar extends TareaSincrona {
	
	private String identAgenteDialogo = VocabularioGestionCitas.IdentAgenteAplicacionDialogoCitas;
	
	@Override
	public void ejecutar(Object... params) {
		
		ItfUsoAgenteCognitivo agenteChat;
		try {
			agenteChat = (ItfUsoAgenteCognitivo) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ
					.obtenerInterfazUso(identAgenteDialogo);
			 if (agenteChat!=null){
				 Evento ev = new Evento("observe");
				 ev.setParameter("entity", this.getIdentAgente());
				
				 MensajeSimple ms = new MensajeSimple(ev, this.getIdentAgente(), identAgenteDialogo);
				 agenteChat.aceptaMensaje(ms);
	         }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}