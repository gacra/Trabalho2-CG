package trabalho.cg;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Guilherme
 */
public class ConversorCor{
  
    static ArrayList<Float> RGBparaCMY(int red, int green, int blue){
        ArrayList<Float> cmy = new ArrayList<>(3);
        
        cmy.add(0, Float.valueOf(1-(red/255f)));
        cmy.add(1, Float.valueOf(1-(green/255f)));
        cmy.add(2, Float.valueOf(1-(blue/255f)));
        
        return cmy;
    }
    
    static ArrayList<Float> RGBparaHSV(int red, int green, int blue){
        ArrayList<Float> hsv = new ArrayList<>(3);
        ArrayList<Float> rgb_f = new ArrayList<>(3);
        
        float red_f = red/255f;
        float green_f = green/255f;
        float blue_f = blue/255f;
        
        rgb_f.add(0, red_f);
        rgb_f.add(1, green_f);
        rgb_f.add(2, blue_f);
        
        float c_max = Collections.max(rgb_f);
        int indice_max = rgb_f.indexOf(c_max);
        float c_min = Collections.min(rgb_f);
        float delta = c_max - c_min;
        
                
        float h;
        if(delta == 0){
            h = 0;
        }else if(indice_max == 0){
            h = 60 * (((green_f-blue_f)/delta)%6);
        }else if(indice_max == 1){
            h = 60 * (((blue_f-red_f)/delta)+2);
        }else{
            h = 60 * (((red_f-green_f)/delta)+4);
        }
        
        if(h<0){
            h += 360;
        }
        float s;
        if(c_max==0){
            s = 0;
        }else{
            s = delta/c_max;
        }
        
        float v = c_max;
        
        hsv.add(0, h);
        hsv.add(1, s);
        hsv.add(2, v);
        
        return  hsv;
    }
    
    static ArrayList<Integer> CMYparaRGB(float cyan, float magenta, float yellow){
        ArrayList<Integer> rgb = new ArrayList<>(3);
        
        rgb.add(0, (int) ((1-cyan)*255));
        rgb.add(1, (int) ((1-magenta)*255));
        rgb.add(2, (int) ((1-yellow)*255));
        
        return rgb;
    }
    
    static ArrayList<Integer> HSVparaRGB(int hue, float sat, float value){
        ArrayList<Integer> rgb = new ArrayList<>(3);
        
        float c = value * sat;
        float x = c * (1 - Math.abs( ( (hue/60f) % 2 ) -1 ));
        float m = value - c;
        
        float r_, g_, b_;
        
        if(hue<60){
           r_ = c;
           g_ = x;
           b_ = 0;
        }else if(hue<120){
           r_ = x;
           g_ = c;
           b_ = 0;
        }else if(hue<180){
           r_ = 0;
           g_ = c;
           b_ = x;
        }else if(hue<240){
           r_ = 0;
           g_ = x;
           b_ = c;
        }else if(hue<300){
           r_ = x;
           g_ = 0;
           b_ = c;
        }else{
           r_ = c;
           g_ = 0;
           b_ = x;
        }
        
        int red = (int) ((r_ + m) * 255);
        int green = (int) ((g_ + m) * 255);
        int blue = (int) ((b_ + m) * 255);
        
        rgb.add(0, red);
        rgb.add(1, green);
        rgb.add(2, blue);
        
        return rgb;
    }
}
