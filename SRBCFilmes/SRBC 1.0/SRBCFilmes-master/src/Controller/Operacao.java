/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Peterson
 */
public class Operacao {  
    
    
    public DefaultComboBoxModel getLista (String Lista ,ArrayList<String> dados ){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (int i = 0;i< dados.size(); i++) {
            if (dados.get(i).startsWith(Lista)){
            modelo.addElement(dados.get(i));//.toUpperCase()
            }
        }
         return modelo;
        }
        public static int FixaValor(int Valor){
          if( Valor> 100){
            Valor = 100;
            return Valor;
        }
          if (Valor<0){
            Valor =0;
            return Valor;
          }
       return Valor;
     }
    }

