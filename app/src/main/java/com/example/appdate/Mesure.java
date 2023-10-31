package com.example.appdate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class Mesure {

    private float poidsM;
    private Date dateM;
    private static ArrayList<Mesure> lstMesures = new ArrayList<>();

public static  ArrayList<Mesure> getLstMesures()
{
    return  lstMesures;
}
    public Mesure(float poidsM)
    {
        this.poidsM=poidsM;
        dateM= new Date();
    }
    public static void  ajouter(Mesure newMesure)
            throws  Exception
    {
        //je récupére la date fournie sous forme jj/mm/a
        DateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
        String d1=DF.format(newMesure.dateM.getTime());

        for (Mesure M : lstMesures)
        {
            //je récupére la date de  sous forme jj/mm/a

            String d2=DF.format(M.dateM.getTime());
            if (d1.equals(d2))
            {
               throw new Exception("Un poids est déjà enregistré pour cette date");

            }

        }
        lstMesures.add(newMesure);
    }
    @Override
    public String toString() {
        //Autre manière de récupérer la date
        GregorianCalendar GC = new GregorianCalendar();
        GC.setTime(dateM);
        int mois=GC.get(GregorianCalendar.MONTH) + 1;
        int annee=GC.get(GregorianCalendar.YEAR) ;
        int jour=GC.get(GregorianCalendar.DATE);
        int heu = GC.get(GregorianCalendar.HOUR);
        return "Le : " +
                jour  + "/" + mois + "/" + annee +" at " + heu + " h : "
                + poidsM +
                " Kg";
    }
}
