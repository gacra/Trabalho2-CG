package trabalho.cg;

import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.util.ArrayList;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

/**
 * Janela da interface gráfica.
 * 
 */
public class Janela extends javax.swing.JFrame{

    Renderer renderer;
    GLCanvas canvas;
    Figuras opcao;

    public Janela(GraphicsConfiguration gc){
        super(gc);
    }

    public Janela(){
        
        opcao = Figuras.CUBO;
        
        initComponents();
       
        //Acelera o rendering
        GLCapabilities caps = new GLCapabilities();
        caps.setDoubleBuffered(true);
        caps.setHardwareAccelerated(true);
        
        //cria o painel e adiciona um ouvinte GLEventListener
        canvas = new GLCanvas();
        canvas.setSize(500, 500);
        renderer = new Renderer(canvas);
        canvas.addGLEventListener(renderer);
        canvas.addMouseListener(renderer);
        canvas.addKeyListener(renderer);
        
        //Insere canvas na janela
        FlowLayout layout = new FlowLayout();
        painelOGL.setLayout(layout);
        painelOGL.add(canvas);
        canvas.requestFocus();
        
        //Configurações adicionais
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        //Adicina os listeners comuns
        
        FocusListener focusListenerRGB = new FocusListener() {

            @Override
            public void focusLost(FocusEvent e){
                JFormattedTextField campo = (JFormattedTextField) e.getComponent();
                mudaRGB(campo, true);
            }

            @Override
            public void focusGained(FocusEvent e){
                JFormattedTextField campo = (JFormattedTextField) e.getComponent();
                campo.setCaretPosition(0);
            }
        };
        
        red_ftf.addFocusListener(focusListenerRGB);
        green_ftf.addFocusListener(focusListenerRGB);
        blue_ftf.addFocusListener(focusListenerRGB);
        
        KeyListener keyListenerRGB = new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e){
                JFormattedTextField campo = (JFormattedTextField) e.getComponent();
                if(e.getKeyChar() == 127){
                    int carretPos = campo.getCaretPosition();
                    campo.setText(campo.getText().replace(" ", ""));
                    if(carretPos!=0){
                        campo.setCaretPosition(carretPos-1);
                    }
                }else if(e.getKeyChar() == 8){
                    int carretPos = campo.getCaretPosition();
                    campo.setText(campo.getText().replace(" ", ""));
                    campo.setCaretPosition(carretPos);
                }
            }

            @Override
            public void keyPressed(KeyEvent e){}

