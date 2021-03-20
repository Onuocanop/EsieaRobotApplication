package com.example.esiearobotapplication.Others;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 *  L'interface StandAPI permet d'obtenir le fichier json
 *  et appeler la classe JSONResponse pour initialiser les
 *  éléments.
 *
 *  le lien du GET est le chemin des ressources de l'URL
 *  qui va etre appeler dans les 2 StandActivity
 *
 * @author Onur Can Kadioglu
 * @version 1.0
 */

public interface StandAPI
{
    @GET("Onuocanop/698f3868c30a213fd03bddb974c5a0ba/raw/8829ce3ce49a73bce2392d1500c9eabc0c3483a3/kek.json")
    Call<JSONResponse> getStands();
}
