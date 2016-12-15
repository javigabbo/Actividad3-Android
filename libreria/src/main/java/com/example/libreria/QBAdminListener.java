package com.example.libreria;

import com.quickblox.core.model.QBBaseCustomObject;
import com.quickblox.customobjects.model.QBCustomObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Javigabbo on 22/11/16.
 */

public interface QBAdminListener {

    public void logeado (boolean blLogeado);
    public void registrado (boolean blRegistrado);
    public  void datosDescargados (HashMap <Integer, String> datos);

}