            @Override
            public void keyReleased(KeyEvent e){
                JFormattedTextField campo = (JFormattedTextField) e.getComponent();              
                if(e.getKeyChar() == 10){
                    mudaRGB(campo, true);
                }else{
                    mudaRGB(campo, false);
                }    
            }
        };
        
        red_ftf.addKeyListener(keyListenerRGB);
        green_ftf.addKeyListener(keyListenerRGB);
        blue_ftf.addKeyListener(keyListenerRGB);
        
        FocusListener focusListenerCMY = new FocusListener() {

            @Override
            public void focusGained(FocusEvent e){
                JFormattedTextField campo = (JFormattedTextField) e.getComponent();
                campo.setCaretPosition(0);
            }

            @Override
            public void focusLost(FocusEvent e){
                JFormattedTextField campo = (JFormattedTextField) e.getComponent();
                mudaCMY(campo, true);
            }
        };
        
        cyan2_ftf.addFocusListener(focusListenerCMY);
        magenta2_ftf.addFocusListener(focusListenerCMY);
        yellow2_ftf.addFocusListener(focusListenerCMY);
        
        KeyListener keyListenerCMY = new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e){
                JFormattedTextField campo = (JFormattedTextField) e.getComponent();
                if(e.getKeyChar() == 127){
                    int carretPos = campo.getCaretPosition();
                    campo.setText(campo.getText().replace(" ", "0"));
                    if(carretPos!=0){
                        campo.setCaretPosition(carretPos-1);
                    }
                }else if(e.getKeyChar() == 8){
                    int carretPos = campo.getCaretPosition();
                    campo.setText(campo.getText().replace(" ", "0"));
                    campo.setCaretPosition(carretPos);
                }
            }

            @Override
            public void keyPressed(KeyEvent e){}

            @Override
            public void keyReleased(KeyEvent e){
                JFormattedTextField campo = (JFormattedTextField) e.getComponent();              
                if(e.getKeyChar() == 10){
                    mudaCMY(campo, true);
                }else{
                    mudaCMY(campo, false);
                }      
            }
        };
        
        cyan2_ftf.addKeyListener(keyListenerCMY);
        magenta2_ftf.addKeyListener(keyListenerCMY);
        yellow2_ftf.addKeyListener(keyListenerCMY);
        
        FocusListener focusListenerHSV = new FocusListener() {

            @Override
            public void focusGained(FocusEvent e){
                JFormattedTextField campo = (JFormattedTextField) e.getComponent();
                campo.setCaretPosition(0);
            }

            @Override
            public void focusLost(FocusEvent e){
                JFormattedTextField campo = (JFormattedTextField) e.getComponent();
                mudaHSV(campo, true);
            }
        };
        
        sat2_ftf.addFocusListener(focusListenerHSV);
        value2_ftf.addFocusListener(focusListenerHSV);
        
        KeyListener keyListenerHSV = new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e){
                JFormattedTextField campo = (JFormattedTextField) e.getComponent();
                if(e.getKeyChar() == 127){
                    int carretPos = campo.getCaretPosition();
                    campo.setText(campo.getText().replace(" ", "0"));
                    if(carretPos!=0){
                        campo.setCaretPosition(carretPos-1);
                    }
                }else if(e.getKeyChar() == 8){
                    int carretPos = campo.getCaretPosition();
                    campo.setText(campo.getText().replace(" ", "0"));
                    campo.setCaretPosition(carretPos);
                }
            }

            @Override
            public void keyPressed(KeyEvent e){}

            @Override
            public void keyReleased(KeyEvent e){
                JFormattedTextField campo = (JFormattedTextField) e.getComponent();              
                if(e.getKeyChar() == 10){
                    mudaHSV(campo, true);
                }else{
                    mudaHSV(campo, false);
                }                
            }
        };
        
        sat2_ftf.addKeyListener(keyListenerHSV);
        value2_ftf.addKeyListener(keyListenerHSV);
        
    }

    private void mudaRGB(JFormattedTextField campo, boolean fim){
        String val_txt = campo.getText().replace(" ", "");
        //System.out.println(val_txt);
        int val;
        if(!val_txt.equals("")){
            val = Integer.parseUnsignedInt(val_txt);
            if(val > 255){
                int carretPos = campo.getCaretPosition();                                      
                val = 255;
                campo.setText(String.valueOf(val));
                campo.setCaretPosition(carretPos);
            }
        }else{            
            if(fim){
                campo.setText("000");
            }
        }
        int red = (red_ftf.getText().replace(" ", "").equals(""))? 0 : Integer.parseInt(red_ftf.getText().replace(" ", ""));
        int blue = (blue_ftf.getText().replace(" ", "").equals(""))? 0 : Integer.parseInt(blue_ftf.getText().replace(" ", ""));
        int green = (green_ftf.getText().replace(" ", "").equals(""))? 0 : Integer.parseInt(green_ftf.getText().replace(" ", ""));        
        atualizaCMY_HSV(red, green, blue);
        renderer.setCor(red, green, blue, opcao);
    }
    
    private void atualizaCMY_HSV(int red, int green, int blue){
        ArrayList<Float> cmy = ConversorCor.RGBparaCMY(red, green, blue);
        float cyan = cmy.get(0);
        float magenta = cmy.get(1);
        float yellow = cmy.get(2);
        cyan1_ftf.setText(String.valueOf((int) (cyan/1)));
        cyan2_ftf.setText(String.format("%03d", (int)((cyan*1000)%1000)));
        magenta1_ftf.setText(String.valueOf((int) (magenta/1)));
        magenta2_ftf.setText(String.format("%03d", (int)((magenta*1000)%1000)));
        yellow1_ftf.setText(String.valueOf((int) (yellow/1)));
        yellow2_ftf.setText(String.format("%03d", (int)((yellow*1000)%1000)));
        
        ArrayList<Float> hsv = ConversorCor.RGBparaHSV(red, green, blue);
        float hue = hsv.get(0);
        float sat = hsv.get(1);
        float value = hsv.get(2);
        hue_ftf.setText(String.format("%03d",(int)hue));
        sat1_ftf.setText(String.valueOf((int) (sat/1)));
        sat2_ftf.setText(String.format("%03d", (int)((sat*1000)%1000)));
        value1_ftf.setText(String.valueOf((int) (value/1)));
        value2_ftf.setText(String.format("%03d", (int)((value*1000)%1000)));
                
    }
    
    private void mudaCMY(JFormattedTextField campo, boolean fim){      
        int caretPos = campo.getCaretPosition();
        float cyan = 0, magenta = 0, yellow = 0, tmp;
        if(cyan1_ftf.getText().equals("1")){
            cyan2_ftf.setText("000");
            cyan = 1;
        }else{
            if(fim){
                cyan1_ftf.setText("0");
            }
        }
        tmp = (cyan2_ftf.getText().replace(" ", "").equals(""))? 0 : Float.parseFloat(cyan2_ftf.getText().replace(" ", ""));
        cyan += tmp/1000;
        
        if(magenta1_ftf.getText().equals("1")){
            magenta2_ftf.setText("000");
            magenta = 1;
        }else{
            if(fim){
                magenta1_ftf.setText("0");
            }
        }
        tmp = (magenta2_ftf.getText().replace(" ", "").equals(""))? 0 : Float.parseFloat(magenta2_ftf.getText().replace(" ", ""));
        magenta += tmp/1000;
        
        if(yellow1_ftf.getText().equals("1")){
            yellow2_ftf.setText("000");
            yellow = 1;
        }else{
            if(fim){
                yellow1_ftf.setText("0");
            }
        }
        tmp = (yellow2_ftf.getText().replace(" ", "").equals(""))? 0 : Float.parseFloat(yellow2_ftf.getText().replace(" ", ""));
        yellow += tmp/1000;
        campo.setCaretPosition(caretPos);
        
        if(fim && campo.getText().replace(" ", "").equals("")){
            campo.setText("000");
        }
        
        ArrayList<Integer> rgb = ConversorCor.CMYparaRGB(cyan, magenta, yellow);
        
        atualizaRGB_HSV(rgb.get(0), rgb.get(1), rgb.get(2));
        
        renderer.setCor(rgb.get(0), rgb.get(1), rgb.get(2), opcao);
    }
     
    private void atualizaRGB_HSV(int red, int green, int blue){
        red_ftf.setText(String.format("%03d", red));
        green_ftf.setText(String.format("%03d", green));
        blue_ftf.setText(String.format("%03d", blue));
        
        ArrayList<Float> hsv = ConversorCor.RGBparaHSV(red, green, blue);
        float hue = hsv.get(0);
        float sat = hsv.get(1);
        float value = hsv.get(2);
        hue_ftf.setText(String.format("%03d",(int)hue));
        sat1_ftf.setText(String.valueOf((int) (sat/1)));
        sat2_ftf.setText(String.format("%03d", (int)((sat*1000)%1000)));
        value1_ftf.setText(String.valueOf((int) (value/1)));
        value2_ftf.setText(String.format("%03d", (int)((value*1000)%1000)));
    }
    
    private void mudaHSV(JFormattedTextField campo, boolean fim){
        String hue_txt = hue_ftf.getText().replace(" ", "");
        int hue;
        if(!hue_txt.equals("")){
            hue = Integer.parseUnsignedInt(hue_txt);
            if(hue > 359){
                int carretPos = campo.getCaretPosition();
                hue = 359;
                campo.setText(String.valueOf(hue));
                campo.setCaretPosition(carretPos);
            }
        }else{
            hue = 0;
            if(fim){
                campo.setText("000");
            }
        }        
    
        int caretPos = campo.getCaretPosition();
        float sat = 0, value = 0, tmp;
        if(sat1_ftf.getText().equals("1")){
            sat2_ftf.setText("000");
            sat = 1;
        }else{
            if(fim){
                sat1_ftf.setText("0");
            }
        }
        tmp = (sat2_ftf.getText().replace(" ", "").equals(""))? 0 : Float.parseFloat(sat2_ftf.getText().replace(" ", ""));
        sat += tmp/1000;
        
        if(value1_ftf.getText().equals("1")){
            value2_ftf.setText("000");
            value = 1;
        }else{
            if(fim){
                value1_ftf.setText("0");
            }
        }
        tmp = (value2_ftf.getText().replace(" ", "").equals(""))? 0 : Float.parseFloat(value2_ftf.getText().replace(" ", ""));
        value += tmp/1000;
        
        if(fim && campo.getText().replace(" ", "").equals("")){
            campo.setText("000");
        }
        campo.setCaretPosition(caretPos);
    
        ArrayList<Integer> rgb = ConversorCor.HSVparaRGB(hue, sat, value);
        
        atualizaRGB_CMY(rgb.get(0), rgb.get(1), rgb.get(2));
        
        renderer.setCor(rgb.get(0), rgb.get(1), rgb.get(2), opcao);
    }
    
    private void atualizaRGB_CMY(int red, int green, int blue){
        red_ftf.setText(String.format("%03d", red));
        green_ftf.setText(String.format("%03d", green));
        blue_ftf.setText(String.format("%03d", blue));
    
        ArrayList<Float> cmy = ConversorCor.RGBparaCMY(red, green, blue);
        float cyan = cmy.get(0);
        float magenta = cmy.get(1);
        float yellow = cmy.get(2);
        cyan1_ftf.setText(String.valueOf((int) (cyan/1)));
        cyan2_ftf.setText(String.format("%03d", (int)((cyan*1000)%1000)));
        magenta1_ftf.setText(String.valueOf((int) (magenta/1)));
        magenta2_ftf.setText(String.format("%03d", (int)((magenta*1000)%1000)));
        yellow1_ftf.setText(String.valueOf((int) (yellow/1)));
        yellow2_ftf.setText(String.format("%03d", (int)((yellow*1000)%1000)));
    }
    
    private void mudaFig(Figuras figura){
       ArrayList<Integer> rgb = renderer.getCor(figura);
       
        red_ftf.setText(String.format("%03d", rgb.get(0)));
        green_ftf.setText(String.format("%03d", rgb.get(1)));
        blue_ftf.setText(String.format("%03d", rgb.get(2)));
        mudaRGB(red_ftf, false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelOGL = new javax.swing.JPanel();
        RGB_Panel = new javax.swing.JPanel();
        red_label = new javax.swing.JLabel();
        green_label = new javax.swing.JLabel();
        blue_label = new javax.swing.JLabel();
        green_range = new javax.swing.JLabel();
        red_range = new javax.swing.JLabel();
        blue_range = new javax.swing.JLabel();
        red_ftf = new javax.swing.JFormattedTextField();
        green_ftf = new javax.swing.JFormattedTextField();
        blue_ftf = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        CMY_Panel = new javax.swing.JPanel();
        cyan_label = new javax.swing.JLabel();
        magenta_label = new javax.swing.JLabel();
        yellow_label = new javax.swing.JLabel();
        magenta_range = new javax.swing.JLabel();
        cyan_range = new javax.swing.JLabel();
        yellow_range = new javax.swing.JLabel();
        cyan1_ftf = new javax.swing.JFormattedTextField();
        magenta2_ftf = new javax.swing.JFormattedTextField();
        yellow2_ftf = new javax.swing.JFormattedTextField();
        cyan2_ftf = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        magenta1_ftf = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        yellow1_ftf = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        HSV_Panel = new javax.swing.JPanel();
        hue_label = new javax.swing.JLabel();
        sat_label = new javax.swing.JLabel();
        value_label = new javax.swing.JLabel();
        sat_range = new javax.swing.JLabel();
        hue_range = new javax.swing.JLabel();
        value_range = new javax.swing.JLabel();
        hue_ftf = new javax.swing.JFormattedTextField();
        value2_ftf = new javax.swing.JFormattedTextField();
        sat2_ftf = new javax.swing.JFormattedTextField();
        sat1_ftf = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        value1_ftf = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cubo_button = new javax.swing.JRadioButton();
        cilindro_button = new javax.swing.JRadioButton();
        cone_button = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trabalho de Computação Gráfica");
        setMinimumSize(new java.awt.Dimension(550, 640));

        painelOGL.setPreferredSize(new java.awt.Dimension(507, 529));

        javax.swing.GroupLayout painelOGLLayout = new javax.swing.GroupLayout(painelOGL);
        painelOGL.setLayout(painelOGLLayout);
        painelOGLLayout.setHorizontalGroup(
            painelOGLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
        );
        painelOGLLayout.setVerticalGroup(
            painelOGLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
        );

        RGB_Panel.setBackground(new java.awt.Color(255, 255, 255));
        RGB_Panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        red_label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        red_label.setText("Red:");

        green_label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        green_label.setText("Green:");

        blue_label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        blue_label.setText("Blue:");

        green_range.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        green_range.setText("0-255");

        red_range.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        red_range.setText("0-255");

        blue_range.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        blue_range.setText("0-255");

        red_ftf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        red_ftf.setText("255");
        red_ftf.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        red_ftf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        try{
            MaskFormatter maskID = new MaskFormatter("###");
            maskID.setPlaceholder("255");
            maskID.install(red_ftf);
        }catch(ParseException ex){}

        green_ftf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        green_ftf.setText("255");
        green_ftf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        try{
            MaskFormatter maskID2 = new MaskFormatter("###");
            maskID2.setPlaceholder("000");
            maskID2.install(green_ftf);
        }catch(ParseException ex){}

        blue_ftf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        blue_ftf.setText("255");
        blue_ftf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        try{
            MaskFormatter maskID3 = new MaskFormatter("###");
            maskID3.setPlaceholder("000");
            maskID3.install(blue_ftf);
        }catch(ParseException ex){}

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel6.setText("RGB");

        javax.swing.GroupLayout RGB_PanelLayout = new javax.swing.GroupLayout(RGB_Panel);
        RGB_Panel.setLayout(RGB_PanelLayout);
        RGB_PanelLayout.setHorizontalGroup(
            RGB_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RGB_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RGB_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RGB_PanelLayout.createSequentialGroup()
                        .addGroup(RGB_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(RGB_PanelLayout.createSequentialGroup()
                                .addComponent(red_label)
                                .addGap(24, 24, 24)
                                .addComponent(red_ftf, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(RGB_PanelLayout.createSequentialGroup()
                                .addComponent(blue_label)
                                .addGap(20, 20, 20)
                                .addComponent(blue_ftf, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(RGB_PanelLayout.createSequentialGroup()
                                .addComponent(green_label)
                                .addGap(8, 8, 8)
                                .addComponent(green_ftf, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(RGB_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(red_range)
                            .addComponent(green_range)
                            .addComponent(blue_range)))
                    .addComponent(jLabel6))
                .addContainerGap())
        );
        RGB_PanelLayout.setVerticalGroup(
            RGB_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RGB_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(RGB_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(red_label)
                    .addComponent(red_range)
                    .addComponent(red_ftf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RGB_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(green_label)
                    .addComponent(green_range)
                    .addComponent(green_ftf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RGB_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(blue_label)
                    .addComponent(blue_range)
                    .addComponent(blue_ftf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        red_ftf.setHighlighter(null);
        green_ftf.setHighlighter(null);
        blue_ftf.setHighlighter(null);

        CMY_Panel.setBackground(new java.awt.Color(255, 255, 255));
        CMY_Panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cyan_label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cyan_label.setText("Cyan:");

        magenta_label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        magenta_label.setText("Magenta:");

        yellow_label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        yellow_label.setText("Yellow");

        magenta_range.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        magenta_range.setText("0-1");

        cyan_range.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cyan_range.setText("0-1");

        yellow_range.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        yellow_range.setText("0-1");

        cyan1_ftf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cyan1_ftf.setText("0");
        cyan1_ftf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        try{
            MaskFormatter maskID10 = new MaskFormatter("#");
            maskID10.setPlaceholder("0");
            maskID10.setValidCharacters("01");
            maskID10.install(cyan1_ftf);
        }catch(ParseException ex){}
        cyan1_ftf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cyan1_ftfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cyan1_ftfFocusLost(evt);
            }
        });
        cyan1_ftf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cyan1_ftfKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cyan1_ftfKeyTyped(evt);
            }
        });

        magenta2_ftf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        magenta2_ftf.setText("000");
        magenta2_ftf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        try{
            MaskFormatter maskID5 = new MaskFormatter("###");
            maskID5.setPlaceholder("000");
            maskID5.install(magenta2_ftf);
        }catch(ParseException ex){}

        yellow2_ftf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        yellow2_ftf.setText("000");
        yellow2_ftf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        try{
            MaskFormatter maskID6 = new MaskFormatter("###");
            maskID6.setPlaceholder("000");
            maskID6.install(yellow2_ftf);
        }catch(ParseException ex){}

        cyan2_ftf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cyan2_ftf.setText("000");
        cyan2_ftf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        try{
            MaskFormatter maskID4 = new MaskFormatter("###");
            maskID4.setPlaceholder("000");
            maskID4.install(cyan2_ftf);
        }catch(ParseException ex){}

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText(",");

        magenta1_ftf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        magenta1_ftf.setText("0");
        magenta1_ftf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        try{
            MaskFormatter maskID11 = new MaskFormatter("#");
            maskID11.setPlaceholder("1");
            maskID11.setValidCharacters("01");
            maskID11.install(magenta1_ftf);
        }catch(ParseException ex){}
        magenta1_ftf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                magenta1_ftfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                magenta1_ftfFocusLost(evt);
            }
        });
        magenta1_ftf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                magenta1_ftfKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                magenta1_ftfKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText(",");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText(",");

        yellow1_ftf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        yellow1_ftf.setText("0");
        yellow1_ftf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        try{
            MaskFormatter maskID12 = new MaskFormatter("#");
            maskID12.setPlaceholder("1");
            maskID12.setValidCharacters("01");
            maskID12.install(yellow1_ftf);
        }catch(ParseException ex){}
        yellow1_ftf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                yellow1_ftfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                yellow1_ftfFocusLost(evt);
            }
        });
        yellow1_ftf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                yellow1_ftfKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                yellow1_ftfKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel8.setText("CMY");

        javax.swing.GroupLayout CMY_PanelLayout = new javax.swing.GroupLayout(CMY_Panel);
        CMY_Panel.setLayout(CMY_PanelLayout);
        CMY_PanelLayout.setHorizontalGroup(
            CMY_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CMY_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CMY_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CMY_PanelLayout.createSequentialGroup()
                        .addGroup(CMY_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CMY_PanelLayout.createSequentialGroup()
                                .addComponent(cyan_label)
                                .addGap(38, 38, 38)
                                .addComponent(cyan1_ftf, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel1)
                                .addGap(2, 2, 2)
                                .addComponent(cyan2_ftf, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                            .addGroup(CMY_PanelLayout.createSequentialGroup()
                                .addGroup(CMY_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(CMY_PanelLayout.createSequentialGroup()
                                        .addComponent(magenta_label)
                                        .addGap(10, 10, 10)
                                        .addComponent(magenta1_ftf, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(CMY_PanelLayout.createSequentialGroup()
                                        .addComponent(yellow_label)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(yellow1_ftf, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(2, 2, 2)
                                .addGroup(CMY_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(2, 2, 2)
                                .addGroup(CMY_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(magenta2_ftf)
                                    .addComponent(yellow2_ftf))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CMY_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cyan_range, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(magenta_range, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(yellow_range, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(CMY_PanelLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        CMY_PanelLayout.setVerticalGroup(
            CMY_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CMY_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(11, 11, 11)
                .addGroup(CMY_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cyan_label)
                    .addComponent(cyan_range)
                    .addComponent(cyan1_ftf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cyan2_ftf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CMY_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(magenta_label)
                    .addComponent(magenta_range)
                    .addComponent(magenta2_ftf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(magenta1_ftf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CMY_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yellow_label)
                    .addComponent(yellow_range)
                    .addComponent(yellow2_ftf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(yellow1_ftf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        cyan1_ftf.setHighlighter(null);
        magenta2_ftf.setHighlighter(null);
        yellow2_ftf.setHighlighter(null);
        cyan1_ftf.setHighlighter(null);
        cyan1_ftf.setHighlighter(null);
        cyan1_ftf.setHighlighter(null);

        HSV_Panel.setBackground(new java.awt.Color(255, 255, 255));
        HSV_Panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        hue_label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        hue_label.setText("Hue:");

        sat_label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sat_label.setText("Sat.:");

        value_label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        value_label.setText("Value:");

        sat_range.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sat_range.setText("0-1");

        hue_range.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        hue_range.setText("0-359°");

        value_range.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        value_range.setText("0-1");

        hue_ftf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        hue_ftf.setText("000");
        hue_ftf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        try{
            MaskFormatter maskID7 = new MaskFormatter("###");
            maskID7.setPlaceholder("000");
            maskID7.install(hue_ftf);
        }catch(ParseException ex){}
        hue_ftf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                hue_ftfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                hue_ftfFocusLost(evt);
            }
        });
        hue_ftf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                hue_ftfKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                hue_ftfKeyTyped(evt);
            }
        });

        value2_ftf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        value2_ftf.setText("000");
        value2_ftf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        try{
            MaskFormatter maskID9 = new MaskFormatter("###");
            maskID9.setPlaceholder("000");
            maskID9.install(value2_ftf);
        }catch(ParseException ex){}

        sat2_ftf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sat2_ftf.setText("000");
        sat2_ftf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        try{
            MaskFormatter maskID8 = new MaskFormatter("###");
            maskID8.setPlaceholder("000");
            maskID8.install(sat2_ftf);
        }catch(ParseException ex){}

        sat1_ftf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sat1_ftf.setText("0");
        sat1_ftf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        try{
            MaskFormatter maskID13 = new MaskFormatter("#");
            maskID13.setPlaceholder("1");
            maskID13.setValidCharacters("01");
            maskID13.install(sat1_ftf);
        }catch(ParseException ex){}
        sat1_ftf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sat1_ftfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                sat1_ftfFocusLost(evt);
            }
        });
        sat1_ftf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sat1_ftfKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                sat1_ftfKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText(",");

        value1_ftf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        value1_ftf.setText("0");
        value1_ftf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        try{
            MaskFormatter maskID14 = new MaskFormatter("#");
            maskID14.setPlaceholder("1");
            maskID14.setValidCharacters("01");
            maskID14.install(value1_ftf);
        }catch(ParseException ex){}
        value1_ftf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                value1_ftfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                value1_ftfFocusLost(evt);
            }
        });
        value1_ftf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                value1_ftfKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                value1_ftfKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText(",");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel7.setText("HSV");

        javax.swing.GroupLayout HSV_PanelLayout = new javax.swing.GroupLayout(HSV_Panel);
        HSV_Panel.setLayout(HSV_PanelLayout);
        HSV_PanelLayout.setHorizontalGroup(
            HSV_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HSV_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HSV_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HSV_PanelLayout.createSequentialGroup()
                        .addGroup(HSV_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sat_label)
                            .addComponent(hue_label))
                        .addGap(18, 18, 18)
                        .addGroup(HSV_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HSV_PanelLayout.createSequentialGroup()
                                .addComponent(sat1_ftf, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(sat2_ftf, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(hue_ftf, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(HSV_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HSV_PanelLayout.createSequentialGroup()
                                .addComponent(hue_range)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(HSV_PanelLayout.createSequentialGroup()
                                .addComponent(sat_range)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(HSV_PanelLayout.createSequentialGroup()
                        .addComponent(value_label)
                        .addGap(5, 5, 5)
                        .addComponent(value1_ftf, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(value2_ftf, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(value_range)
                        .addContainerGap(53, Short.MAX_VALUE))
                    .addGroup(HSV_PanelLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        HSV_PanelLayout.setVerticalGroup(
            HSV_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HSV_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(HSV_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hue_label)
                    .addComponent(hue_range)
                    .addComponent(hue_ftf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(HSV_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sat_label)
                    .addComponent(sat_range)
                    .addComponent(sat2_ftf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sat1_ftf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(HSV_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(value_label)
                    .addComponent(value_range)
                    .addComponent(value2_ftf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(value1_ftf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        hue_ftf.setHighlighter(null);
        value2_ftf.setHighlighter(null);
        sat2_ftf.setHighlighter(null);
        cyan1_ftf.setHighlighter(null);
        cyan1_ftf.setHighlighter(null);

        cubo_button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cubo_button.setSelected(true);
        cubo_button.setText("Cubo");
        cubo_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cubo_buttonActionPerformed(evt);
            }
        });

        cilindro_button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cilindro_button.setText("Cilindro");
        cilindro_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cilindro_buttonActionPerformed(evt);
            }
        });

        cone_button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cone_button.setText("Cone");
        cone_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cone_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(painelOGL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(cilindro_button)
                        .addGap(107, 107, 107)
                        .addComponent(cubo_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cone_button)
                        .addGap(40, 40, 40)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CMY_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RGB_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HSV_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(painelOGL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cubo_button)
                            .addComponent(cone_button, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cilindro_button)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(RGB_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CMY_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(HSV_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cyan1_ftfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cyan1_ftfKeyTyped
        if(evt.getKeyChar() == 127){
            cyan1_ftf.setCaretPosition(0);
        }
    }//GEN-LAST:event_cyan1_ftfKeyTyped

    private void magenta1_ftfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_magenta1_ftfKeyTyped
        if(evt.getKeyChar() == 127){
            cyan1_ftf.setCaretPosition(0);
        }
    }//GEN-LAST:event_magenta1_ftfKeyTyped

    private void cyan1_ftfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cyan1_ftfKeyReleased
        if(cyan1_ftf.getText().equals("1")){
            cyan2_ftf.setText("000");
        }
        if(evt.getKeyChar() == 10){
            mudaCMY(cyan1_ftf, true);
        }else{
            mudaCMY(cyan1_ftf, false);
        } 
    }//GEN-LAST:event_cyan1_ftfKeyReleased

    private void magenta1_ftfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_magenta1_ftfKeyReleased
        if(magenta1_ftf.getText().equals("1")){
            magenta2_ftf.setText("000");
        }
        if(evt.getKeyChar() == 10){
            mudaCMY(magenta1_ftf, true);
        }else{
            mudaCMY(magenta1_ftf, false);
        } 
    }//GEN-LAST:event_magenta1_ftfKeyReleased

    private void yellow1_ftfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yellow1_ftfKeyReleased
        if(yellow1_ftf.getText().equals("1")){
            yellow2_ftf.setText("000");
        }
        if(evt.getKeyChar() == 10){
            mudaCMY(yellow1_ftf, true);
        }else{
            mudaCMY(yellow1_ftf, false);
        } 
    }//GEN-LAST:event_yellow1_ftfKeyReleased

    private void yellow1_ftfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yellow1_ftfKeyTyped
        if(evt.getKeyChar() == 127){
            cyan1_ftf.setCaretPosition(0);
        }
    }//GEN-LAST:event_yellow1_ftfKeyTyped

    private void hue_ftfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hue_ftfKeyTyped
        if(evt.getKeyChar() == 127){
            int carretPos = hue_ftf.getCaretPosition();
            hue_ftf.setText(hue_ftf.getText().replace(" ", ""));
            if(carretPos!=0){
                hue_ftf.setCaretPosition(carretPos-1);
            }
        }else if(evt.getKeyChar() == 8){
            int carretPos = hue_ftf.getCaretPosition();
            hue_ftf.setText(hue_ftf.getText().replace(" ", ""));
            hue_ftf.setCaretPosition(carretPos);
        }    
    }//GEN-LAST:event_hue_ftfKeyTyped

    private void hue_ftfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hue_ftfKeyReleased
            if(evt.getKeyChar() == 10){
                mudaHSV(hue_ftf, true);
            }else{
                mudaHSV(hue_ftf, false);
        }  
    }//GEN-LAST:event_hue_ftfKeyReleased

    private void hue_ftfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hue_ftfFocusLost
        mudaHSV(hue_ftf, true);
    }//GEN-LAST:event_hue_ftfFocusLost

    private void yellow1_ftfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_yellow1_ftfFocusLost
        mudaCMY(yellow1_ftf, true);
    }//GEN-LAST:event_yellow1_ftfFocusLost

    private void magenta1_ftfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_magenta1_ftfFocusLost
        mudaCMY(magenta1_ftf, true);
    }//GEN-LAST:event_magenta1_ftfFocusLost

    private void cyan1_ftfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cyan1_ftfFocusLost
        mudaCMY(cyan1_ftf, true);
    }//GEN-LAST:event_cyan1_ftfFocusLost

    private void sat1_ftfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sat1_ftfKeyTyped
        if(evt.getKeyChar() == 127){
            cyan1_ftf.setCaretPosition(0);
        }
    }//GEN-LAST:event_sat1_ftfKeyTyped

    private void sat1_ftfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sat1_ftfKeyReleased
        if(evt.getKeyChar() == 10){
            mudaHSV(sat1_ftf, true);
        }else{
            mudaHSV(sat1_ftf, false);
        } 
    }//GEN-LAST:event_sat1_ftfKeyReleased

    private void sat1_ftfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sat1_ftfFocusLost
        mudaHSV(sat1_ftf, true);
    }//GEN-LAST:event_sat1_ftfFocusLost

    private void value1_ftfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_value1_ftfKeyTyped
        if(evt.getKeyChar() == 127){
            cyan1_ftf.setCaretPosition(0);
        }
    }//GEN-LAST:event_value1_ftfKeyTyped

    private void value1_ftfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_value1_ftfKeyReleased
        if(evt.getKeyChar() == 10){
            mudaHSV(value1_ftf, true);
        }else{
            mudaHSV(value1_ftf, false);
        } 
    }//GEN-LAST:event_value1_ftfKeyReleased

    private void value1_ftfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_value1_ftfFocusLost
        mudaHSV(value1_ftf, true);
    }//GEN-LAST:event_value1_ftfFocusLost

    private void cilindro_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cilindro_buttonActionPerformed
        cubo_button.setSelected(false);
        cone_button.setSelected(false);
        opcao = Figuras.CILINDRO;
        
        mudaFig(Figuras.CILINDRO);
    }//GEN-LAST:event_cilindro_buttonActionPerformed

    private void cubo_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cubo_buttonActionPerformed
        cilindro_button.setSelected(false);
        cone_button.setSelected(false);
        opcao = Figuras.CUBO;
        mudaFig(Figuras.CUBO);
    }//GEN-LAST:event_cubo_buttonActionPerformed

    private void cone_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cone_buttonActionPerformed
        cubo_button.setSelected(false);
        cilindro_button.setSelected(false);
        opcao = Figuras.CONE;
        mudaFig(Figuras.CONE);
    }//GEN-LAST:event_cone_buttonActionPerformed

    private void cyan1_ftfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cyan1_ftfFocusGained
        cyan1_ftf.setCaretPosition(0);
    }//GEN-LAST:event_cyan1_ftfFocusGained

    private void magenta1_ftfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_magenta1_ftfFocusGained
        magenta1_ftf.setCaretPosition(0);
    }//GEN-LAST:event_magenta1_ftfFocusGained

    private void yellow1_ftfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_yellow1_ftfFocusGained
        yellow1_ftf.setCaretPosition(0);
    }//GEN-LAST:event_yellow1_ftfFocusGained

    private void sat1_ftfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sat1_ftfFocusGained
        sat1_ftf.setCaretPosition(0);
    }//GEN-LAST:event_sat1_ftfFocusGained

    private void value1_ftfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_value1_ftfFocusGained
        value1_ftf.setCaretPosition(0);
    }//GEN-LAST:event_value1_ftfFocusGained

    private void hue_ftfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hue_ftfFocusGained
        hue_ftf.setCaretPosition(0);
    }//GEN-LAST:event_hue_ftfFocusGained
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CMY_Panel;
    private javax.swing.JPanel HSV_Panel;
    private javax.swing.JPanel RGB_Panel;
    private javax.swing.JFormattedTextField blue_ftf;
    private javax.swing.JLabel blue_label;
    private javax.swing.JLabel blue_range;
    private javax.swing.JRadioButton cilindro_button;
    private javax.swing.JRadioButton cone_button;
    private javax.swing.JRadioButton cubo_button;
    private javax.swing.JFormattedTextField cyan1_ftf;
    private javax.swing.JFormattedTextField cyan2_ftf;
    private javax.swing.JLabel cyan_label;
    private javax.swing.JLabel cyan_range;
    private javax.swing.JFormattedTextField green_ftf;
    private javax.swing.JLabel green_label;
    private javax.swing.JLabel green_range;
    private javax.swing.JFormattedTextField hue_ftf;
    private javax.swing.JLabel hue_label;
    private javax.swing.JLabel hue_range;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JFormattedTextField magenta1_ftf;
    private javax.swing.JFormattedTextField magenta2_ftf;
    private javax.swing.JLabel magenta_label;
    private javax.swing.JLabel magenta_range;
    private javax.swing.JPanel painelOGL;
    private javax.swing.JFormattedTextField red_ftf;
    private javax.swing.JLabel red_label;
    private javax.swing.JLabel red_range;
    private javax.swing.JFormattedTextField sat1_ftf;
    private javax.swing.JFormattedTextField sat2_ftf;
    private javax.swing.JLabel sat_label;
    private javax.swing.JLabel sat_range;
    private javax.swing.JFormattedTextField value1_ftf;
    private javax.swing.JFormattedTextField value2_ftf;
    private javax.swing.JLabel value_label;
    private javax.swing.JLabel value_range;
    private javax.swing.JFormattedTextField yellow1_ftf;
    private javax.swing.JFormattedTextField yellow2_ftf;
    private javax.swing.JLabel yellow_label;
    private javax.swing.JLabel yellow_range;
    // End of variables declaration//GEN-END:variables


}
