package com.example.esiearobotapplication.Others;


/**
 * JSONResponse est la classe pour spécifier et appeller les tableaux de données du fichier json pour les extraires.
 * exemple: private Stand[] élélment;
 *
 * @author Onur Can Kadioglu
 * @version 1.0
 */

public class JSONResponse
{
    private Stand[] esieaStands;
    private Stand[] intechStands;
    private Image[] firstImage;
    private Image[] secondImage;



    public void setFirstImage(Image[] firstImage) {
        this.firstImage = firstImage;
    }

    public void setSecondImage(Image[] secondImage) {
        this.secondImage = secondImage;
    }

    public void setEsieaStands(Stand[] esieaStands) {
        this.esieaStands = esieaStands;
    }
    public void setIntechStand(Stand[] intechStand) {
        this.intechStands = intechStands;
    }




    public Stand[] getEsieaStands() {
        return esieaStands;
    }
    public Stand[] getIntechStand() {
        return intechStands;
    }

    public Image[] getFirstImage() {
        return firstImage;
    }

    public Image[] getSecondImage() {
        return secondImage;
    }

}
