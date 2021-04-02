package service.forms;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class FormUtils {

	public static String getParameter(HttpServletRequest request, String champ)
	{
		String parametre = request.getParameter(champ);
		parametre = (parametre == null || parametre.trim().isEmpty()) ? null
				: parametre.trim();
		return parametre;
	}

	public static void validerChamps(HttpServletRequest request,
			Map<String, String> messageErreur, String... champs)
	{
		for (String champ : champs)
		{
			if (FormUtils.getParameter(request, champ) == null)
			{
				messageErreur.put(champ, "Vous devez renseigner ce champ");
			}
		}
	}
}
