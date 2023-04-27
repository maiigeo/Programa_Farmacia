/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import Model.Pedido;
import View.Farmacia;
import View.resumen_pedido;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class controler_pedido {
    private Model.Pedido modelo;
    private View.Farmacia vista;
    private View.resumen_pedido vista2;
    
    int id_pedido=0;
    String Nombre="";
    String Distribuidora="";
    String Cantidad="";
    String Tipo="";
    String Sucursal="";
    String Direccion="";
    
    ArrayList<Pedido>listapedido= new ArrayList<>();
    
    private void Guardar_pedido() {
       
    }

    public controler_pedido(Pedido modelo, Farmacia vista) {
        this.modelo = modelo;
        this.vista= vista;
        vista.setVisible(true);
    }

    public controler_pedido(Pedido modelo, Farmacia vista, resumen_pedido vista2) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista2 = vista2;
    }
    
    public void iniciaCOntrol() {

        vista.setLocationRelativeTo(null);
        vista.getBtb_ok().addActionListener(l -> verificardatos());
        
    }
    private void verificardatos() {
        
        if(vista.getTxtNombreMedicamentos().getText().equals("") || vista.getTxt_cantidad().getText().equals(" ")
                || vista.getCheck_principal().isSelected()== false && vista.getCheck_secundaria().isSelected()==false 
                || vista.getRdbtb_CEMEFAR().isSelected()== false && vista.getRdbtb_EMPSEPHAR().isSelected()== false && vista.getRdbtb_COFARMA().isSelected() == false){
            JOptionPane.showMessageDialog(null, "Hay campos vacios");
        }else{    
        Pedido mipedido = new Pedido();
        Nombre = vista.getTxtNombreMedicamentos().getText();
        Cantidad= vista.getTxt_cantidad().getText();  
        Tipo=vista.getCombobox_tipo().getSelectedItem().toString();
        
        
            if(!Nombre.matches("^[a-zA-Z]{1}$")){
                    if(Cantidad.matches("^[0-9]{1,3}$")){
                        
                        if(vista.getRdbtb_COFARMA().isSelected()){
                        Distribuidora="COFARMA";
                        }
                            if(vista.getRdbtb_CEMEFAR().isSelected()){
                            Distribuidora="CEMEFAR";
                            }
                                if(vista.getRdbtb_EMPSEPHAR().isSelected()){
                                Distribuidora="EMPSEPHAR";
                                }

                                    if(vista.getCheck_principal().isSelected()){
                                     Sucursal="Principal";
                                    Direccion="Calle de la Rosa n. 28";
                                    } 
                                        if(vista.getCheck_secundaria().isSelected()){
                                        Sucursal="Secundaria";
                                        Direccion ="Calle Alcazabilla n. 3";
                                        } 
                                            
                                            
                                            mipedido.setNombre(Nombre);
                                            mipedido.setCantidad(Cantidad);
                                            mipedido.setTipo_medicamento(Tipo);
                                            mipedido.setDistribuidor(Distribuidora);
                                            mipedido.setSucursal(Sucursal);
                                            mipedido.setDireccion(Direccion);
                       
                                            listapedido.add(mipedido);
                                            vista.getTxt_cantidad().setText("");
                                            vista.getCombobox_tipo().setToolTipText("");
                                             vista.getBtbgroup_distribuidoras().clearSelection();
                         
                                            vista2= new resumen_pedido(mipedido);
                         
                                            vista2.setVisible(true);
                         
   
                         
                    }else{
                        JOptionPane.showMessageDialog(vista,"Cantidad no válida, ingrese solo números positivos"); 
                    }
            }else{
                JOptionPane.showMessageDialog(vista,"Nombre no válido"); 
            }
                    
        }
    }

        
        

    
        
    

    
        
}
