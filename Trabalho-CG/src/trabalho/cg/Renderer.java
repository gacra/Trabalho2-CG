package trabalho.cg;

import com.sun.opengl.util.GLUT;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.event.MouseInputListener;

/**
 * Responsável pela renderização dos objetos.
 */
public class Renderer implements  GLEventListener, MouseInputListener, KeyListener{
    private final GLCanvas canvas;  //Canvas do OpenGL
    private GL gl;
    private GLU glu;
    private GLUT glut;
    float red_cubo, green_cubo, blue_cubo; //Cor dos objetos
    float red_cone, green_cone, blue_cone;
    float red_cilindro, green_cilindro, blue_cilindro;
    float scale = 1.0f;
    float rotation_x = 0;
    float rotation_y = 0;
    float rotation_z = 0;
    //False: Perspectiva
    //True: Ortogonal
    boolean tipo_projecao = false;
            
    public Renderer(GLCanvas canvas){
        this.canvas = canvas;
        //Vermelho
        red_cubo = red_cone = red_cilindro = 1.0f;
        green_cubo = green_cone = green_cilindro = 0.0f;
        blue_cubo = blue_cone = blue_cilindro = 0.0f;
    }
    
    @Override
    public void init(GLAutoDrawable drawable){
        gl = drawable.getGL();
        glut = new GLUT();
        glu = new GLU();
        
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);    //Cor de fundo
        gl.glEnable(GL.GL_DEPTH_TEST);  //Habilita o testde de profundidade        
    }

    /**
     * Desenha os objetos
     */
    @Override
    public void display(GLAutoDrawable drawable){
        gl.glLoadIdentity();
        //Posição da câmera
        glu.gluLookAt(0.0, 0.0, 10.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        if(tipo_projecao){
            gl.glOrtho(-5, 5, -5, 5, -1, 100);
        }else{
            glu.gluPerspective(45.0, 1.0, 1.0f, 100.0f);   
        }
        gl.glMatrixMode(GL.GL_MODELVIEW);
        
        //Limpa o buffer
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
         
        
        gl.glScaled(scale, scale, scale);
        gl.glRotatef(rotation_x - 40.0f, 1.0f, 0.0f, 0.0f);
        gl.glRotatef(rotation_y, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(rotation_z, 0.0f, 0.0f, 1.0f);
        
        //Desenha um cubo
        gl.glColor3f(red_cubo, green_cubo, blue_cubo);
        glut.glutSolidCube(1.0f);
        gl.glColor3f(0.0f, 0.0f, 0.0f);
        glut.glutWireCube(1.0f);
        
        gl.glTranslated(2.0, 0.0, -1.0);
        gl.glColor3f(red_cone, green_cone, blue_cone);
        glut.glutSolidCone(1.0, 2.0, 20, 20);
        gl.glColor3f(0.0f, 0.0f, 0.0f);
        glut.glutWireCone(1.0, 2.0, 20, 20);
        
        gl.glTranslated(-4.0, 0.0, 0.0);
        gl.glColor3f(red_cilindro, green_cilindro, blue_cilindro);
        glut.glutSolidCylinder(1.0, 2.0, 20, 20);
        gl.glColor3f(0.0f, 0.0f, 0.0f);
        glut.glutWireCylinder(1.0, 2.0, 20, 20);

        //Força o desenho das primitivas
        gl.glFlush();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height){

    }
    
     /**
     * Recebe as coordenadas da tela, converte em coordenadas do canvas,
     * e adiciona o ponto na PreePol.
     */
    @Override
    public void mousePressed(java.awt.event.MouseEvent e){}
    
    
    /**
     * Muda a cor dos objetos.
     * @param red Vermelho no RGB (0-255)
     * @param green Verde no RGB (0-255)
     * @param blue Azul do RGB (0-255)
     */
    public void setCor(int red, int green, int blue, Figuras figura){        
        switch(figura){
            case CUBO:
                red_cubo = red/255f;
                green_cubo = green/255f;
                blue_cubo = blue/255f;
                break;
            case CILINDRO:
                red_cilindro = red/255f;
                green_cilindro = green/255f;
                blue_cilindro = blue/255f;
                break;
            case CONE:
                red_cone = red/255f;
                green_cone = green/255f;
                blue_cone = blue/255f;
                break;
        }
        canvas.display();
    }
    
    public ArrayList<Integer> getCor(Figuras figura){
        ArrayList<Integer> rgb = new ArrayList<>(3);
        
        switch(figura){
            case CUBO:
                rgb.add(0, (int)(red_cubo*255));
                rgb.add(1, (int)(green_cubo*255));
                rgb.add(2, (int)(blue_cubo*255));
                break;
            case CILINDRO:
                rgb.add(0, (int)(red_cilindro*255));
                rgb.add(1, (int)(green_cilindro*255));
                rgb.add(2, (int)(blue_cilindro*255));
                break;
            case CONE:
                rgb.add(0, (int)(red_cone*255));
                rgb.add(1, (int)(green_cone*255));
                rgb.add(2, (int)(blue_cone*255));
                break;    
        }
        
        return rgb;
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        if(e.isControlDown()){
            switch(e.getKeyCode()){
                case KeyEvent.VK_EQUALS: case KeyEvent.VK_PLUS:
                    scale *= 1.1;
                    break;
                case KeyEvent.VK_MINUS: case KeyEvent.VK_UNDERSCORE:
                    scale *= 0.9;
                break;
            } 
        }else{
            switch(e.getKeyCode()){
                case KeyEvent.VK_UP : case KeyEvent.VK_KP_UP:
                    rotation_x += 10;
                    break;
                case KeyEvent.VK_DOWN : case KeyEvent.VK_KP_DOWN:
                    rotation_x -= 10;
                    break;
                case KeyEvent.VK_RIGHT: case KeyEvent.VK_KP_RIGHT:
                    rotation_z += 10;
                    break;
                case KeyEvent.VK_LEFT: case KeyEvent.VK_KP_LEFT:
                    rotation_z -= 10;
                    break;
                case KeyEvent.VK_P:
                    tipo_projecao = !tipo_projecao;
            }
        
        
        }
        
        canvas.display();
    }
    
    //Métodos sobrescritos mas não usados
        
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e){}
    
    @Override
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged){}

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e){}

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e){

    
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e){}

    @Override
    public void mouseDragged(java.awt.event.MouseEvent e){}

    @Override
    public void mouseMoved(java.awt.event.MouseEvent e){}  

    @Override
    public void keyTyped(KeyEvent e){}

    @Override
    public void keyReleased(KeyEvent e){}
    
}