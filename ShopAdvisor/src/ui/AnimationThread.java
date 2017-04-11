package ui;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.util.Duration;

public class AnimationThread extends Thread {

    Node node;

    public AnimationThread(Node node) {
        this.node = node;
    }

    public void run() {
        
        RotateAnimate();
    }

    void RotateAnimate() {
        RotateTransition rt = new RotateTransition();
        rt.setNode(node);
        rt.setFromAngle(0);
        rt.setToAngle(360);
        rt.setInterpolator(Interpolator.LINEAR);
        rt.setCycleCount(Timeline.INDEFINITE);
        rt.setDuration(new Duration(8000));
        rt.play();  
    }

}
