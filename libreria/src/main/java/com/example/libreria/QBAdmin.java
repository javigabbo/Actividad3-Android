package com.example.libreria;

import android.app.Activity;
import android.os.Bundle;

import com.quickblox.auth.QBAuth;
import com.quickblox.auth.model.QBSession;
import com.quickblox.core.Consts;
import com.quickblox.core.QBEntityCallback;
import com.quickblox.core.QBSettings;
import com.quickblox.core.exception.QBResponseException;
import com.quickblox.core.helper.StringifyArrayList;
import com.quickblox.core.request.QBRequestGetBuilder;
import com.quickblox.customobjects.QBCustomObjects;
import com.quickblox.customobjects.model.QBCustomObject;
import com.quickblox.users.QBUsers;
import com.quickblox.users.model.QBUser;

import java.util.ArrayList;


/**
 * Created by Javigabbo on 22/11/16.
 */

public class QBAdmin {

    QBAdminListener listener;

    public QBAdmin(QBAdminListener listener, Activity activity){
        this.listener = listener;
        String APP_ID = "50012";
        String AUTH_KEY = "embqAuePn3kORYf";
        String AUTH_SECRET = "yQD8cqyt5EeHKPR";
        String ACCOUNT_KEY = "onmSRZ9pppW3oLFdEsYH";
//
        QBSettings.getInstance().init(activity, APP_ID, AUTH_KEY, AUTH_SECRET);
        QBSettings.getInstance().setAccountKey(ACCOUNT_KEY);
    }


    public void iniciarSesion(final String usuario, final String password){


        QBUser user = new QBUser(usuario, password);

        QBUsers.signIn(user, new QBEntityCallback<QBUser>() {
            @Override
            public void onSuccess(QBUser user, Bundle params) {
                System.out.println("Usuario: " + usuario + ". Passw: " +password);
                listener.logeado(true);
            }

            @Override
            public void onError(QBResponseException errors) {
                System.out.println(errors+" !!!!!");
                System.out.println("Usuario: " + usuario + ". Passw: " +password);
            }
        });
    }



    public void registrarse(String usuario, String password, String email){

        final QBUser user = new QBUser(usuario, email, password);

        QBUsers.signUp(user, new QBEntityCallback<QBUser>() {
            @Override
            public void onSuccess(QBUser user, Bundle args) {
                System.out.println("USUARIO REGISTRADO CON ÉXITO.");
                listener.registrado(true);
            }

            @Override
            public void onError(QBResponseException errors) {
                System.out.println(errors + "!!!!!");
                System.out.println("ERROR AL REGISTRAR USUARIO.");
            }
        });

    }




    public void crearSesion(){

        QBAuth.createSession(new QBEntityCallback<QBSession>() {

            @Override
            public void onSuccess(QBSession session, Bundle params) {
                System.out.println("Sesion iniciada");
            }

            @Override
            public void onError(QBResponseException errors) {

            }
        });

    }

    public void selectTabla (int idIdioma){
        //listener.datosDescargados();

        QBRequestGetBuilder requestBuilder = new QBRequestGetBuilder();
        requestBuilder.eq("idi", idIdioma);

        QBCustomObjects.getObjects("idiomas", requestBuilder, new QBEntityCallback<ArrayList<QBCustomObject>>() {
            @Override
            public void onSuccess(ArrayList<QBCustomObject> customObjects, Bundle params) {
                int skip = params.getInt(Consts.SKIP);
                int limit = params.getInt(Consts.LIMIT);
            }

            @Override
            public void onError(QBResponseException errors) {

            }
        });
    }

}
