/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package farmacia_marilynmendieta;

import Controler.controler_pedido;
import View.Farmacia;
import javax.swing.text.View;
import Model.Pedido;
import View.resumen_pedido;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class Farmacia_MarilynMendieta {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Farmacia vistas = new Farmacia();
        Pedido modelo = new Pedido();
        controler_pedido controlador = new Controler.controler_pedido(modelo,vistas);
        controlador.iniciaCOntrol();
    }
    
}