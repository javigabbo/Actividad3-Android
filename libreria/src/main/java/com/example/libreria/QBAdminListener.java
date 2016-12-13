package com.example.libreria;

import com.quickblox.core.model.QBBaseCustomObject;

import java.util.ArrayList;

/**
 * Created by Javigabbo on 22/11/16.
 */

public interface QBAdminListener {

    public void logeado (boolean blLogeado);
    public void registrado (boolean blRegistrado);
    public  void datosDescargados (ArrayList<QBBaseCustomObject> datos);

}
