
package Vista;

import Controlador.LogicaContacto;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;


/* @author Usuario*/
public class GraficaContactoNumerosP extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarContacto
     */
    public GraficaContactoNumerosP() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        MenuPri = new javax.swing.JButton();
        MenuCon = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        graficar = new javax.swing.JButton();
        panelG = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(77, 68, 139));

        jPanel2.setBackground(new java.awt.Color(120, 122, 195));

        MenuPri.setBackground(new java.awt.Color(77, 68, 139));
        MenuPri.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        MenuPri.setForeground(new java.awt.Color(255, 255, 255));
        MenuPri.setText("Menú principal");
        MenuPri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuPriActionPerformed(evt);
            }
        });

        MenuCon.setBackground(new java.awt.Color(77, 68, 139));
        MenuCon.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        MenuCon.setForeground(new java.awt.Color(255, 255, 255));
        MenuCon.setText("Menú contactos");
        MenuCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuConActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuCon)
                    .addComponent(MenuPri))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MenuPri)
                .addGap(41, 41, 41)
                .addComponent(MenuCon)
                .addGap(51, 51, 51))
        );

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(168, 242, 254));
        jLabel1.setText("Cantidad de teléfonos por cada contacto");

        jPanel4.setBackground(new java.awt.Color(65, 58, 132));

        graficar.setBackground(new java.awt.Color(65, 58, 132));
        graficar.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        graficar.setForeground(new java.awt.Color(255, 255, 255));
        graficar.setText("Generar gráfica");
        graficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graficarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGLayout = new javax.swing.GroupLayout(panelG);
        panelG.setLayout(panelGLayout);
        panelGLayout.setHorizontalGroup(
            panelGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelGLayout.setVerticalGroup(
            panelGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(graficar)
                .addGap(0, 333, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(graficar)
                .addGap(32, 32, 32)
                .addComponent(panelG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuPriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuPriActionPerformed
        MenuPrincipal mp = new MenuPrincipal();
        mp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MenuPriActionPerformed

    private void MenuConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuConActionPerformed
        MenuContacto mc = new MenuContacto();
        mc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MenuConActionPerformed

    private void graficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graficarActionPerformed
        LogicaContacto lc = null;
        try {
            lc = new LogicaContacto();
        } catch (IOException ex) {
            Logger.getLogger(GraficaContactoNumerosP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Obtener los datos en un formato adecuado para XYDataset
        DefaultCategoryDataset dataset = null;
        try {
            dataset = lc.getDatosP(); // Asume que getDatos() devuelve un XYDataset
        } catch (Exception ex) {
            Logger.getLogger(GraficaContactoNumerosP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JFreeChart grafico_valores = ChartFactory.createLineChart(
            "Gráfica de puntos",       // Nombre del gráfico 
            "Contacto", // Nombre de las barras (eje x)
            "Número de teléfonos",         // Nombre de los valores (eje y)
            dataset,                    // Dato del gráfico
            PlotOrientation.VERTICAL,   // Orientación
            true,                       // Leyenda para los valores en barra (individuales)
            false,                      // Herramientas
            false                       // URL del gráfico
        );
        
        //Mostrando la gráfica en el panel
        ChartPanel panel = new ChartPanel(grafico_valores);
        //Solo si tenemos las herramientas activas
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(400,200));
        panelG.setLayout(new BorderLayout());
        //El BorderLayout.NORTH es para colocar la grafica que se ecncunetra en el panel con respecto al borde superior 
        panelG.add(panel,BorderLayout.NORTH);
        
        //Estos métodos gestionan los gráficos en mi interfaz. Son necesarios porque sino se indica que la interfaz va a mostrar una gráfica
        pack();
        repaint();
        
    }//GEN-LAST:event_graficarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MenuCon;
    private javax.swing.JButton MenuPri;
    private javax.swing.JButton graficar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel panelG;
    // End of variables declaration//GEN-END:variables
}
